package com.bonnie.gallerylayout.controller

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.util.TypedValue
import android.view.View
import android.view.animation.PathInterpolator
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bonnie.gallerylayout.R

/**
 * 默认入场动画实现
 * 包含卡片和文案的组合动画：透明度、位移、缩放和高斯模糊
 */
class DefaultEntranceAnimator : IEntranceAnimator {

    companion object {
        private const val ANIM_DURATION = 1800L
        private const val CARD_BLUR_START = 80f
        private const val TITLE_BLUR_START = 28f
        private const val TITLE_TRANS_Y_DP = 46f
        private const val WHEEL_SCALE_START = 0.4f
    }

    override fun createEntranceAnimator(recyclerView: RecyclerView, titleView: TextView): Animator {
        val interpolator = PathInterpolator(0.74f, 0f, 0.24f, 1f)
        val mainSet = AnimatorSet()
        val animators = mutableListOf<Animator>()

        // 1. 整体轮盘放大动画 (RecyclerView Scale)
        // 初始状态
        recyclerView.scaleX = WHEEL_SCALE_START
        recyclerView.scaleY = WHEEL_SCALE_START
        
        val wheelScaleX = ObjectAnimator.ofFloat(recyclerView, "scaleX", WHEEL_SCALE_START, 1f)
        val wheelScaleY = ObjectAnimator.ofFloat(recyclerView, "scaleY", WHEEL_SCALE_START, 1f)
        
        // 关键：在动画开始前计算并设置 Pivot (锚点)
        // 目标：PivotY 应为中心 Item 的底部
        val pivotListener = object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator) {
                // 寻找视觉中心的 Child
                val centerChild = findCenterChild(recyclerView)
                if (centerChild != null) {
                    val cardView = centerChild.findViewById<View>(R.id.cardView)
                    if (cardView != null) {
                        // 计算 CardView 底部在 RecyclerView 坐标系中的位置
                        // top/bottom 是相对于 parent (RecyclerView) 的
                        // cardView 是 child 的子 View，cardView 在 child 中居中
                        // 所以 cardView 的底部位置 = child.top + cardView.bottom
                        val pivotY = (centerChild.top + cardView.bottom).toFloat()
                        
                        recyclerView.pivotX = recyclerView.width / 2f
                        recyclerView.pivotY = pivotY
                    }
                } else {
                    // Fallback: 如果找不到 child (例如尚未 layout)，使用中心偏下位置估算
                    recyclerView.pivotX = recyclerView.width / 2f
                    recyclerView.pivotY = recyclerView.height * 0.8f 
                }
            }
        }
        wheelScaleX.addListener(pivotListener)
        animators.add(wheelScaleX)
        animators.add(wheelScaleY)

        // 2. 卡片动画 (透明度 & 模糊) - 移除独立的缩放
        for (i in 0 until recyclerView.childCount) {
            val child = recyclerView.getChildAt(i) ?: continue
            val cardView = child.findViewById<android.view.View>(R.id.cardView) ?: continue

            cardView.alpha = 0f
            // 移除 scaleX/scaleY 的初始设置，交由父容器整体缩放
            
            val alphaAnim = ValueAnimator.ofFloat(0f, 1f)
            alphaAnim.addUpdateListener { cardView.alpha = it.animatedValue as Float }
            
            // 模糊动画 (Android 12+)
            val blurAnim = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                ValueAnimator.ofFloat(CARD_BLUR_START, 0f).apply {
                    addUpdateListener { 
                        val radius = it.animatedValue as Float
                        if (radius > 0) {
                            cardView.setRenderEffect(RenderEffect.createBlurEffect(radius, radius, Shader.TileMode.CLAMP))
                        } else {
                            cardView.setRenderEffect(null)
                        }
                    }
                }
            } else null
            
            val itemSet = AnimatorSet()
            itemSet.playTogether(listOfNotNull(alphaAnim, blurAnim))
            animators.add(itemSet)
        }
        
        // 3. 文案动画
        val context = titleView.context
        
        // 文案初始状态
        titleView.alpha = 0f
        val startTransY = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, TITLE_TRANS_Y_DP, context.resources.displayMetrics)
        titleView.translationY = startTransY
        
        val titleAlphaAnim = ValueAnimator.ofFloat(0f, 1f)
        titleAlphaAnim.addUpdateListener { titleView.alpha = it.animatedValue as Float }
        
        val titleTransAnim = ValueAnimator.ofFloat(startTransY, 0f)
        titleTransAnim.addUpdateListener { titleView.translationY = it.animatedValue as Float }
        
        // 模糊动画 (Android 12+)
        val titleBlurAnim = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            ValueAnimator.ofFloat(TITLE_BLUR_START, 0f).apply {
                addUpdateListener { 
                    val radius = it.animatedValue as Float
                    if (radius > 0) {
                        titleView.setRenderEffect(RenderEffect.createBlurEffect(radius, radius, Shader.TileMode.CLAMP))
                    } else {
                        titleView.setRenderEffect(null)
                    }
                }
            }
        } else null
        
        val titleSet = AnimatorSet()
        titleSet.playTogether(listOfNotNull(titleAlphaAnim, titleTransAnim, titleBlurAnim))
        animators.add(titleSet)
        
        mainSet.playTogether(animators)
        mainSet.duration = ANIM_DURATION
        mainSet.interpolator = interpolator
        
        return mainSet
    }

    private fun findCenterChild(recyclerView: RecyclerView): View? {
        val centerX = recyclerView.width / 2
        val centerY = recyclerView.height / 2
        var minDistance = Int.MAX_VALUE
        var centerView: View? = null

        for (i in 0 until recyclerView.childCount) {
            val child = recyclerView.getChildAt(i)
            val childCenterX = (child.left + child.right) / 2
            val childCenterY = (child.top + child.bottom) / 2
            // 简单计算距离中心的欧几里得距离 (实际上主要是 Y 轴，因为 X 轴都是居中的)
            val distance = Math.abs(childCenterY - centerY)
            
            if (distance < minDistance) {
                minDistance = distance
                centerView = child
            }
        }
        return centerView
    }
}