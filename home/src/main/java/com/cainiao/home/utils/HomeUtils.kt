package com.cainiao.home.utils

import com.cainiao.home.net.HomeCourseItem
import com.cainiao.home.net.PopTeacherList


/*
 * 作者： 志威  zhiwei.org
 * 主页： Github: https://github.com/zhiwei1990
 * 日期： 2020年10月30日 05:21
 * 签名： 天行健，君子以自强不息；地势坤，君子以厚德载物。
 *      _              _           _     _   ____  _             _ _
 *     / \   _ __   __| |_ __ ___ (_) __| | / ___|| |_ _   _  __| (_) ___
 *    / _ \ | '_ \ / _` | '__/ _ \| |/ _` | \___ \| __| | | |/ _` | |/ _ \
 *   / ___ \| | | | (_| | | | (_) | | (_| |  ___) | |_| |_| | (_| | | (_) |
 *  /_/   \_\_| |_|\__,_|_|  \___/|_|\__,_| |____/ \__|\__,_|\__,_|_|\___/  -- 志威 zhiwei.org
 *
 * You never know what you can do until you try !
 * ----------------------------------------------------------------
 */
object HomeUtils {

    @JvmStatic
    fun parseStudentComment(info: HomeCourseItem?): String {
        return "${info?.lessons_played_time} ${info?.comment_count}人评价"
    }

    @JvmStatic
    fun parseFree(info: HomeCourseItem?): String {
        return if (info?.is_free == 1) "免费" else "￥${info?.now_price}"
    }


    @JvmStatic
    fun safeListUrl(info: PopTeacherList.PopTeacherListItem?): String {
        return if (info?.teacher_course.isNullOrEmpty()) "" else info?.teacher_course?.get(0)?.img_url
            ?: ""
    }

    @JvmStatic
    fun safeListTitle(info: PopTeacherList.PopTeacherListItem?): String {
        return if (info?.teacher_course.isNullOrEmpty()) "" else info?.teacher_course?.get(0)?.name
            ?: ""
    }

    @JvmStatic
    fun safeListComment(info: PopTeacherList.PopTeacherListItem?): String {
        return if (info?.teacher_course.isNullOrEmpty()) "" else "${info?.teacher_course?.get(0)?.lessons_played_time} ${
            info?.teacher_course?.get(
                0
            )?.comment_count
        }人评价"
    }

    @JvmStatic
    fun safeListPrice(info: PopTeacherList.PopTeacherListItem?): String {
        return if (info?.teacher_course.isNullOrEmpty()) "" else "${info?.teacher_course?.get(0)?.now_price}"
    }


}