package com.bonnie.gallerylayout.controller

import android.widget.TextView

/**
 * 文本特效控制器接口
 * 负责处理文本的特殊渲染效果，如流光渐变、动态模糊等
 */
interface ITextEffectController {
    /**
     * 更新文本的渐变流光效果
     * @param textView 目标文本视图
     * @param progress 动画进度 (0.0 - 1.0)，-1 表示重置/隐藏
     */
    fun updateTextGradient(textView: TextView, progress: Float)
}