package com.bonnie.gallerylayout.imageloader;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/bonnie/gallerylayout/imageloader/ImageLoadManager;", "", "()V", "imageLoader", "Lcom/bonnie/gallerylayout/imageloader/IImageLoader;", "getImageLoader", "injectImageLoader", "", "isInitialized", "", "gallerylayout_debug"})
public final class ImageLoadManager {
    @org.jetbrains.annotations.NotNull()
    public static final com.bonnie.gallerylayout.imageloader.ImageLoadManager INSTANCE = null;
    private static com.bonnie.gallerylayout.imageloader.IImageLoader imageLoader;
    
    private ImageLoadManager() {
        super();
    }
    
    public final void injectImageLoader(@org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader imageLoader) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bonnie.gallerylayout.imageloader.IImageLoader getImageLoader() {
        return null;
    }
    
    public final boolean isInitialized() {
        return false;
    }
}