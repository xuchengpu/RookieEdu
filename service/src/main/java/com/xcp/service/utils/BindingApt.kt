package com.xcp.service.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.xcp.service.R

/**
 * Created by 许成谱 on 2021/1/18 0018 22:35.
 * qq:1550540124
 * 热爱生活每一天！
 */
/**
 * imageView支持图片加载 绑定
 */
@BindingAdapter("app:srcCompat", requireAll = false)
fun imgSrcCompat(iv: ImageView, src: Any?) {
    val image = src ?: R.drawable.icon_default_header

    Glide.with(iv)
        .load(image)
        .into(iv)
}

/**
 * 图片资源支持tint颜色修改，支持colorRes和colorInt形式
 */
@BindingAdapter("app:tint")
fun imgColor(iv: ImageView, color: Int) {
    if (color == 0) return
    runCatching {
        iv.setColorFilter(iv.resources.getColor(color))
    }.onFailure {//说明此时是Color.RED形式
        iv.setColorFilter(color)
    }
}

/**
 * textColor的binding形式，支持colorRes和colorInt形式
 */
@BindingAdapter("android:textColor")
fun tvColor(tv: TextView, color: Int) {
    if (color == 0) return
    runCatching {
        tv.setTextColor(tv.resources.getColor(color))
    }.onFailure {//说明此时是Color.RED形式
        tv.setTextColor(color)
    }
}



