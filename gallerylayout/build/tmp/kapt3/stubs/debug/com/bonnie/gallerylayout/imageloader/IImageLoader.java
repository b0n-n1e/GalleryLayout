package com.bonnie.gallerylayout.imageloader;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001:\u0006efghijJ\u0085\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&\u00a2\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J3\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ*\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H&J*\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H&J#\u0010#\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020 H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010$J#\u0010#\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010%J \u0010#\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010!\u001a\u00020&H&J>\u0010#\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\'\u001a\u00020\t2\b\b\u0002\u0010(\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0006\u0010!\u001a\u00020&H&J\"\u0010)\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010*\u001a\u00020+H\'J\u0012\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010/\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00100\u001a\u00020\tH&J\u0018\u00101\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0007H&JL\u00102\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u00103\u001a\u00020\t2\b\b\u0002\u00104\u001a\u00020\t2\b\b\u0002\u0010\'\u001a\u00020\t2\b\b\u0002\u0010(\u001a\u00020\t2\n\b\u0002\u00105\u001a\u0004\u0018\u00010&H&J\"\u00106\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020 2\b\b\u0002\u00107\u001a\u00020\tH&J\"\u00106\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u00107\u001a\u00020\tH&J*\u00108\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00109\u001a\u00020\t2\b\b\u0002\u0010:\u001a\u00020\u0007H&J$\u0010;\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0001H&J?\u0010<\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u0014H&\u00a2\u0006\u0002\u0010=J*\u0010>\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u00107\u001a\u00020\t2\u0006\u0010?\u001a\u00020\tH&J:\u0010@\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010A\u001a\u00020\u000b2\b\b\u0002\u0010B\u001a\u00020\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&JC\u0010C\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&\u00a2\u0006\u0002\u0010EJk\u0010F\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010G\u001a\u00020\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\r2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H&\u00a2\u0006\u0002\u0010HJ\u00af\u0001\u0010F\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010G\u001a\u00020\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\r2\b\b\u0002\u0010A\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010B\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010J\u001a\u0004\u0018\u00010KH&\u00a2\u0006\u0002\u0010LJ0\u0010M\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020\u00072\u0006\u0010\'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u00162\u0006\u0010O\u001a\u00020PH&JY\u0010Q\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u00100\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010R\u001a\u00020\t2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010T\u001a\u00020\u000b2\u0016\b\u0002\u0010U\u001a\u0010\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020\u0003\u0018\u00010VH&\u00a2\u0006\u0002\u0010XJ8\u0010Y\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010\'\u001a\u00020\t2\b\b\u0002\u0010(\u001a\u00020\t2\n\b\u0002\u00105\u001a\u0004\u0018\u00010&H&J*\u0010Z\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010-2\u0006\u00109\u001a\u00020\tH&J0\u0010[\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\\\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010-\u0012\u0004\u0012\u00020\u00030VH&J\"\u0010]\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u00107\u001a\u00020\tH&J\u001a\u0010^\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\u0006\u0010_\u001a\u00020`H&J\u0010\u0010a\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010b\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J.\u0010c\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J.\u0010c\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\u0010\u0010d\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006k"}, d2 = {"Lcom/bonnie/gallerylayout/imageloader/IImageLoader;", "", "bindImageFromPath", "", "imageView", "Landroid/widget/ImageView;", "path", "", "placeholder", "", "keepRatio", "", "size", "Lkotlin/Pair;", "context", "Landroid/content/Context;", "signature", "imageLoadingStatusListener", "Lcom/bonnie/gallerylayout/imageloader/ImageLoadingStatusListener;", "priority", "Lcom/bonnie/gallerylayout/imageloader/IImageLoader$ImagePriority;", "thumbail", "", "(Landroid/widget/ImageView;Ljava/lang/String;Ljava/lang/Integer;ZLkotlin/Pair;Landroid/content/Context;Ljava/lang/Object;Lcom/bonnie/gallerylayout/imageloader/ImageLoadingStatusListener;Lcom/bonnie/gallerylayout/imageloader/IImageLoader$ImagePriority;Ljava/lang/Float;)V", "clearLoad", "downSampling", "Landroid/graphics/Bitmap;", "targetWidth", "targetHeight", "(Landroid/content/Context;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadImageOnly", "url", "Lcom/bonnie/gallerylayout/imageloader/IImageLoader$CachePathOnlyUrl;", "callback", "Lcom/bonnie/gallerylayout/imageloader/IImageLoader$DownloadImageCallback;", "getBitmapByPath", "(Landroid/content/Context;Lcom/bonnie/gallerylayout/imageloader/IImageLoader$CachePathOnlyUrl;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/bonnie/gallerylayout/imageloader/IImageLoader$GetBitmapCallback;", "width", "height", "getBitmapOnBackground", "fixSize", "Landroid/util/Size;", "getOriginDrawable", "Landroid/graphics/drawable/Drawable;", "init", "load", "resId", "loadAsBitmap", "loadBlurImage", "blurRadius", "sampling", "cb", "loadByFilePath", "maxSize", "loadByFilePathWithFading", "duration", "tag", "loadByFilePathWithNoneAnimate", "loadByFilePathWithPlaceholder", "(Landroid/widget/ImageView;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Object;Lcom/bonnie/gallerylayout/imageloader/IImageLoader$ImagePriority;)V", "loadByFilePathWithRoundedCorner", "radius", "loadByHttpUrl", "showLastWhenLoadNext", "clipTransparent", "loadByHttpUrlWithPlaceHolder", "dontAnim", "(Landroid/widget/ImageView;Ljava/lang/String;Landroid/graphics/drawable/Drawable;Ljava/lang/Boolean;Lcom/bonnie/gallerylayout/imageloader/ImageLoadingStatusListener;)V", "loadByUrlWithPlaceholder", "gifSupport", "(Landroid/widget/ImageView;Lcom/bonnie/gallerylayout/imageloader/IImageLoader$CachePathOnlyUrl;Ljava/lang/Integer;ZLcom/bonnie/gallerylayout/imageloader/ImageLoadingStatusListener;ZLkotlin/Pair;Lcom/bonnie/gallerylayout/imageloader/IImageLoader$ImagePriority;)V", "thumbnail", "scaleType", "Landroid/widget/ImageView$ScaleType;", "(Landroid/widget/ImageView;Ljava/lang/String;Ljava/lang/Integer;ZLcom/bonnie/gallerylayout/imageloader/ImageLoadingStatusListener;ZLkotlin/Pair;ZLandroid/content/Context;Ljava/lang/Object;ZLcom/bonnie/gallerylayout/imageloader/IImageLoader$ImagePriority;Ljava/lang/Float;Landroid/widget/ImageView$ScaleType;)V", "loadDrawableWidthTarget", "src", "target", "Lcom/bonnie/gallerylayout/imageloader/IImageLoader$Target;", "loadGif", "loopCnt", "gifUrl", "skipMemoryCache", "holderGifDrawableAbility", "Lkotlin/Function1;", "Lcom/bonnie/gallerylayout/imageloader/IImageLoader$IGifDrawableAbility;", "(Landroid/widget/ImageView;Ljava/lang/Integer;ILjava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "loadImage", "loadImageWithFading", "loadImmediately", "onSuccess", "loadPathWithCurrentHolder", "loadWebp", "view", "Landroid/view/ViewGroup;", "onDestroy", "pauseLoad", "preload", "resumeLoad", "CachePathOnlyUrl", "DownloadImageCallback", "GetBitmapCallback", "IGifDrawableAbility", "ImagePriority", "Target", "gallerylayout_debug"})
public abstract interface IImageLoader {
    
