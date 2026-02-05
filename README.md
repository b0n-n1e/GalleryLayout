# GalleryLayout

一个支持 3D 画廊效果、自动轮播和流光文字动画的 Android 自定义组件。

## 效果预览
（此处可以添加你的 GIF 或截图）

## 特性
*   **3D 画廊效果**：中间卡片放大，两侧卡片缩小并透明。
*   **流光文字动画**：标题文案支持从左向右的绿色流光扫过效果。
*   **自动轮播**：支持自动轮播，触摸时暂停。
*   **高度自适应**：支持 `wrap_content`，自动根据卡片高度计算布局。
*   **完全解耦**：封装为独立 Module，可直接依赖使用。

## 引入依赖

### 1. 添加 JitPack 仓库
在你的根目录 `settings.gradle.kts` 或 `build.gradle` 中添加：

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") } // 添加这一行
    }
}
```

### 2. 添加依赖
在 app 的 `build.gradle.kts` 中添加：

```kotlin
dependencies {
    implementation("com.github.b0n-n1e:GalleryLayout:1.0.0")
}
```

## 使用方法

### XML 布局
```xml
<com.bonnie.gallerylayout.GalleryView
    android:id="@+id/galleryView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:layout_constraintTop_toTopOf="parent"
    app:layout_constraintBottom_toBottomOf="parent"/>
```

### 代码调用
```kotlin
val galleryView = findViewById<GalleryView>(R.id.galleryView)

// 1. 准备数据
val items = listOf(
    GalleryItem("https://example.com/1.jpg", "Title 1"),
    GalleryItem("https://example.com/2.jpg", "Title 2"),
    GalleryItem("https://example.com/3.jpg", "Title 3")
)

// 2. 设置卡片高度 (px)
galleryView.setCardHeight(1000)

// 3. 设置数据
galleryView.setGalleryData(items)

// 4. (可选) 开启自动轮播
galleryView.enableAutoPlay(5000L)
```
