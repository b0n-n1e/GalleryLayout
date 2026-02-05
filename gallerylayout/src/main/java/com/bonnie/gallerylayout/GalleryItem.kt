package com.bonnie.gallerylayout

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes

data class GalleryItem(
    val url: String? = null,
    val title: String,
    @DrawableRes val resId: Int? = null,
    val drawable: Drawable? = null
) {
    // Secondary constructor for backward compatibility or simple URL usage
    constructor(url: String, title: String) : this(url, title, null, null)
}
