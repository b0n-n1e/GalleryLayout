package com.bonnie.gallerylayout.imageloader;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\t"}, d2 = {"Lcom/bonnie/gallerylayout/imageloader/ImageLoadingStatusListener;", "", "onCancel", "", "onError", "onStart", "onSuccess", "view", "Landroid/view/View;", "gallerylayout_debug"})
public abstract interface ImageLoadingStatusListener {
    
    public abstract void onStart();
    
    public abstract void onError();
    
    public abstract void onSuccess(@org.jetbrains.annotations.Nullable()
    android.view.View view);
    
    public abstract void onCancel();
}