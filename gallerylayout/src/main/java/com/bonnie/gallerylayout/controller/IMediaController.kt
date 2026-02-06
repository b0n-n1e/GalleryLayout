package com.bonnie.gallerylayout.controller

import androidx.recyclerview.widget.RecyclerView

/**
 * 媒体播放控制器接口
 * 负责管理画廊中媒体内容（如 GIF、视频）的播放与暂停
 */
interface IMediaController {
    /**
     * 当页面滚动或状态改变时调用
     * @param recyclerView 关联的 RecyclerView
     * @param currentPosition 当前中心 Item 的位置
     */
    fun updatePlaybackState(recyclerView: RecyclerView, currentPosition: Int)
}