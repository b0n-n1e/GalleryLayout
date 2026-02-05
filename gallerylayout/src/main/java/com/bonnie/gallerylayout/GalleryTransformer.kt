package com.bonnie.gallerylayout

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class GalleryTransformer : ViewPager2.PageTransformer {
    
    companion object {
        private const val MAX_ROTATION = 15f // 最大旋转角度 (15度)
        private const val SCALE_FACTOR = 0.675f // 最小缩放比例 (135/200)
        private const val MAX_ALPHA = 0.6f // 蒙层最大透明度
        private const val GAP_FACTOR = 0.4f // 间隙拉近系数
    }

    override fun transformPage(page: View, position: Float) {
        val absPos = abs(position)
        
        // 1. 缩放处理
        // 中心 1.0 -> 两侧 0.675
        val scale = if (absPos < 1) {
             1f - (1f - SCALE_FACTOR) * absPos
        } else {
            SCALE_FACTOR
        }
        page.scaleY = scale
        page.scaleX = scale 

        // 2. 旋转处理 (轮盘效果 - Z轴平面旋转)
        // 目标：反向倾斜 (Concave Fan \ | /)
        // 左边 (pos < 0): 顺时针旋转 (\), rotation > 0
        // 右边 (pos > 0): 逆时针旋转 (/), rotation < 0
        
        val rotation = -MAX_ROTATION * position
        
        if (position < -1) { 
            page.rotation = MAX_ROTATION
        } else if (position > 1) { 
            page.rotation = -MAX_ROTATION
        } else {
            page.rotation = rotation
        }
        
        // 清除 Y 轴旋转
        page.rotationY = 0f
        
        // 3. Y轴位移 - 移除
        page.translationY = 0f
        
        // 4. X轴位移 (调整间距)
        val transX = -(page.width * (1 - scale) / 2) * GAP_FACTOR
        page.translationX = transX * if (position > 0) 1 else -1
        
        // 5. Z轴层级
        page.translationZ = -absPos

        // 6. 蒙层透明度
        val overlayView = page.findViewById<View>(R.id.overlayView)
        if (overlayView != null) {
            val alpha = if (absPos < 1) {
                MAX_ALPHA * absPos
            } else {
                MAX_ALPHA
            }
            overlayView.alpha = alpha
        }
    }
}
