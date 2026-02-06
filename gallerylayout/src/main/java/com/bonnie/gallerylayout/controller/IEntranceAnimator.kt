package com.bonnie.gallerylayout.controller

import android.animation.Animator
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * 入场动画控制器接口
 * 负责构建画廊组件及其子元素的入场展示动画
 */
interface IEntranceAnimator {
    /**
     * 创建入场动画对象 (不立即执行)
     * @param recyclerView 画廊列表视图
     * @param titleView 当前显示的标题视图
     * @return 组合好的 Animator 对象 (通常是 AnimatorSet)
     */
    fun createEntranceAnimator(recyclerView: RecyclerView, titleView: TextView): Animator
}