package com.bonnie.gallerylayout.app

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import android.view.animation.PathInterpolator
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bonnie.gallerylayout.imageloader.GlideImageLoader
import com.bonnie.gallerylayout.imageloader.ImageLoadManager
import com.bonnie.gallerylayout.GalleryItem
import com.bonnie.gallerylayout.GalleryView

class MainActivity : AppCompatActivity() {
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

    private fun playEntranceAnimations() {
        val galleryView = findViewById<GalleryView>(R.id.galleryView)
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val tvSubtitle = findViewById<TextView>(R.id.tvSubtitle)
        val btnExplore = findViewById<View>(R.id.btnExplore)

        // Common animation parameters
        val duration = 1800L
        val interpolator = PathInterpolator(0.74f, 0f, 0.24f, 1f)
        val displayMetrics = resources.displayMetrics

        // 1. 标题动画 (welcome + AI 造型室)
        // 透明度：60% 变为 100%
        // 位置：上移54 到初始位置
        // 模糊 28 到 0
        val titleViews = listOf(tvWelcome, tvSubtitle)
        val titleStartY = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 54f, displayMetrics)

        titleViews.forEach { view ->
            view.alpha = 0.6f
            view.translationY = titleStartY
            
            val alphaAnim = ObjectAnimator.ofFloat(view, "alpha", 0.6f, 1f)
            val transAnim = ObjectAnimator.ofFloat(view, "translationY", titleStartY, 0f)
            
            val animSet = AnimatorSet()
            animSet.playTogether(alphaAnim, transAnim)
            
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val blurAnim = ValueAnimator.ofFloat(28f, 0f)
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
            
            animSet.duration = duration
            animSet.interpolator = interpolator
            animSet.start()
        }

        // 2. 按钮动画
        // 透明度：0 到 100%
        // 位置：上移 49 px
        val btnStartY = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 49f, displayMetrics)
        btnExplore.alpha = 0f
        btnExplore.translationY = btnStartY
        
        val btnAlphaAnim = ObjectAnimator.ofFloat(btnExplore, "alpha", 0f, 1f)
        val btnTransAnim = ObjectAnimator.ofFloat(btnExplore, "translationY", btnStartY, 0f)
        
        val btnSet = AnimatorSet()
        btnSet.playTogether(btnAlphaAnim, btnTransAnim)
        btnSet.duration = duration
        btnSet.interpolator = interpolator
        btnSet.start()

        // 3. GalleryView 内部动画 (卡片 + 文案)
        galleryView.playEntranceAnimation()
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
