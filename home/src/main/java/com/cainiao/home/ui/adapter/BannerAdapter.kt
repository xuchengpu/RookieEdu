package com.cainiao.home.ui.adapter

import android.app.Application
import com.blankj.utilcode.util.ToastUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.cainiao.common.webview.WebViewActivity
import com.cainiao.home.net.BannerList
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder

/**
 * Created by 许成谱 on 2021/1/31 0031 17:46.
 * qq:1550540124
 * 热爱生活每一天！
 */
class BannerAdapter(val bannerList: BannerList) :
    BannerImageAdapter<BannerList.BannerListItem>(bannerList) {
    override fun onBindView(
        holder: BannerImageHolder?,
        data: BannerList.BannerListItem?,
        position: Int,
        size: Int
    ) {
        holder ?: return

        Glide.with(holder.itemView)
            .load(data?.img_url)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
            .into(holder.imageView)

        holder.itemView.setOnClickListener {
            WebViewActivity.openUrl(it.context, data?.redirect_url ?: "https://m.cniao5.com/")
        }

    }
}