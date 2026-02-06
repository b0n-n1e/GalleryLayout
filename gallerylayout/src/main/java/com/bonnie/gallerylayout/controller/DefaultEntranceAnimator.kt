package com.bonnie.gallerylayout.controller

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.util.TypedValue
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
    }

    override fun createEntranceAnimator(recyclerView: RecyclerView, titleView: TextView): Animator {
        val interpolator = PathInterpolator(0.74f, 0f, 0.24f, 1f)
        val mainSet = AnimatorSet()
        val animators = mutableListOf<Animator>()

        // 1. 卡片动画 (遍历所有可见子 View)
        for (i in 0 until recyclerView.childCount) {
            val child = recyclerView.getChildAt(i) ?: continue
            val cardView = child.findViewById<android.view.View>(R.id.cardView) ?: continue

            cardView.alpha = 0f
            cardView.scaleX = 0.8f
            cardView.scaleY = 0.8f
            
            val alphaAnim = ValueAnimator.ofFloat(0f, 1f)
            alphaAnim.addUpdateListener { cardView.alpha = it.animatedValue as Float }
            
            val scaleAnim = ValueAnimator.ofFloat(0.8f, 1f)
            scaleAnim.addUpdateListener { 
                val scale = it.animatedValue as Float
                cardView.scaleX = scale
                cardView.scaleY = scale
            }
            
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
            itemSet.playTogether(listOfNotNull(alphaAnim, scaleAnim, blurAnim))
            animators.add(itemSet)
        }
        
        // 2. 文案动画
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
}