    public abstract void init(@org.jetbrains.annotations.NotNull()
    android.content.Context context);
    
    public abstract void load(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, int resId);
    
    /**
     * 加载gif，默认无限循环
     * @param loopCnt 循环次数，<= 0 表示无限循环
     */
    public abstract void loadGif(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.Nullable()
    java.lang.Integer resId, int loopCnt, @org.jetbrains.annotations.Nullable()
    java.lang.String gifUrl, boolean skipMemoryCache, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super com.bonnie.gallerylayout.imageloader.IImageLoader.IGifDrawableAbility, kotlin.Unit> holderGifDrawableAbility);
    
    public abstract void loadAsBitmap(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String url);
    
    public abstract void loadByFilePath(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String path, int maxSize);
    
    public abstract void loadPathWithCurrentHolder(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String path, int maxSize);
    
    public abstract void loadByFilePath(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.CachePathOnlyUrl path, int maxSize);
    
    /**
     * 加载图片，带圆角效果
     * [radius] 圆角半径，单位px
     */
    public abstract void loadByFilePathWithRoundedCorner(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String path, int maxSize, int radius);
    
    public abstract void loadByFilePathWithPlaceholder(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.Nullable()
    java.lang.Integer placeholder, @org.jetbrains.annotations.Nullable()
    java.lang.Object signature, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.ImagePriority priority);
    
