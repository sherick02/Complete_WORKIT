package com.kanad.workit.data.listeners

import android.os.SystemClock
import android.view.View
import kotlin.jvm.JvmOverloads

abstract class SingleClickListener @JvmOverloads constructor(protected var defaultInterval: Int = 1000) :

    View.OnClickListener {
    private var lastTimeClicked: Long = 0

    override fun onClick(v: View) {
        if (SystemClock.elapsedRealtime() - lastTimeClicked < defaultInterval) {
            return
        }
        lastTimeClicked = SystemClock.elapsedRealtime()
        performClick(v)
    }

    abstract fun performClick(v: View?)
}