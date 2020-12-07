package com.example.sp4u_app.utils

import android.content.res.Resources

fun dpToPx(dp: Int): Int {
    return (dp * Resources.getSystem().displayMetrics.density).toInt()
}