    public abstract void loadByFilePathWithNoneAnimate(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.Nullable()
    java.lang.Object signature);
    
    public abstract void loadByFilePathWithFading(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String path, int duration, @org.jetbrains.annotations.NotNull()
    java.lang.String tag);
    
    public abstract void loadImageWithFading(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.Nullable()
    android.graphics.drawable.Drawable placeholder, int duration);
    
    public abstract void bindImageFromPath(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.Nullable()
    java.lang.Integer placeholder, boolean keepRatio, @org.jetbrains.annotations.Nullable()
    kotlin.Pair<java.lang.Integer, java.lang.Integer> size, @org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.Object signature, @org.jetbrains.annotations.Nullable()
    com.bonnie.gallerylayout.imageloader.ImageLoadingStatusListener imageLoadingStatusListener, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.ImagePriority priority, @org.jetbrains.annotations.Nullable()
    java.lang.Float thumbail);
    
    public abstract void loadByHttpUrl(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.Nullable()
    java.lang.String url, boolean showLastWhenLoadNext, boolean clipTransparent, @org.jetbrains.annotations.Nullable()
    com.bonnie.gallerylayout.imageloader.ImageLoadingStatusListener imageLoadingStatusListener);
    
    public abstract void loadByHttpUrlWithPlaceHolder(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.Nullable()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    android.graphics.drawable.Drawable placeholder, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean dontAnim, @org.jetbrains.annotations.Nullable()
    com.bonnie.gallerylayout.imageloader.ImageLoadingStatusListener imageLoadingStatusListener);
    
    public abstract void loadImmediately(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.graphics.drawable.Drawable, kotlin.Unit> onSuccess);
    
    @org.jetbrains.annotations.Nullable()
    public abstract android.graphics.drawable.Drawable getOriginDrawable(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView);
    
    public abstract void clearLoad(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView);
    
    public abstract void onDestroy(@org.jetbrains.annotations.NotNull()
    android.content.Context context);
    
    public abstract void loadWebp(@org.jetbrains.annotations.Nullable()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    android.view.ViewGroup view);
    
    @kotlin.Suppress(names = {"LongParameterList"})
    public abstract void loadByUrlWithPlaceholder(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.lang.Integer placeholder, boolean gifSupport, @org.jetbrains.annotations.Nullable()
    com.bonnie.gallerylayout.imageloader.ImageLoadingStatusListener imageLoadingStatusListener, boolean keepRatio, @org.jetbrains.annotations.Nullable()
    kotlin.Pair<java.lang.Integer, java.lang.Integer> size, boolean showLastWhenLoadNext, @org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.Object signature, boolean clipTransparent, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.ImagePriority priority, @org.jetbrains.annotations.Nullable()
    java.lang.Float thumbnail, @org.jetbrains.annotations.Nullable()
    android.widget.ImageView.ScaleType scaleType);
    
