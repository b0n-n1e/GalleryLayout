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
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Matrix
import android.graphics.RenderEffect
import android.graphics.Shader
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.animation.PathInterpolator
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bonnie.gallerylayout.imageloader.GlideImageLoader
import com.bonnie.gallerylayout.imageloader.ImageLoadManager

class MainActivity : AppCompatActivity() {

    companion object {
        private const val ANIM_DURATION = 1800L
        private const val TITLE_START_Y_DP = 54f
        private const val BUTTON_START_Y_DP = 49f
        private const val TITLE_BLUR_START = 28f
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize ImageLoadManager
        if (!ImageLoadManager.isInitialized()) {
            ImageLoadManager.injectImageLoader(GlideImageLoader())
        }

        setupHeader()

        val galleryView = findViewById<GalleryView>(R.id.galleryView)
        
        // 模拟数据 (包含 GIF 和 标题)
        val items = listOf(
            GalleryItem(
                "https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExcDdtY2J6eHl5eGZ4Z3J5eGZ4Z3J5eGZ4Z3J5eGZ4Z3J5eCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/L1R1TVThqceQnF9h8u/giphy.gif",
                "Cool GIF Animation"
            ),
            GalleryItem("https://picsum.photos/id/10/800/1200", "Forest Landscape"),
            GalleryItem("https://picsum.photos/id/20/800/1200", "Office Setup"),
            GalleryItem("https://picsum.photos/id/30/800/1200", "Coffee Mug"),
            GalleryItem("https://picsum.photos/id/40/800/1200", "Cat Portrait"),
            GalleryItem("https://picsum.photos/id/50/800/1200", "City Street")
        )
        
        galleryView.setGalleryData(items)
        
        // 动态计算 Padding 以匹配 "焦点卡片 200px (对应设计稿)" 的视觉要求
        val displayMetrics = resources.displayMetrics
        val screenWidth = displayMetrics.widthPixels
        val cardWidth = (screenWidth * 0.6f).toInt()
        val padding = (screenWidth - cardWidth) / 2
        
        galleryView.setPagePadding(padding)
        
        // Calculate card height based on aspect ratio 200:274 and pass to GalleryView
        val cardHeight = (cardWidth * 274f / 200f).toInt()
        galleryView.setCardHeight(cardHeight)
        
        // 开启自动轮播，间隔 5000ms (按需求)
        galleryView.enableAutoPlay(5000L)

        galleryView.setOnItemClickListener {
            val currentItem = galleryView.getCurrentItem()
            Toast.makeText(this, currentItem?.title, Toast.LENGTH_LONG).show()
        }

        // Start Entrance Animation after layout
        galleryView.post {
            playEntranceAnimations()
        }
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
        
        // 动画开始前，确保容器可见（内容已设为透明）
        galleryView.alpha = 1f 
        
        masterSet.start()
    }

    private fun setupHeader() {
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        // Set text to "Welcome" (Capitalized)
        tvWelcome.text = "Welcome"

        // Condensed font simulation
        tvWelcome.textScaleX = 0.9f

        // Apply Linear Gradient Shader to text
        val paint = tvWelcome.paint
        val width = paint.measureText(tvWelcome.text.toString())

        val textShader = LinearGradient(
            0f, 0f, width, 0f,
            intArrayOf(
                Color.parseColor("#FFFFFF"),
                Color.parseColor("#454545"),
                Color.parseColor("#FFFFFF")
            ),
            floatArrayOf(0f, 0.5f, 1f),
            Shader.TileMode.CLAMP
        )
        tvWelcome.paint.shader = textShader
    }
}
