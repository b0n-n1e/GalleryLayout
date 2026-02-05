package com.bonnie.gallerylayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bonnie.gallerylayout.imageloader.ImageLoadManager

class GalleryAdapter(
    private val items: List<GalleryItem>,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_gallery, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (items.isEmpty()) return
        
        // 设置点击监听
        holder.itemView.setOnClickListener {
            onItemClick(position)
        }
        
        // 使用取模运算实现无限循环的索引映射
        val realPosition = position % items.size
        val item = items[realPosition]
        
        // 优先加载 Drawable -> 资源 ID -> URL
        when {
            item.drawable != null -> {
                holder.imageView.setImageDrawable(item.drawable)
            }
            item.resId != null -> {
                holder.imageView.setImageResource(item.resId)
            }
            !item.url.isNullOrEmpty() -> {
                // 使用 ImageLoadManager 加载图片
                ImageLoadManager.getImageLoader().loadByUrlWithPlaceholder(
                    imageView = holder.imageView,
                    url = item.url,
                    gifSupport = true // 支持 GIF
                )
            }
        }
    }

    // 单张卡片不循环，多张卡片无限循环
    override fun getItemCount(): Int {
        return if (items.size <= 1) {
            items.size
        } else {
            Int.MAX_VALUE
        }
    }
}