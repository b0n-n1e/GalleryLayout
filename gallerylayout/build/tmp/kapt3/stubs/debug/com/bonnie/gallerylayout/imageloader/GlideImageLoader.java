package com.bonnie.gallerylayout.imageloader;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002Ju\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016\u00a2\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J3\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ(\u0010 \u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J(\u0010 \u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\b2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J#\u0010%\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\"H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010&J#\u0010%\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\'J \u0010%\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010#\u001a\u00020(H\u0016J8\u0010%\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010#\u001a\u00020(H\u0016J\"\u0010+\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010,\u001a\u00020-H\u0016J\u0012\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u00100\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u00101\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00102\u001a\u00020\nH\u0016J\u0018\u00103\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\bH\u0016JB\u00104\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\b2\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\n2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n2\b\u00107\u001a\u0004\u0018\u00010(H\u0016J \u00108\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\"2\u0006\u00109\u001a\u00020\nH\u0016J \u00108\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00109\u001a\u00020\nH\u0016J(\u0010:\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020\bH\u0016J\"\u0010=\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J9\u0010>\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0016\u00a2\u0006\u0002\u0010?J(\u0010@\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00109\u001a\u00020\n2\u0006\u0010A\u001a\u00020\nH\u0016J4\u0010B\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\b2\u0006\u0010C\u001a\u00020\f2\u0006\u0010D\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J=\u0010E\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010/2\b\u0010F\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016\u00a2\u0006\u0002\u0010GJ_\u0010H\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010I\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000b\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016\u00a2\u0006\u0002\u0010JJ\u0097\u0001\u0010H\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010I\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000b\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\u0006\u0010C\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010D\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010K\u001a\u0004\u0018\u00010\u00182\b\u0010L\u001a\u0004\u0018\u00010MH\u0016\u00a2\u0006\u0002\u0010NJ0\u0010O\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010P\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u00182\u0006\u0010Q\u001a\u00020RH\u0016JO\u0010S\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u00102\u001a\u0004\u0018\u00010\n2\u0006\u0010T\u001a\u00020\n2\b\u0010U\u001a\u0004\u0018\u00010\b2\u0006\u0010V\u001a\u00020\f2\u0014\u0010W\u001a\u0010\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020\u0004\u0018\u00010XH\u0017\u00a2\u0006\u0002\u0010ZJ2\u0010[\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\b2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n2\b\u00107\u001a\u0004\u0018\u00010(H\u0016J*\u0010\\\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010/2\u0006\u0010;\u001a\u00020\nH\u0016J.\u0010]\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010^\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010/\u0012\u0004\u0012\u00020\u00040XH\u0016J \u0010_\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00109\u001a\u00020\nH\u0016J\u001a\u0010`\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\b2\u0006\u0010a\u001a\u00020bH\u0016J\u0010\u0010c\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010d\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J*\u0010e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J*\u0010e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006g"}, d2 = {"Lcom/bonnie/gallerylayout/imageloader/GlideImageLoader;", "Lcom/bonnie/gallerylayout/imageloader/IImageLoader;", "()V", "bindImageFromPath", "", "imageView", "Landroid/widget/ImageView;", "path", "", "placeholder", "", "keepRatio", "", "size", "Lkotlin/Pair;", "context", "Landroid/content/Context;", "signature", "", "imageLoadingStatusListener", "Lcom/bonnie/gallerylayout/imageloader/ImageLoadingStatusListener;", "priority", "Lcom/bonnie/gallerylayout/imageloader/IImageLoader$ImagePriority;", "thumbail", "", "(Landroid/widget/ImageView;Ljava/lang/String;Ljava/lang/Integer;ZLkotlin/Pair;Landroid/content/Context;Ljava/lang/Object;Lcom/bonnie/gallerylayout/imageloader/ImageLoadingStatusListener;Lcom/bonnie/gallerylayout/imageloader/IImageLoader$ImagePriority;Ljava/lang/Float;)V", "clearLoad", "downSampling", "Landroid/graphics/Bitmap;", "targetWidth", "targetHeight", "(Landroid/content/Context;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadImageOnly", "url", "Lcom/bonnie/gallerylayout/imageloader/IImageLoader$CachePathOnlyUrl;", "callback", "Lcom/bonnie/gallerylayout/imageloader/IImageLoader$DownloadImageCallback;", "getBitmapByPath", "(Landroid/content/Context;Lcom/bonnie/gallerylayout/imageloader/IImageLoader$CachePathOnlyUrl;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/bonnie/gallerylayout/imageloader/IImageLoader$GetBitmapCallback;", "width", "height", "getBitmapOnBackground", "fixSize", "Landroid/util/Size;", "getOriginDrawable", "Landroid/graphics/drawable/Drawable;", "init", "load", "resId", "loadAsBitmap", "loadBlurImage", "blurRadius", "sampling", "cb", "loadByFilePath", "maxSize", "loadByFilePathWithFading", "duration", "tag", "loadByFilePathWithNoneAnimate", "loadByFilePathWithPlaceholder", "(Landroid/widget/ImageView;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Object;Lcom/bonnie/gallerylayout/imageloader/IImageLoader$ImagePriority;)V", "loadByFilePathWithRoundedCorner", "radius", "loadByHttpUrl", "showLastWhenLoadNext", "clipTransparent", "loadByHttpUrlWithPlaceHolder", "dontAnim", "(Landroid/widget/ImageView;Ljava/lang/String;Landroid/graphics/drawable/Drawable;Ljava/lang/Boolean;Lcom/bonnie/gallerylayout/imageloader/ImageLoadingStatusListener;)V", "loadByUrlWithPlaceholder", "gifSupport", "(Landroid/widget/ImageView;Lcom/bonnie/gallerylayout/imageloader/IImageLoader$CachePathOnlyUrl;Ljava/lang/Integer;ZLcom/bonnie/gallerylayout/imageloader/ImageLoadingStatusListener;ZLkotlin/Pair;Lcom/bonnie/gallerylayout/imageloader/IImageLoader$ImagePriority;)V", "thumbnail", "scaleType", "Landroid/widget/ImageView$ScaleType;", "(Landroid/widget/ImageView;Ljava/lang/String;Ljava/lang/Integer;ZLcom/bonnie/gallerylayout/imageloader/ImageLoadingStatusListener;ZLkotlin/Pair;ZLandroid/content/Context;Ljava/lang/Object;ZLcom/bonnie/gallerylayout/imageloader/IImageLoader$ImagePriority;Ljava/lang/Float;Landroid/widget/ImageView$ScaleType;)V", "loadDrawableWidthTarget", "src", "target", "Lcom/bonnie/gallerylayout/imageloader/IImageLoader$Target;", "loadGif", "loopCnt", "gifUrl", "skipMemoryCache", "holderGifDrawableAbility", "Lkotlin/Function1;", "Lcom/bonnie/gallerylayout/imageloader/IImageLoader$IGifDrawableAbility;", "(Landroid/widget/ImageView;Ljava/lang/Integer;ILjava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "loadImage", "loadImageWithFading", "loadImmediately", "onSuccess", "loadPathWithCurrentHolder", "loadWebp", "view", "Landroid/view/ViewGroup;", "onDestroy", "pauseLoad", "preload", "resumeLoad", "gallerylayout_debug"})
public final class GlideImageLoader implements com.bonnie.gallerylayout.imageloader.IImageLoader {
    
    public GlideImageLoader() {
        super();
    }
    
    @java.lang.Override()
    public void init(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void load(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, int resId) {
    }
    
    @android.annotation.SuppressLint(value = {"CheckResult"})
    @java.lang.Override()
    public void loadGif(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.Nullable()
    java.lang.Integer resId, int loopCnt, @org.jetbrains.annotations.Nullable()
    java.lang.String gifUrl, boolean skipMemoryCache, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super com.bonnie.gallerylayout.imageloader.IImageLoader.IGifDrawableAbility, kotlin.Unit> holderGifDrawableAbility) {
    }
    
    @java.lang.Override()
    public void loadAsBitmap(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    @java.lang.Override()
    public void loadByFilePath(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String path, int maxSize) {
    }
    
    @java.lang.Override()
    public void loadPathWithCurrentHolder(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String path, int maxSize) {
    }
    
    @java.lang.Override()
    public void loadByFilePath(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.CachePathOnlyUrl path, int maxSize) {
    }
    
    @java.lang.Override()
    public void loadByFilePathWithRoundedCorner(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String path, int maxSize, int radius) {
    }
    
    @java.lang.Override()
    public void loadByFilePathWithPlaceholder(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.Nullable()
    java.lang.Integer placeholder, @org.jetbrains.annotations.Nullable()
    java.lang.Object signature, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.ImagePriority priority) {
    }
    
    @java.lang.Override()
    public void loadByFilePathWithNoneAnimate(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.Nullable()
    java.lang.Object signature) {
    }
    
    @java.lang.Override()
    public void loadByFilePathWithFading(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String path, int duration, @org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
    }
    
    @java.lang.Override()
    public void loadImageWithFading(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.Nullable()
    android.graphics.drawable.Drawable placeholder, int duration) {
    }
    
    @java.lang.Override()
    public void bindImageFromPath(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.Nullable()
    java.lang.Integer placeholder, boolean keepRatio, @org.jetbrains.annotations.Nullable()
    kotlin.Pair<java.lang.Integer, java.lang.Integer> size, @org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.Object signature, @org.jetbrains.annotations.Nullable()
    com.bonnie.gallerylayout.imageloader.ImageLoadingStatusListener imageLoadingStatusListener, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.ImagePriority priority, @org.jetbrains.annotations.Nullable()
    java.lang.Float thumbail) {
    }
    
    @java.lang.Override()
    public void loadByHttpUrl(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.Nullable()
    java.lang.String url, boolean showLastWhenLoadNext, boolean clipTransparent, @org.jetbrains.annotations.Nullable()
    com.bonnie.gallerylayout.imageloader.ImageLoadingStatusListener imageLoadingStatusListener) {
    }
    
    @java.lang.Override()
    public void loadByHttpUrlWithPlaceHolder(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.Nullable()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    android.graphics.drawable.Drawable placeholder, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean dontAnim, @org.jetbrains.annotations.Nullable()
    com.bonnie.gallerylayout.imageloader.ImageLoadingStatusListener imageLoadingStatusListener) {
    }
    
    @java.lang.Override()
    public void loadImmediately(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.graphics.drawable.Drawable, kotlin.Unit> onSuccess) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.graphics.drawable.Drawable getOriginDrawable(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView) {
        return null;
    }
    
    @java.lang.Override()
    public void clearLoad(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView) {
    }
    
    @java.lang.Override()
    public void onDestroy(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void loadWebp(@org.jetbrains.annotations.Nullable()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    android.view.ViewGroup view) {
    }
    
    @java.lang.Override()
    public void loadByUrlWithPlaceholder(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.lang.Integer placeholder, boolean gifSupport, @org.jetbrains.annotations.Nullable()
    com.bonnie.gallerylayout.imageloader.ImageLoadingStatusListener imageLoadingStatusListener, boolean keepRatio, @org.jetbrains.annotations.Nullable()
    kotlin.Pair<java.lang.Integer, java.lang.Integer> size, boolean showLastWhenLoadNext, @org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.Object signature, boolean clipTransparent, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.ImagePriority priority, @org.jetbrains.annotations.Nullable()
    java.lang.Float thumbnail, @org.jetbrains.annotations.Nullable()
    android.widget.ImageView.ScaleType scaleType) {
    }
    
    @java.lang.Override()
    public void loadByUrlWithPlaceholder(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.CachePathOnlyUrl url, @org.jetbrains.annotations.Nullable()
    java.lang.Integer placeholder, boolean gifSupport, @org.jetbrains.annotations.Nullable()
    com.bonnie.gallerylayout.imageloader.ImageLoadingStatusListener imageLoadingStatusListener, boolean keepRatio, @org.jetbrains.annotations.Nullable()
    kotlin.Pair<java.lang.Integer, java.lang.Integer> size, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.ImagePriority priority) {
    }
    
    @java.lang.Override()
    public void pauseLoad(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void resumeLoad(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void downloadImageOnly(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.DownloadImageCallback callback, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.ImagePriority priority) {
    }
    
    @java.lang.Override()
    public void downloadImageOnly(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.CachePathOnlyUrl url, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.DownloadImageCallback callback, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.ImagePriority priority) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getBitmapByPath(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super android.graphics.Bitmap> continuation) {
        return null;
    }
    
    @java.lang.Override()
    public void getBitmapByPath(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.GetBitmapCallback callback) {
    }
    
    @java.lang.Override()
    public void getBitmapByPath(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String path, int width, int height, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.ImagePriority priority, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.GetBitmapCallback callback) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getBitmapByPath(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.CachePathOnlyUrl path, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super android.graphics.Bitmap> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.graphics.Bitmap getBitmapOnBackground(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    android.util.Size fixSize) {
        return null;
    }
    
    @java.lang.Override()
    public void loadDrawableWidthTarget(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String src, float width, float height, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.Target target) {
    }
    
    @java.lang.Override()
    public void loadBlurImage(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String url, int blurRadius, int sampling, int width, int height, @org.jetbrains.annotations.Nullable()
    com.bonnie.gallerylayout.imageloader.IImageLoader.GetBitmapCallback cb) {
    }
    
    @java.lang.Override()
    public void loadImage(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String url, int width, int height, @org.jetbrains.annotations.Nullable()
    com.bonnie.gallerylayout.imageloader.IImageLoader.GetBitmapCallback cb) {
    }
    
    @java.lang.Override()
    public void preload(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.ImagePriority priority, @org.jetbrains.annotations.Nullable()
    com.bonnie.gallerylayout.imageloader.ImageLoadingStatusListener imageLoadingStatusListener) {
    }
    
    @java.lang.Override()
    public void preload(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.CachePathOnlyUrl url, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.ImagePriority priority, @org.jetbrains.annotations.Nullable()
    com.bonnie.gallerylayout.imageloader.ImageLoadingStatusListener imageLoadingStatusListener) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object downSampling(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String path, int targetWidth, int targetHeight, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super android.graphics.Bitmap> continuation) {
        return null;
    }
}