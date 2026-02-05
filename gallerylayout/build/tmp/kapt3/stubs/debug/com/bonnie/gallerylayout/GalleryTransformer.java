package com.bonnie.gallerylayout;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/bonnie/gallerylayout/GalleryTransformer;", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", "()V", "transformPage", "", "page", "Landroid/view/View;", "position", "", "Companion", "gallerylayout_debug"})
public final class GalleryTransformer implements androidx.viewpager2.widget.ViewPager2.PageTransformer {
    @org.jetbrains.annotations.NotNull()
    public static final com.bonnie.gallerylayout.GalleryTransformer.Companion Companion = null;
    private static final float MAX_ROTATION = 15.0F;
    private static final float SCALE_FACTOR = 0.675F;
    private static final float MAX_ALPHA = 0.6F;
    private static final float GAP_FACTOR = 0.4F;
    
    public GalleryTransformer() {
        super();
    }
    
    @java.lang.Override()
    public void transformPage(@org.jetbrains.annotations.NotNull()
    android.view.View page, float position) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/bonnie/gallerylayout/GalleryTransformer$Companion;", "", "()V", "GAP_FACTOR", "", "MAX_ALPHA", "MAX_ROTATION", "SCALE_FACTOR", "gallerylayout_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}