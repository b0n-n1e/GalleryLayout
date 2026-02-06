package com.bonnie.gallerylayout

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Color
import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.util.AttributeSet
import android.view.Gravity
import android.view.MotionEvent
import android.view.animation.PathInterpolator
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import android.graphics.Typeface
import android.util.TypedValue
import android.graphics.LinearGradient
import android.graphics.Matrix
import androidx.core.graphics.toColorInt
import android.graphics.drawable.Animatable
import android.widget.ImageView
import com.bonnie.gallerylayout.controller.*

class GalleryView @JvmOverloads constructor(    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    companion object {
        private const val DEFAULT_AUTO_PLAY_INTERVAL = 5000L
        private const val RESUME_DELAY = 5000L
        private const val GRADIENT_ANIM_DURATION = 1500L
        private const val SCROLL_ANIM_DURATION = 1200L
        private const val TITLE_MARGIN_TOP_DP = 20f
        private const val TITLE_TEXT_SIZE_DP = 16f
        private const val TITLE_LINE_HEIGHT_DP = 24f
        private const val TITLE_TRANSLATION_Y_MAX_DP = 26f
        private const val TITLE_BLUR_MAX = 40f
    }

    // Controllers (Delegates)
    private val mediaController: IMediaController = DefaultMediaController()
    private val entranceAnimator: IEntranceAnimator = DefaultEntranceAnimator()
    private val textEffectController: ITextEffectController = GradientTextEffectController()

    private val viewPager: ViewPager2 = ViewPager2(context)
    
    // 标题视图，用于实现交叉淡入淡出动画
    private val titleContainer: FrameLayout
    private val textView1: TextView
    private val textView2: TextView
    private var isTextView1Active = true // 跟踪当前显示标题的 TextView
    
    private var galleryItems: List<GalleryItem> = emptyList()
    
    // 自动轮播相关
    private var isAutoPlayEnabled = false
    private var autoPlayInterval = DEFAULT_AUTO_PLAY_INTERVAL // 默认 5 秒
    private var currentAnimator: ValueAnimator? = null // 保存当前动画引用
    
    // 交互恢复相关
    private val resumeAutoPlayRunnable = Runnable { startAutoPlay() }

    private val autoPlayRunnable = object : Runnable {
        override fun run() {
            if (!isAutoPlayEnabled || viewPager.adapter == null || viewPager.adapter!!.itemCount <= 1) {
                return
            }
            performCustomScroll()
            postDelayed(this, autoPlayInterval)
        }
    }

    init {
        orientation = VERTICAL
        gravity = Gravity.CENTER_HORIZONTAL
        
        // 1. 设置 ViewPager2
        val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        viewPager.layoutParams = params
        viewPager.clipToPadding = false
        viewPager.clipChildren = false
        viewPager.offscreenPageLimit = 3
        
        val recyclerView = viewPager.getChildAt(0) as RecyclerView
        recyclerView.clipToPadding = false
        recyclerView.clipChildren = false
        recyclerView.overScrollMode = OVER_SCROLL_NEVER

        addView(viewPager)
        
        viewPager.setPageTransformer(GalleryTransformer())
        
        // 2. 设置标题视图
        titleContainer = FrameLayout(context)
        titleContainer.clipChildren = false // 允许文字动画超出容器边界
        
        val titleParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        // 在底部增加额外的 Padding 以适应向下的动画位移
        // 最大向下位移为 26dp + 文字高度
        titleParams.bottomMargin = 100 // 安全边距
        titleContainer.layoutParams = titleParams
        
        // 初始时不显示，等待 setCardHeight 调整位置
        titleContainer.visibility = INVISIBLE
        
        textView1 = createTitleTextView(context)
        textView2 = createTitleTextView(context)
        textView2.alpha = 0f // Initially hidden
        
        titleContainer.addView(textView1)
        titleContainer.addView(textView2)
        addView(titleContainer)
        
        // 设置 GalleryView 的 clipChildren 为 false 以允许绘制超出边界的内容
        this.clipChildren = false
        
        // 3. 注册页面变更回调
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                updateTitleOnScroll(position, positionOffset)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                // updateTitle(position) // 已移除，改用 onPageScrolled 处理
                updateGifPlayback() // 页面选中时更新 GIF 状态
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                if (state == ViewPager2.SCROLL_STATE_DRAGGING) {
                    stopAutoPlay()
                    removeCallbacks(resumeAutoPlayRunnable)
                    gradientAnimator?.cancel() // 拖拽时取消流光动画
                    updateTextGradient(textView1, -1f)
                    updateTextGradient(textView2, -1f)
                    // 拖拽时也可以考虑暂停所有 GIF，或保持现状
                    // updateGifPlayback() 
                } else if (state == ViewPager2.SCROLL_STATE_IDLE) {
                    // 在 IDLE 状态下触发当前 TextView 的流光动画
                    // 此时 textView1 持有当前标题 (基于 updateTitleOnScroll 逻辑)
                    startGradientFlow(textView1)
                    updateGifPlayback() // IDLE 状态确保只有中心 GIF 播放
                    
                    if (isAutoPlayEnabled) {
                        removeCallbacks(resumeAutoPlayRunnable)
                        postDelayed(resumeAutoPlayRunnable, RESUME_DELAY)
                    }
                }
            }
        })
    }
    
    /**
     * 更新 GIF 播放状态
     * 只有位于中心的 Item 才会播放 GIF，其他 Item 停止播放
     */
    private fun updateGifPlayback() {
        val recyclerView = viewPager.getChildAt(0) as RecyclerView
        mediaController.updatePlaybackState(recyclerView, viewPager.currentItem)
    }

    /**
     * 设置卡片高度，用于定位文案
     * 文案将显示在卡片正下方
     * @param heightPx 卡片的像素高度
     */
    fun setCardHeight(heightPx: Int) {
        // 更新 ViewPager 高度为卡片高度
        val params = viewPager.layoutParams
        params.height = heightPx
        viewPager.layoutParams = params
        
        // 设置文案容器的上边距 (60px 约 20dp)
        val titleParams = titleContainer.layoutParams as LayoutParams
        titleParams.topMargin = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            20f,
            context.resources.displayMetrics
        ).toInt()
        titleContainer.layoutParams = titleParams
        
        titleContainer.visibility = VISIBLE
    }
    
    private fun createTitleTextView(context: Context): TextView {
        val textView = TextView(context)
        val params = FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT)
        params.gravity = Gravity.CENTER_HORIZONTAL
        textView.layoutParams = params
        
        // 字体样式
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16f)
        
        // 字体系列: Noto Serif Display, Weight 500 (Medium), Italic
        // 使用标准衬线斜体作为近似替代
        textView.typeface = Typeface.create("serif", Typeface.ITALIC)
        
        // 行高 24dp
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val lineHeightPx = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 
                24f, 
                context.resources.displayMetrics
            ).toInt()
            textView.lineHeight = lineHeightPx
        }
        
        textView.gravity = Gravity.CENTER
        
        // 渐变文字颜色 (模拟 CSS 的 "background: linear-gradient..." 应用于文本)
        // White (0.8) -> #ADF01D -> White (0.8)
        // 假设用户希望文本具有这种渐变颜色。
        textView.setTextColor(Color.WHITE) // 兜底颜色
        
                textView.addOnLayoutChangeListener { v, left, top, right, bottom, _, _, _, _ ->
            val width = right - left
            if (width > 0) {
                 // 初始化或更新 Shader
                 updateTextGradient(textView, -1f)
            }
        }

        return textView
    }

    // 流光动画 Animator
    private var gradientAnimator: ValueAnimator? = null

    /**
     * 开启流光渐变动画
     *
     * 逻辑说明：
     * 1. **开始状态**：渐变光效隐藏在左侧（偏移量为 -width），文案显示为纯白色。
     * 2. **动画过程**：渐变窗口从左向右移动（-width -> +width）。
     *    - 当偏移为 -width 时：Shader 右边缘对应文案左边缘（白色）。
     *    - 当偏移为 0 时：Shader 中心对应文案中心（绿色高光）。
     *    - 当偏移为 +width 时：Shader 左边缘对应文案右边缘（白色）。
     * 3. **结束状态**：渐变光效隐藏在右侧（偏移量为 +width），文案恢复为纯白色。
     *
     * @param textView 需要执行动画的 TextView
     */
    private fun startGradientFlow(textView: TextView) {
        gradientAnimator?.cancel()
        
        // Reset gradient first (ensure hidden left)
        updateTextGradient(textView, -1f)
        
        val animator = ValueAnimator.ofFloat(0f, 1f)
        animator.duration = GRADIENT_ANIM_DURATION // Duration
        animator.interpolator = PathInterpolator(0.2f, 0f, 0.2f, 1f) // Smooth ease-in-out
        
        animator.addUpdateListener { animation ->
            val progress = animation.animatedValue as Float
            updateTextGradient(textView, progress)
        }
        
        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                // Ensure reset at end (hide right or reset to left? User wants NO green at end)
                // If we leave it at +width (progress=1.0), it is White.
                // But let's explicitly reset to "clean" state (-1f) just in case of resize/redraw issues.
                updateTextGradient(textView, -1f)
            }
        })
        
        gradientAnimator = animator
        animator.start()
    }

    private fun updateTitleOnScroll(position: Int, positionOffset: Float) {
        if (galleryItems.isEmpty()) return

        val currentRealIndex = position % galleryItems.size
        val nextRealIndex = (position + 1) % galleryItems.size

        val currentTitle = galleryItems[currentRealIndex].title
        val nextTitle = galleryItems[nextRealIndex].title

        textView1.text = currentTitle
        textView2.text = nextTitle

        val density = context.resources.displayMetrics.density
        val translationYMax = TITLE_TRANSLATION_Y_MAX_DP * density 
        val blurMax = TITLE_BLUR_MAX

        // 1. 位置与透明度动画
        textView1.translationY = translationYMax * positionOffset
        textView1.alpha = 1f - positionOffset
        
        textView2.translationY = translationYMax * (1f - positionOffset)
        textView2.alpha = positionOffset

        // 2. 模糊效果
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val blur1 = blurMax * positionOffset
            textView1.setRenderEffect(if (blur1 > 0) RenderEffect.createBlurEffect(blur1, blur1, Shader.TileMode.CLAMP) else null)
            
            val blur2 = blurMax * (1f - positionOffset)
            textView2.setRenderEffect(if (blur2 > 0) RenderEffect.createBlurEffect(blur2, blur2, Shader.TileMode.CLAMP) else null)
        }

        // 3. 滚动期间重置渐变
        updateTextGradient(textView1, -1f)
        updateTextGradient(textView2, -1f)
    }
    
    // 缓存对象，避免在 onDraw 或频繁调用中创建
    // private val gradientMatrix = Matrix() // Moved to GradientTextEffectController
    // private val white80Color = Color.argb((255 * 0.8).toInt(), 255, 255, 255) // Moved
    // private val limeColor = "#ADF01D".toColorInt() // Moved
    // private val gradientColors = intArrayOf(white80Color, limeColor, white80Color) // Moved
    // private val gradientPositions = floatArrayOf(0f, 0.5f, 1f) // Moved
    
    // 缓存上一次的参数，避免重复创建 Shader
    // private var lastShaderWidth = 0f // Moved

    private fun updateTextGradient(textView: TextView, progress: Float) {
        textEffectController.updateTextGradient(textView, progress)
    }

    private fun updateTitle(position: Int) {
        // 仅在初始化时设置
        if (galleryItems.isEmpty()) return
        val realIndex = position % galleryItems.size
        textView1.text = galleryItems[realIndex].title
        textView1.alpha = 1f
        textView1.translationY = 0f
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            textView1.setRenderEffect(null)
        }
        textView2.alpha = 0f
        
        // 触发初始流光动画
        startGradientFlow(textView1)
    }
    
    /**
     * 设置页面间距
     */
    fun setPagePadding(paddingHorizontal: Int) {
         viewPager.setPadding(paddingHorizontal, 0, paddingHorizontal, 0)
    }

    /**
     * 执行自定义滑动动画
     */
    private fun performCustomScroll() {
        val recyclerView = viewPager.getChildAt(0) as RecyclerView
        if (recyclerView.layoutManager == null) return
        
        val width = width
        if (width == 0) return

        if (!viewPager.beginFakeDrag()) return

        val scrollDistance = width - viewPager.paddingLeft - viewPager.paddingRight
        val targetDistance = if (scrollDistance > 0) scrollDistance else width

        val animator = ValueAnimator.ofInt(0, targetDistance)
        animator.duration = SCROLL_ANIM_DURATION
        animator.interpolator = PathInterpolator(0.8f, 0.05f, 0.24f, 0.98f)
        
        var previousValue = 0
        animator.addUpdateListener { animation ->
            val currentValue = animation.animatedValue as Int
            val delta = currentValue - previousValue
            previousValue = currentValue
            
            if (viewPager.isFakeDragging) {
                viewPager.fakeDragBy(-delta.toFloat())
            }
        }
        
        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                if (viewPager.isFakeDragging) {
                    viewPager.endFakeDrag()
                }
                currentAnimator = null
            }
            
            override fun onAnimationCancel(animation: Animator) {
                 if (viewPager.isFakeDragging) {
                    viewPager.endFakeDrag()
                }
                currentAnimator = null
            }
        })
        
        currentAnimator = animator
        animator.start()
    }

    /**
     * 设置适配器
     */
    fun setAdapter(adapter: RecyclerView.Adapter<*>) {
        viewPager.adapter = adapter
    }
    
    private var onItemClickListener: ((GalleryItem) -> Unit)? = null

    /**
     * 设置点击事件监听器
     * 当用户点击处于中心位置的卡片时触发
     */
    fun setOnItemClickListener(listener: (GalleryItem) -> Unit) {
        this.onItemClickListener = listener
    }

    /**
     * 设置画廊数据并初始化视图
     */
    fun setGalleryData(items: List<GalleryItem>) {
        this.galleryItems = items
        if (items.isEmpty()) return
        
        val adapter = GalleryAdapter(items, onItemClick = { position ->
            // 只有点击当前选中的 item 时才触发回调
            val currentPosition = viewPager.currentItem
            if (position == currentPosition) {
                val realIndex = position % items.size
                onItemClickListener?.invoke(items[realIndex])
            } else {
                // 如果点击的是侧边的卡片，可以选择滚动到该卡片（可选优化体验）
                viewPager.currentItem = position
            }
        })
        viewPager.adapter = adapter
        
        if (items.size > 1) {
            val centerOfInfinite = Int.MAX_VALUE / 2
            val realCenterIndex = items.size / 2
            val startPosition = centerOfInfinite - (centerOfInfinite % items.size) + realCenterIndex
            viewPager.setCurrentItem(startPosition, false)
            // Initial title
            updateTitle(startPosition)
        } else {
            viewPager.setCurrentItem(0, false)
            updateTitle(0)
        }
        
        // 初始设置 GIF 状态 (延迟一下确保 View 已经布局)
        post { updateGifPlayback() }

        if (isAutoPlayEnabled && items.size > 1) {
            startAutoPlay()
        }
    }
    
    // 兼容旧方法 (Optional, creates dummy titles)
    fun setImageUrls(urls: List<String>) {
        val items = urls.map { GalleryItem(it, "") }
        setGalleryData(items)
    }
    
    /**
     * 开启自动轮播
     * @param interval 轮播间隔时间，单位毫秒 (默认: 5000ms)
     */
    fun enableAutoPlay(interval: Long = 5000L) {
        this.autoPlayInterval = interval
        this.isAutoPlayEnabled = true
        startAutoPlay()
    }
    
    /**
     * 停止自动轮播
     */
    fun disableAutoPlay() {
        this.isAutoPlayEnabled = false
        stopAutoPlay()
        removeCallbacks(resumeAutoPlayRunnable)
    }
    
    private fun startAutoPlay() {
        stopAutoPlay()
        if (isAutoPlayEnabled && viewPager.adapter != null && viewPager.adapter!!.itemCount > 1) {
            postDelayed(autoPlayRunnable, autoPlayInterval)
        }
    }
    
    private fun stopAutoPlay() {
        removeCallbacks(autoPlayRunnable)
        currentAnimator?.cancel()
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (isAutoPlayEnabled) {
            when (ev.action) {
                MotionEvent.ACTION_DOWN -> stopAutoPlay()
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    removeCallbacks(resumeAutoPlayRunnable)
                    postDelayed(resumeAutoPlayRunnable, RESUME_DELAY)
                }
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        if (isAutoPlayEnabled) {
            startAutoPlay()
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        stopAutoPlay()
        removeCallbacks(resumeAutoPlayRunnable)
        gradientAnimator?.cancel() // 防止流光动画导致的内存泄露
    }
    
    fun getViewPager(): ViewPager2 = viewPager

    /**
     * 获取当前选中的画廊项目
     * @return 当前展示的 GalleryItem，如果列表为空则返回 null
     */
    fun getCurrentItem(): GalleryItem? {
        if (galleryItems.isEmpty()) return null
        val currentPosition = viewPager.currentItem
        val realIndex = currentPosition % galleryItems.size
        return galleryItems[realIndex]
    }

    /**
     * 获取真实的数据项数量
     */
    fun getItemCount(): Int {
        return galleryItems.size
    }

    /**
     * 播放开场动画
     * 1. 卡片：透明度 0->1, 放大, 模糊 80->0
     * 2. 文案：透明度 0.6->1, 上移 46dp->0, 模糊 28->0
     */
    fun playEntranceAnimation() {
        val recyclerView = viewPager.getChildAt(0) as RecyclerView
        entranceAnimator.playAnimation(recyclerView, textView1)
    }
}
