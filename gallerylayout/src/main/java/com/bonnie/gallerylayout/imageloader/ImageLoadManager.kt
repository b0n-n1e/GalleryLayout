package com.bonnie.gallerylayout.imageloader

object ImageLoadManager {

    private lateinit var imageLoader: IImageLoader

    fun injectImageLoader(imageLoader: IImageLoader) {
        // assert(!ImageLoadManager::imageLoader.isInitialized)
        ImageLoadManager.imageLoader = imageLoader
    }

    fun getImageLoader(): IImageLoader {
        return imageLoader
    }

    fun isInitialized(): Boolean {
        return try {
            getImageLoader()
            true
        } catch (e: UninitializedPropertyAccessException) {
            false
        }
    }
}
