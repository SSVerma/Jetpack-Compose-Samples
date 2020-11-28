package com.ssverma.uiclone.alphanews

import android.app.Activity
import android.os.Build
import android.view.View
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

fun Activity.updateStatusBarColor(@ColorRes colorRes: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        window?.statusBarColor = ContextCompat.getColor(this, colorRes)
    }
}

fun Activity.updateNavigationBarColor(@ColorRes colorRes: Int) {
    window?.navigationBarColor = ContextCompat.getColor(this, colorRes)
}

fun Activity.applyLightStatusAndNavigationBars() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        window?.decorView?.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }
}