    public abstract void loadByUrlWithPlaceholder(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.CachePathOnlyUrl url, @org.jetbrains.annotations.Nullable()
    java.lang.Integer placeholder, boolean gifSupport, @org.jetbrains.annotations.Nullable()
    com.bonnie.gallerylayout.imageloader.ImageLoadingStatusListener imageLoadingStatusListener, boolean keepRatio, @org.jetbrains.annotations.Nullable()
    kotlin.Pair<java.lang.Integer, java.lang.Integer> size, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.ImagePriority priority);
    
    public abstract void pauseLoad(@org.jetbrains.annotations.NotNull()
    android.content.Context context);
    
    public abstract void resumeLoad(@org.jetbrains.annotations.NotNull()
    android.content.Context context);
    
    public abstract void downloadImageOnly(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.DownloadImageCallback callback, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.ImagePriority priority);
    
    public abstract void downloadImageOnly(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.CachePathOnlyUrl url, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.DownloadImageCallback callback, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.ImagePriority priority);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBitmapByPath(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super android.graphics.Bitmap> continuation);
    
    /**
     * NOTE：这个接口内部实现最后会抛到子线程，调用方需要切换回主线程继续操作。
     * 内部异步操作，建议优先使用[getBitmapByPath(context: Context, path: String)]。参考其他调用的业务场景
     */
    public abstract void getBitmapByPath(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.GetBitmapCallback callback);
    
    public abstract void getBitmapByPath(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String path, int width, int height, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.ImagePriority priority, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.GetBitmapCallback callback);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBitmapByPath(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.CachePathOnlyUrl path, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super android.graphics.Bitmap> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    public abstract android.graphics.Bitmap getBitmapOnBackground(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    android.util.Size fixSize);
    
    public abstract void loadDrawableWidthTarget(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String src, float width, float height, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.Target target);
    
    public abstract void loadBlurImage(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String url, int blurRadius, int sampling, int width, int height, @org.jetbrains.annotations.Nullable()
    com.bonnie.gallerylayout.imageloader.IImageLoader.GetBitmapCallback cb);
    
    public abstract void loadImage(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String url, int width, int height, @org.jetbrains.annotations.Nullable()
    com.bonnie.gallerylayout.imageloader.IImageLoader.GetBitmapCallback cb);
    
    /**
     * 预加载图片
     */
    public abstract void preload(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.ImagePriority priority, @org.jetbrains.annotations.Nullable()
    com.bonnie.gallerylayout.imageloader.ImageLoadingStatusListener imageLoadingStatusListener);
    
    public abstract void preload(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.CachePathOnlyUrl url, @org.jetbrains.annotations.NotNull()
    com.bonnie.gallerylayout.imageloader.IImageLoader.ImagePriority priority, @org.jetbrains.annotations.Nullable()
    com.bonnie.gallerylayout.imageloader.ImageLoadingStatusListener imageLoadingStatusListener);
    
    /**
     * 降采样图片
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object downSampling(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String path, int targetWidth, int targetHeight, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super android.graphics.Bitmap> continuation);
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/bonnie/gallerylayout/imageloader/IImageLoader$ImagePriority;", "", "(Ljava/lang/String;I)V", "LOW", "NORMAL", "HIGH", "IMMEDIATE", "gallerylayout_debug"})
    public static enum ImagePriority {
        /*public static final*/ LOW /* = new LOW() */,
        /*public static final*/ NORMAL /* = new NORMAL() */,
        /*public static final*/ HIGH /* = new HIGH() */,
        /*public static final*/ IMMEDIATE /* = new IMMEDIATE() */;
        
        ImagePriority() {
        }
    }
    
