package com.bonnie.gallerylayout

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

/**
 * 自定义画廊效果转换器
 *
 * 实现了以下效果：
 * 1. **缩放 (Scale)**：中心 Item 最大 (1.0)，两侧逐渐缩小 (至 0.675)。
 * 2. **旋转 (Rotation)**：模拟 3D 轮盘效果，两侧 Item 向内倾斜。
 * 3. **位移 (Translation)**：调整 Item 间距，使缩放后的 Item 紧凑排列。
 * 4. **层级 (Z-Index)**：中心 Item 层级最高，确保覆盖两侧 Item。
 * 5. **蒙层 (Overlay)**：两侧 Item 逐渐变暗，增强景深感。
 */
class GalleryTransformer : ViewPager2.PageTransformer {
    
    companion object {
        /** 最大旋转角度 (15度) */
        private const val MAX_ROTATION = 15f 
        
        /** 最小缩放比例 (135/200) */
        private const val SCALE_FACTOR = 0.675f 
        
        /** 蒙层最大透明度 (60%) */
        private const val MAX_ALPHA = 0.6f 
        
        /** 间隙拉近系数 (值越小间距越紧凑) */
        private const val GAP_FACTOR = 0.4f 
    }

    override fun transformPage(page: View, position: Float) {
        val absPos = abs(position)
        
        // 1. 缩放处理
        // 逻辑：在 [-1, 1] 范围内线性插值，范围外保持最小缩放比例
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
        
        // 清除 Y 轴旋转 (防止其他 Transformer 干扰)
        page.rotationY = 0f
        
        // 3. Y轴位移 - 移除 (保持水平对齐)
        page.translationY = 0f
        
        // 4. X轴位移 (调整间距)
        // 计算因缩放产生的空白区域，并反向移动以消除间隙
        val transX = -(page.width * (1 - scale) / 2) * GAP_FACTOR
        page.translationX = transX * if (position > 0) 1 else -1
        
        // 5. Z轴层级
        // 越靠近中心 (position 0)，层级越高
        page.translationZ = -absPos

        // 6. 蒙层透明度
        // 越远离中心，蒙层越不透明 (变暗)
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
