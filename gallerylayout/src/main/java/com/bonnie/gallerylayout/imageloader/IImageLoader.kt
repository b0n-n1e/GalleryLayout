package com.bonnie.gallerylayout.imageloader

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Size
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ImageView.ScaleType
import androidx.annotation.WorkerThread
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import java.io.File

interface IImageLoader {

    fun init(context: Context)

    fun load(imageView: ImageView, resId: Int)

    /**
     * 加载gif，默认无限循环
     * @param loopCnt 循环次数，<= 0 表示无限循环
     */
    fun loadGif(
        imageView: ImageView,
        resId: Int? = null,
        loopCnt: Int = 0,
        gifUrl: String? = null,
        skipMemoryCache: Boolean = false,
        holderGifDrawableAbility: ((IGifDrawableAbility) -> Unit)? = null
    )

    fun loadAsBitmap(imageView: ImageView, url: String)

    fun loadByFilePath(imageView: ImageView, path: String, maxSize: Int = -1)

    fun loadPathWithCurrentHolder(imageView: ImageView, path: String, maxSize: Int = -1)

    fun loadByFilePath(imageView: ImageView, path: CachePathOnlyUrl, maxSize: Int = -1)

    /**
     * 加载图片，带圆角效果
     * [radius] 圆角半径，单位px
     */
    fun loadByFilePathWithRoundedCorner(imageView: ImageView, path: String, maxSize: Int = -1, radius: Int)

    fun loadByFilePathWithPlaceholder(imageView: ImageView, path: String, placeholder: Int? = null, signature: Any? = null, priority: ImagePriority = ImagePriority.NORMAL)

    fun loadByFilePathWithNoneAnimate(imageView: ImageView, path: String, signature: Any? = null)

    fun loadByFilePathWithFading(imageView: ImageView, path: String, duration: Int, tag: String = "")

    fun loadImageWithFading(imageView: ImageView, path: String, placeholder: Drawable?, duration: Int)

    fun bindImageFromPath(
        imageView: ImageView,
        path: String,
        placeholder: Int? = null,
        keepRatio: Boolean = false,
        size: Pair<Int, Int>? = null,
        context: Context? = null,
        signature: Any? = null,
        imageLoadingStatusListener: ImageLoadingStatusListener? = null,
        priority: ImagePriority = ImagePriority.NORMAL,
        thumbail: Float? = null
    )

    fun loadByHttpUrl(
        imageView: ImageView,
        url: String?,
        showLastWhenLoadNext: Boolean = false,
        clipTransparent: Boolean = false,
        imageLoadingStatusListener: ImageLoadingStatusListener? = null
    )

    fun loadByHttpUrlWithPlaceHolder(
        imageView: ImageView,
        url: String?,
        placeholder: Drawable? = null,
        dontAnim: Boolean? = null,
        imageLoadingStatusListener: ImageLoadingStatusListener? = null
    )

    fun loadImmediately(imageView: ImageView, path: String, onSuccess: (Drawable?) -> Unit = {})

    fun getOriginDrawable(imageView: ImageView): Drawable?

    fun clearLoad(imageView: ImageView)

    fun onDestroy(context: Context)

    fun loadWebp(
        url: String?,
        view: ViewGroup
    )

    @Suppress("LongParameterList")
    fun loadByUrlWithPlaceholder(
        imageView: ImageView,
        url: String,
        placeholder: Int? = null,
        gifSupport: Boolean = false,
        imageLoadingStatusListener: ImageLoadingStatusListener? = null,
        keepRatio: Boolean = false,
        size: Pair<Int, Int>? = null,
        showLastWhenLoadNext: Boolean = false,
        context: Context? = null,
        signature: Any? = null,
        clipTransparent: Boolean = false,
        priority: ImagePriority = ImagePriority.NORMAL,
        thumbnail: Float? = null,
        scaleType: ScaleType? = null
    )

