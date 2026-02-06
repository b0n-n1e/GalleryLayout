package com.bonnie.gallerylayout.controller

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Matrix
import android.graphics.Shader
import android.widget.TextView
import androidx.core.graphics.toColorInt

/**
 * 渐变流光文字特效实现
 * 通过操作 LinearGradient 和 Matrix 实现光效扫过文字的动画
 */
class GradientTextEffectController : ITextEffectController {

    // 缓存对象，避免在 onDraw 或频繁调用中创建
    private val gradientMatrix = Matrix()
    private val white80Color = Color.argb((255 * 0.8).toInt(), 255, 255, 255)
    private val limeColor = "#ADF01D".toColorInt()
    private val gradientColors = intArrayOf(white80Color, limeColor, white80Color)
    private val gradientPositions = floatArrayOf(0f, 0.5f, 1f)
    
    // 缓存上一次的参数，避免重复创建 Shader
    private var lastShaderWidth = 0f

    override fun updateTextGradient(textView: TextView, progress: Float) {
        val width = textView.width.toFloat()
        if (width <= 0) return

        val paint = textView.paint
        
        // 仅当宽度发生变化或 Shader 为空时才重新创建 Shader
        if (paint.shader == null || width != lastShaderWidth) {
            val shader = LinearGradient(
                0f, 0f, width, 0f,
                gradientColors,
                gradientPositions,
                Shader.TileMode.CLAMP
            )
            paint.shader = shader
            lastShaderWidth = width
        }
        
        // 重用 Matrix 对象
        gradientMatrix.reset()
        
        // Shader 结构: 白(0.8) -> 绿 -> 白(0.8)
        // 我们假设绿色部分位于 Shader 的中间 (0.5)。
        // 为了从左向右扫过：
        // 开始：绿色在最左侧 (-width)。
        // 结束：绿色在最右侧 (+width)。
        
        // 如果 progress 为 -1，将其移出视图（最左侧）
        if (progress < 0) {
            gradientMatrix.setTranslate(-width * 2, 0f)
        } else {
             // 将进度 0..1 映射到平移 -width..+width
             // 实际上，我们要移动渐变的“窗口”。
             // 安全起见，让我们从 -width 平移到 width * 2。
             val translate = -width + (width * 3 * progress)
             gradientMatrix.setTranslate(translate, 0f)
        }
        
        paint.shader.setLocalMatrix(gradientMatrix)
        textView.invalidate()
    }
}