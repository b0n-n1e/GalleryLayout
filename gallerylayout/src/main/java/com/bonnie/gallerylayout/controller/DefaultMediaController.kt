package com.bonnie.gallerylayout.controller

import android.graphics.drawable.Animatable
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bonnie.gallerylayout.R

/**
 * 默认的媒体播放控制器实现
 * 仅播放位于中心的 GIF，其余 GIF 暂停
 */
class DefaultMediaController : IMediaController {

    override fun updatePlaybackState(recyclerView: RecyclerView, currentPosition: Int) {
        val layoutManager = recyclerView.layoutManager ?: return
        
        // 遍历所有可见的 View
        for (i in 0 until recyclerView.childCount) {
            val child = recyclerView.getChildAt(i) ?: continue
            val imageView = child.findViewById<ImageView>(R.id.imageView) ?: continue
            val drawable = imageView.drawable
            
            if (drawable is Animatable) {
                // 判断该 View 是否是当前的中心 Item
                // 必须通过 layoutManager 获取该 view 的 adapter position
                val adapterPos = layoutManager.getPosition(child)
                
                if (adapterPos == currentPosition) {
                    if (!drawable.isRunning) {
                        drawable.start()
                    }
                } else {
                    if (drawable.isRunning) {
                        drawable.stop()
                    }
                }
            }
        }
    }
}