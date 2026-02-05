package com.bonnie.gallerylayout.imageloader;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/bonnie/gallerylayout/imageloader/AbsImageLoadingStatusListener;", "Lcom/bonnie/gallerylayout/imageloader/ImageLoadingStatusListener;", "()V", "onCancel", "", "onError", "onStart", "onSuccess", "view", "Landroid/view/View;", "gallerylayout_debug"})
public abstract class AbsImageLoadingStatusListener implements com.bonnie.gallerylayout.imageloader.ImageLoadingStatusListener {
    
    public AbsImageLoadingStatusListener() {
        super();
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onError() {
    }
    
    @java.lang.Override()
    public void onSuccess(@org.jetbrains.annotations.Nullable()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public void onCancel() {
    }
}