package com.bonnie.gallerylayout;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010#\u001a\u00020\u0019J\u0010\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010\'\u001a\u00020\u00192\b\b\u0002\u0010(\u001a\u00020\nJ\b\u0010)\u001a\u0004\u0018\u00010\u0012J\u0006\u0010*\u001a\u00020!J\b\u0010+\u001a\u00020\u0019H\u0014J\b\u0010,\u001a\u00020\u0019H\u0014J\b\u0010-\u001a\u00020\u0019H\u0002J\u0012\u0010.\u001a\u00020\u00192\n\u0010/\u001a\u0006\u0012\u0002\b\u000300J\u000e\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u0007J\u0014\u00103\u001a\u00020\u00192\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0014\u00105\u001a\u00020\u00192\f\u00106\u001a\b\u0012\u0004\u0012\u0002070\u0011J\u001a\u00108\u001a\u00020\u00192\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00190\u0018J\u000e\u0010:\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\u0007J\b\u0010<\u001a\u00020\u0019H\u0002J\u0010\u0010=\u001a\u00020\u00192\u0006\u0010>\u001a\u00020\u001cH\u0002J\b\u0010?\u001a\u00020\u0019H\u0002J\u0018\u0010@\u001a\u00020\u00192\u0006\u0010>\u001a\u00020\u001c2\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010C\u001a\u00020\u00192\u0006\u0010D\u001a\u00020\u0007H\u0002J\u0018\u0010E\u001a\u00020\u00192\u0006\u0010D\u001a\u00020\u00072\u0006\u0010F\u001a\u00020BH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006G"}, d2 = {"Lcom/bonnie/gallerylayout/GalleryView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "RESUME_DELAY", "", "autoPlayInterval", "autoPlayRunnable", "Ljava/lang/Runnable;", "currentAnimator", "Landroid/animation/ValueAnimator;", "galleryItems", "", "Lcom/bonnie/gallerylayout/GalleryItem;", "gradientAnimator", "isAutoPlayEnabled", "", "isTextView1Active", "onItemClickListener", "Lkotlin/Function1;", "", "resumeAutoPlayRunnable", "textView1", "Landroid/widget/TextView;", "textView2", "titleContainer", "Landroid/widget/FrameLayout;", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "createTitleTextView", "disableAutoPlay", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "enableAutoPlay", "interval", "getCurrentItem", "getViewPager", "onAttachedToWindow", "onDetachedFromWindow", "performCustomScroll", "setAdapter", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setCardHeight", "heightPx", "setGalleryData", "items", "setImageUrls", "urls", "", "setOnItemClickListener", "listener", "setPagePadding", "paddingHorizontal", "startAutoPlay", "startGradientFlow", "textView", "stopAutoPlay", "updateTextGradient", "progress", "", "updateTitle", "position", "updateTitleOnScroll", "positionOffset", "gallerylayout_debug"})
public final class GalleryView extends android.widget.LinearLayout {
    private final androidx.viewpager2.widget.ViewPager2 viewPager = null;
    private final android.widget.FrameLayout titleContainer = null;
    private final android.widget.TextView textView1 = null;
    private final android.widget.TextView textView2 = null;
    private boolean isTextView1Active = true;
    private java.util.List<com.bonnie.gallerylayout.GalleryItem> galleryItems;
    private boolean isAutoPlayEnabled = false;
    private long autoPlayInterval = 5000L;
    private android.animation.ValueAnimator currentAnimator;
    private final java.lang.Runnable resumeAutoPlayRunnable = null;
    private final long RESUME_DELAY = 5000L;
    private final java.lang.Runnable autoPlayRunnable = null;
    private android.animation.ValueAnimator gradientAnimator;
    private kotlin.jvm.functions.Function1<? super com.bonnie.gallerylayout.GalleryItem, kotlin.Unit> onItemClickListener;
    
    @kotlin.jvm.JvmOverloads()
    public GalleryView(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public GalleryView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public GalleryView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    /**
     * 设置卡片高度，用于定位文案
     * 文案将显示在卡片正下方
     * @param heightPx 卡片的像素高度
     */
    public final void setCardHeight(int heightPx) {
    }
    
    private final android.widget.TextView createTitleTextView(android.content.Context context) {
        return null;
    }
    
    /**
     * 开启流光渐变动画
     * 逻辑说明：
     * 1. 开始状态：渐变光效隐藏在左侧（偏移量为 -width），文案显示为纯白色。
     * 2. 动画过程：渐变窗口从左向右移动（-width -> +width）。
     *   - 当偏移为 -width 时：Shader 右边缘对应文案左边缘（白色）。
     *   - 当偏移为 0 时：Shader 中心对应文案中心（绿色高光）。
     *   - 当偏移为 +width 时：Shader 左边缘对应文案右边缘（白色）。
     * 3. 结束状态：渐变光效隐藏在右侧（偏移量为 +width），文案恢复为纯白色。
     */
    private final void startGradientFlow(android.widget.TextView textView) {
    }
    
    private final void updateTitleOnScroll(int position, float positionOffset) {
    }
    
    private final void updateTextGradient(android.widget.TextView textView, float progress) {
    }
    
    private final void updateTitle(int position) {
    }
    
    /**
     * 设置页面间距
     */
    public final void setPagePadding(int paddingHorizontal) {
    }
    
    /**
     * 执行自定义滑动动画
     */
    private final void performCustomScroll() {
    }
    
    /**
     * 设置适配器
     */
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.Adapter<?> adapter) {
    }
    
    /**
     * 设置点击事件监听器
     * 当用户点击处于中心位置的卡片时触发
     */
    public final void setOnItemClickListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.bonnie.gallerylayout.GalleryItem, kotlin.Unit> listener) {
    }
    
    /**
     * 设置画廊数据并初始化视图
     */
    public final void setGalleryData(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bonnie.gallerylayout.GalleryItem> items) {
    }
    
    public final void setImageUrls(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> urls) {
    }
    
    /**
     * 开启自动轮播
     * @param interval 轮播间隔时间，单位毫秒 (默认: 5000ms)
     */
    public final void enableAutoPlay(long interval) {
    }
    
    /**
     * 停止自动轮播
     */
    public final void disableAutoPlay() {
    }
    
    private final void startAutoPlay() {
    }
    
    private final void stopAutoPlay() {
    }
    
    @java.lang.Override()
    public boolean dispatchTouchEvent(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent ev) {
        return false;
    }
    
    @java.lang.Override()
    protected void onAttachedToWindow() {
    }
    
    @java.lang.Override()
    protected void onDetachedFromWindow() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.viewpager2.widget.ViewPager2 getViewPager() {
        return null;
    }
    
    /**
     * 获取当前选中的画廊项目
     * @return 当前展示的 GalleryItem，如果列表为空则返回 null
     */
    @org.jetbrains.annotations.Nullable()
    public final com.bonnie.gallerylayout.GalleryItem getCurrentItem() {
        return null;
    }
}