    /**
     * 取url的path作为缓存的key。默认是整段url作为key。因为醒图服务器下发的图片url，其域名部分可能会定期更新
     */
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/bonnie/gallerylayout/imageloader/IImageLoader$CachePathOnlyUrl;", "", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getCacheKey", "gallerylayout_debug"})
    public static final class CachePathOnlyUrl {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String url = null;
        
        public CachePathOnlyUrl(@org.jetbrains.annotations.NotNull()
        java.lang.String url) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUrl() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCacheKey() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/bonnie/gallerylayout/imageloader/IImageLoader$DownloadImageCallback;", "", "onLoadFail", "", "errorMsg", "", "onResourceReady", "resource", "Ljava/io/File;", "hitCache", "", "gallerylayout_debug"})
    public static abstract interface DownloadImageCallback {
        
        public abstract void onLoadFail(@org.jetbrains.annotations.Nullable()
        java.lang.String errorMsg);
        
        /**
         * 图片下载成功回调
         * @param resource 图片下载结果
         * @param hitCache 图片加载是否命中缓存
         */
        public abstract void onResourceReady(@org.jetbrains.annotations.NotNull()
        java.io.File resource, boolean hitCache);
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/bonnie/gallerylayout/imageloader/IImageLoader$GetBitmapCallback;", "", "onLoadFail", "", "onResourceReady", "bitmap", "Landroid/graphics/Bitmap;", "gallerylayout_debug"})
    public static abstract interface GetBitmapCallback {
        
        public abstract void onLoadFail();
        
        public abstract void onResourceReady(@org.jetbrains.annotations.Nullable()
        android.graphics.Bitmap bitmap);
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&\u00a8\u0006\f"}, d2 = {"Lcom/bonnie/gallerylayout/imageloader/IImageLoader$IGifDrawableAbility;", "", "clearAnimationCallbacks", "", "registerAnimationCallback", "callback", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "setLoopCount", "loopCount", "", "startFromFirstFrame", "stop", "gallerylayout_debug"})
    public static abstract interface IGifDrawableAbility {
        
        public abstract void stop();
        
        public abstract void startFromFirstFrame();
        
        public abstract void registerAnimationCallback(@org.jetbrains.annotations.NotNull()
        androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback callback);
        
        public abstract void clearAnimationCallbacks();
        
        public abstract void setLoopCount(int loopCount);
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/bonnie/gallerylayout/imageloader/IImageLoader$Target;", "", "onLoadCleared", "", "placeholder", "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "errorDrawable", "onLoadStarted", "onResourceReady", "resource", "gallerylayout_debug"})
    public static abstract interface Target {
        
        public abstract void onLoadStarted(@org.jetbrains.annotations.Nullable()
        android.graphics.drawable.Drawable placeholder);
        
        public abstract void onResourceReady(@org.jetbrains.annotations.NotNull()
        android.graphics.drawable.Drawable resource);
        
        public abstract void onLoadCleared(@org.jetbrains.annotations.Nullable()
        android.graphics.drawable.Drawable placeholder);
        
        public abstract void onLoadFailed(@org.jetbrains.annotations.Nullable()
        android.graphics.drawable.Drawable errorDrawable);
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 3)
        public static final class DefaultImpls {
            
            public static void onLoadStarted(@org.jetbrains.annotations.NotNull()
            com.bonnie.gallerylayout.imageloader.IImageLoader.Target $this, @org.jetbrains.annotations.Nullable()
            android.graphics.drawable.Drawable placeholder) {
            }
            
            public static void onResourceReady(@org.jetbrains.annotations.NotNull()
            com.bonnie.gallerylayout.imageloader.IImageLoader.Target $this, @org.jetbrains.annotations.NotNull()
            android.graphics.drawable.Drawable resource) {
            }
            
            public static void onLoadCleared(@org.jetbrains.annotations.NotNull()
            com.bonnie.gallerylayout.imageloader.IImageLoader.Target $this, @org.jetbrains.annotations.Nullable()
            android.graphics.drawable.Drawable placeholder) {
            }
            
            public static void onLoadFailed(@org.jetbrains.annotations.NotNull()
            com.bonnie.gallerylayout.imageloader.IImageLoader.Target $this, @org.jetbrains.annotations.Nullable()
            android.graphics.drawable.Drawable errorDrawable) {
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 3)
    public final class DefaultImpls {
    }
}