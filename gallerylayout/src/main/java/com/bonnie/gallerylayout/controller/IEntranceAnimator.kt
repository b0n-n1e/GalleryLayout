package com.bonnie.gallerylayout.controller

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * 入场动画控制器接口
 * 负责协调画廊组件及其子元素的入场展示动画
 */
interface IEntranceAnimator {
    /**
     * 执行入场动画
     * @param recyclerView 画廊列表视图
     * @param titleView 当前显示的标题视图
     */
    fun playAnimation(recyclerView: RecyclerView, titleView: TextView)
}