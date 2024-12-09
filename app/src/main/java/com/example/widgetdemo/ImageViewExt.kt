package com.example.widgetdemo

import android.app.Activity
import android.content.Context
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

fun ImageView.corner(
    activity: Activity,
    @DrawableRes res: Int,
    radius: Int,
) {
    Glide.with(activity)
        .load(res)
        .transform(
            MultiTransformation(
                CenterCrop(),
                RoundedCornersTransformation(
                    dip2px(activity, radius.toFloat()),
                    0
                )
            )
        )
        .into(this)
}

fun ImageView.corner(
    context: Context,
    res: Any?,
    radius: Int,
) {
    Glide.with(context)
        .load(res)
        .transform(
            MultiTransformation(
                CenterCrop(),
                RoundedCornersTransformation(
                   dip2px(context, radius.toFloat()),
                    0
                )
            )
        )
        .into(this)
}


fun dip2px(context: Context, dpValue: Float): Int {
    val scale = context.resources.displayMetrics.density
    return (dpValue * scale + 0.5f).toInt()
}