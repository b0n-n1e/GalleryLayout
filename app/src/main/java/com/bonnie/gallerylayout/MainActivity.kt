package com.bonnie.gallerylayout

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import com.bonnie.gallerylayout.imageloader.GlideImageLoader
import com.bonnie.gallerylayout.imageloader.ImageLoadManager
import com.bonnie.gallerylayout.app.R // Explicit import for R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize ImageLoadManager
        if (!ImageLoadManager.isInitialized()) {
            ImageLoadManager.injectImageLoader(GlideImageLoader())
        }

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
    }
}
