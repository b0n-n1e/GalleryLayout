package com.bonnie.gallerylayout.app

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.animation.Animator
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.animation.PathInterpolator
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bonnie.gallerylayout.GalleryItem
import com.bonnie.gallerylayout.GalleryView
import com.bonnie.gallerylayout.imageloader.GlideImageLoader
import com.bonnie.gallerylayout.imageloader.ImageLoadManager
import androidx.core.graphics.toColorInt
import com.bonnie.gallerylayout.app.R

class MainActivity : AppCompatActivity() {

    companion object {
        private const val ANIM_DURATION = 1800L
        private const val TITLE_START_Y_DP = 54f
        private const val BUTTON_START_Y_DP = 49f
        private const val TITLE_BLUR_START = 28f
        private const val BUTTON_TRANSLATION_Y_MAX_DP = 10f // 按钮文字动画位移
        private const val BUTTON_BLUR_MAX = 10f
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Generate data with button text
        val galleryItems = listOf(
            GalleryItem("https://p3-dcd.byteimg.com/tos-cn-i-qvj2lq49k0/2776c53e05a044249a2a792429497e74~tplv-qvj2lq49k0-image.image", "优雅职场风", "立即体验"),
            GalleryItem("https://p3-dcd.byteimg.com/tos-cn-i-qvj2lq49k0/a746a5f777c943779f42a927a77d7d24~tplv-qvj2lq49k0-image.image", "休闲运动风", "查看详情"),
            GalleryItem("https://p3-dcd.byteimg.com/tos-cn-i-qvj2lq49k0/a746a5f777c943779f42a927a77d7d24~tplv-qvj2lq49k0-image.image", "浪漫约会风", "去试试"),
            GalleryItem("https://p3-dcd.byteimg.com/tos-cn-i-qvj2lq49k0/2776c53e05a044249a2a792429497e74~tplv-qvj2lq49k0-image.image", "酷飒街头风", "解锁造型"),
            GalleryItem("https://p3-dcd.byteimg.com/tos-cn-i-qvj2lq49k0/2776c53e05a044249a2a792429497e74~tplv-qvj2lq49k0-image.image", "温婉居家风", "立即查看"),
            GalleryItem("https://p3-dcd.byteimg.com/tos-cn-i-qvj2lq49k0/a746a5f777c943779f42a927a77d7d24~tplv-qvj2lq49k0-image.image", "复古文艺风", "开启探索")
        )

        val galleryView = findViewById<GalleryView>(R.id.galleryView)
        galleryView.setGalleryData(galleryItems)
        
        // 设置滚动监听，实现按钮文字联动动画
        galleryView.setOnScrollListener(object : GalleryView.OnScrollListener {
            override fun onScroll(position: Int, positionOffset: Float, currentItem: GalleryItem?, nextItem: GalleryItem?) {
                updateButtonTextAnimation(positionOffset, currentItem?.buttonText, nextItem?.buttonText)
            }
        })

        // Apply text styles
        setupHeader()
        
        // Start entrance animations
        playEntranceAnimations()
    }

    private fun updateButtonTextAnimation(positionOffset: Float, currentText: String?, nextText: String?) {
        val tvButton1 = findViewById<TextView>(R.id.tvButton1)
        val tvButton2 = findViewById<TextView>(R.id.tvButton2)
        
        tvButton1.text = currentText ?: ""
        tvButton2.text = nextText ?: ""
        
        val displayMetrics = resources.displayMetrics
        val translationYMax = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, BUTTON_TRANSLATION_Y_MAX_DP, displayMetrics)
        
        // 动画逻辑与 Title 保持一致：
        // 当前文字(tvButton1): 向上移动，透明度降低
        // 下一个文字(tvButton2): 从下向上移动，透明度增加
        
        tvButton1.translationY = -translationYMax * positionOffset
        tvButton1.alpha = 1f - positionOffset
        
        tvButton2.translationY = translationYMax * (1f - positionOffset)
        tvButton2.alpha = positionOffset
        
        // 动态模糊 (Android 12+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val blurMax = BUTTON_BLUR_MAX
            val blur1 = blurMax * positionOffset
            val blur2 = blurMax * (1f - positionOffset)
            
