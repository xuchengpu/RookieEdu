package com.cainiao.course.net
import android.annotation.SuppressLint
import android.os.Parcelable

import kotlinx.android.parcel.Parcelize

import androidx.annotation.Keep


/**
 * Created by 许成谱 on 2021/1/26 18:11.
 * qq:1550540124
 * 热爱生活每一天！
 */
class CourseTypes : ArrayList<CourseTypes.CourseTypesItem>(){
    @SuppressLint("ParcelCreator")
    @Parcelize
    @Keep
    data class CourseTypesItem(
        val code: String?,
        val id: Int,
        val title: String?
    ) : Parcelable
}

@SuppressLint("ParcelCreator")
@Parcelize
@Keep
data class CourseList(
    val datas: List<Data>?,
    val page: Int,
    val size: Int,
    val total: Int,
    val total_page: Int
) : Parcelable {
    @SuppressLint("ParcelCreator")
    @Parcelize
    @Keep
    data class Data(
        val brief: String?,
        val comment_count: Int,
        val cost_price: Int,
        val expiry_day: Int,
        val finished_lessons_count: Int,
        val first_category: FirstCategory?,
        val id: Int,
        val img_url: String?,
        val is_free: Int,
        val is_live: Int,
        val is_pt: Boolean,
        val is_share_card: Boolean,
        val lessons_count: Int,
        val lessons_played_time: Int,
        val name: String?,
        val now_price: Int
    ) : Parcelable {
        @SuppressLint("ParcelCreator")
        @Parcelize
        @Keep
        data class FirstCategory(
            val code: String?,
            val id: Int,
            val title: String?
        ) : Parcelable
    }
}