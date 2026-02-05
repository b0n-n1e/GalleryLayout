package com.bonnie.gallerylayout.imageloader

import android.view.View

interface ImageLoadingStatusListener {
    fun onStart()

    fun onError()

    fun onSuccess(view: View?)

    fun onCancel()
}

abstract class AbsImageLoadingStatusListener : ImageLoadingStatusListener {
    override fun onStart() {

    }

    override fun onError() {

    }

    override fun onSuccess(view: View?) {

    }

    override fun onCancel() {

    }
}