            tvButton1.setRenderEffect(if (blur1 > 0) RenderEffect.createBlurEffect(blur1, blur1, Shader.TileMode.CLAMP) else null)
            tvButton2.setRenderEffect(if (blur2 > 0) RenderEffect.createBlurEffect(blur2, blur2, Shader.TileMode.CLAMP) else null)
        }
        
        // 确保可见性状态
        tvButton1.visibility = View.VISIBLE
        tvButton2.visibility = View.VISIBLE
    }

    /**
     * 执行入场动画
     * 编排所有组件（标题、按钮、画廊）的入场顺序和效果
     */
    private fun playEntranceAnimations() {
        val galleryView = findViewById<GalleryView>(R.id.galleryView)
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val tvSubtitle = findViewById<TextView>(R.id.tvSubtitle)
        val btnExplore = findViewById<View>(R.id.btnExplore)

        // 动画参数
        val interpolator = PathInterpolator(0.74f, 0f, 0.24f, 1f)
        val displayMetrics = resources.displayMetrics
        
        val allAnimators = mutableListOf<Animator>()

        // 1. 标题动画 (Welcome + Subtitle)
        val titleViews = listOf(tvWelcome, tvSubtitle)
        val titleStartY = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, TITLE_START_Y_DP, displayMetrics)

        titleViews.forEach { view ->
            // 初始状态已在 XML 中设为不可见 (alpha=0)
            view.translationY = titleStartY
            
            val alphaAnim = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)
            val transAnim = ObjectAnimator.ofFloat(view, "translationY", titleStartY, 0f)
            
            val animSet = AnimatorSet()
            animSet.playTogether(alphaAnim, transAnim)
            
            // 动态模糊 (Android 12+)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val blurAnim = ValueAnimator.ofFloat(TITLE_BLUR_START, 0f)
                blurAnim.addUpdateListener { 
                    val radius = it.animatedValue as Float
                    if (radius > 0) {
                        view.setRenderEffect(RenderEffect.createBlurEffect(radius, radius, Shader.TileMode.CLAMP))
                    } else {
                        view.setRenderEffect(null)
                    }
                }
                animSet.play(blurAnim)
            }
            allAnimators.add(animSet)
        }

        // 2. 按钮动画 (Explore)
        val btnStartY = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, BUTTON_START_Y_DP, displayMetrics)
        btnExplore.translationY = btnStartY
        
        val btnAlphaAnim = ObjectAnimator.ofFloat(btnExplore, "alpha", 0f, 1f)
        val btnTransAnim = ObjectAnimator.ofFloat(btnExplore, "translationY", btnStartY, 0f)
        
        val btnSet = AnimatorSet()
        btnSet.playTogether(btnAlphaAnim, btnTransAnim)
        allAnimators.add(btnSet)

        // 3. 画廊动画 (GalleryView)
        // 从 GalleryView 获取其内部构建的 Animator
        val galleryAnimator = galleryView.getEntranceAnimator()
        allAnimators.add(galleryAnimator)
        
        // 4. 统一执行所有动画
        val masterSet = AnimatorSet()
        masterSet.playTogether(allAnimators)
        masterSet.duration = ANIM_DURATION
        masterSet.interpolator = interpolator
        
        // 关键：动画开始时让 GalleryView 可见
        // 注意：getEntranceAnimator 内部已经将子 View 设为初始状态 (alpha=0)，
        // 所以此时显示 GalleryView 容器是安全的。
        galleryView.alpha = 1f 
        
        // 确保 Layout 完成后再开始动画，以便正确计算 Pivot
        galleryView.post {
            masterSet.start()
        }
    }

    // Use a simplified setup for text styles to avoid compilation issues if applyTextStyles is complex or missing
    private fun applyTextStyles() {
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val tvSubtitle = findViewById<TextView>(R.id.tvSubtitle)

        // Ensure fonts are available or use defaults
        try {
            val typefaceWelcome = android.graphics.Typeface.create("serif", android.graphics.Typeface.ITALIC)
            tvWelcome.typeface = typefaceWelcome
        } catch (e: Exception) {
            e.printStackTrace()
        }

        // Apply Linear Gradient Shader to text
        val paint = tvWelcome.paint
        val width = paint.measureText(tvWelcome.text.toString())

        val textShader = LinearGradient(
            0f, 0f, width, 0f,
            intArrayOf(
                "#FFFFFF".toColorInt(),
                "#454545".toColorInt(),
                "#FFFFFF".toColorInt()
            ),
            floatArrayOf(0f, 0.5f, 1f),
            Shader.TileMode.CLAMP
        )
        tvWelcome.paint.shader = textShader
    }
}