    fun loadByUrlWithPlaceholder(
        imageView: ImageView,
        url: CachePathOnlyUrl,
        placeholder: Int? = null,
        gifSupport: Boolean = false,
        imageLoadingStatusListener: ImageLoadingStatusListener? = null,
        keepRatio: Boolean = false,
        size: Pair<Int, Int>? = null,
        priority: ImagePriority = ImagePriority.NORMAL
    )

    fun pauseLoad(context: Context)

    fun resumeLoad(context: Context)

    fun downloadImageOnly(context: Context, url: String, callback: DownloadImageCallback, priority: ImagePriority = ImagePriority.NORMAL)

    fun downloadImageOnly(context: Context, url: CachePathOnlyUrl, callback: DownloadImageCallback, priority: ImagePriority = ImagePriority.NORMAL)

    suspend fun getBitmapByPath(context: Context, path: String): Bitmap?

    /**
     * NOTE：这个接口内部实现最后会抛到子线程，调用方需要切换回主线程继续操作。
     * 内部异步操作，建议优先使用[getBitmapByPath(context: Context, path: String)]。参考其他调用的业务场景
     */
    fun getBitmapByPath(context: Context, path: String, callback: GetBitmapCallback)
    fun getBitmapByPath(context: Context, path: String, width: Int = 0, height: Int = 0, priority: ImagePriority = ImagePriority.NORMAL, callback: GetBitmapCallback)

    suspend fun getBitmapByPath(context: Context, path: CachePathOnlyUrl): Bitmap?

    @WorkerThread
    fun getBitmapOnBackground(context: Context, path: String, fixSize: Size): Bitmap?

    fun loadDrawableWidthTarget(context: Context, src: String, width: Float, height: Float, target: Target)

    fun loadBlurImage(
        context: Context,
        url: String,
        blurRadius: Int = 15,
        sampling: Int = 3,
        width: Int = -1, // Removed com.bumptech.glide dependency in interface definition
        height: Int = -1,
        cb: GetBitmapCallback? = null,
    )

    fun loadImage(
        context: Context,
        url: String,
        width: Int = -1,
        height: Int = -1,
        cb: GetBitmapCallback? = null,
    )

    enum class ImagePriority {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    /**
     * 预加载图片
     */
    fun preload(
        context: Context,
        url: String,
        priority: ImagePriority = ImagePriority.NORMAL,
        imageLoadingStatusListener: ImageLoadingStatusListener? = null
    )

    fun preload(
        context: Context,
        url: CachePathOnlyUrl,
        priority: ImagePriority = ImagePriority.NORMAL,
        imageLoadingStatusListener: ImageLoadingStatusListener? = null
    )

    /**
     * 降采样图片
     */
    suspend fun downSampling(
        context: Context, path: String, targetWidth: Int,
        targetHeight: Int
    ): Bitmap?

    /**
     * 取url的path作为缓存的key。默认是整段url作为key。因为醒图服务器下发的图片url，其域名部分可能会定期更新
     */
    class CachePathOnlyUrl(val url: String) {

        fun getCacheKey(): String {
            val uri = Uri.parse(url)
            return uri.path ?: url
        }
    }
    interface DownloadImageCallback {
        fun onLoadFail(errorMsg: String?)

        /**
         * 图片下载成功回调
         * @param resource 图片下载结果
         * @param hitCache 图片加载是否命中缓存
         */
        fun onResourceReady(resource: File, hitCache: Boolean)
    }

    interface GetBitmapCallback {
        fun onLoadFail()

        fun onResourceReady(bitmap: Bitmap?)
    }

    interface IGifDrawableAbility {
        fun stop()
        fun startFromFirstFrame()
        fun registerAnimationCallback(callback: Animatable2Compat.AnimationCallback)
        fun clearAnimationCallbacks()
        fun setLoopCount(loopCount: Int)
    }

    interface Target {
        fun onLoadStarted(placeholder: Drawable?) {}
        fun onResourceReady(resource: Drawable) {}
        fun onLoadCleared(placeholder: Drawable?) {}
        fun onLoadFailed(errorDrawable: Drawable?) {}
    }
}
