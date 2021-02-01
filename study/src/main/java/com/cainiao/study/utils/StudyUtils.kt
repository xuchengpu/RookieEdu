package com.cainiao.study.utils

import androidx.databinding.BindingAdapter
import com.cainiao.study.net.StudiedRsp
import com.daimajia.numberprogressbar.NumberProgressBar

/**
 * 作者： 志威  zhiwei.org
 * 主页： Github: https://github.com/zhiwei1990
 * 日期： 2020年04月27日 14:51
 * 签名： 天行健，君子以自强不息；地势坤，君子以厚德载物。
 *      _              _           _     _   ____  _             _ _
 *     / \   _ __   __| |_ __ ___ (_) __| | / ___|| |_ _   _  __| (_) ___
 *    / _ \ | '_ \ / _` | '__/ _ \| |/ _` | \___ \| __| | | |/ _` | |/ _ \
 *   / ___ \| | | | (_| | | | (_) | | (_| |  ___) | |_| |_| | (_| | | (_) |
 *  /_/   \_\_| |_|\__,_|_|  \___/|_|\__,_| |____/ \__|\__,_|\__,_|_|\___/  -- 志威 zhiwei.org
 *
 * You never know what you can do until you try !
 * ----------------------------------------------------------------
 *
 */
object StudyUtils {
    @JvmStatic
    fun rankStr(rank: Int): String {
        return if (rank > 0) "第${rank}名" else "千里之外"
    }


    @JvmStatic
    fun parseStudentComment(info: StudiedRsp.Data?): String {
        return "${info?.lessons_played_time} ${info?.comment_count}人评价"
    }

    @JvmStatic
    fun parseFree(info: StudiedRsp.Data?): String {
        return if (info?.is_free == 1) "免费" else "￥${info?.now_price}"
    }

}

@BindingAdapter("app:progress_current", requireAll = false)
fun setProgress(pb: NumberProgressBar, progress: Double?) {
    pb.progress = ((progress ?: 0.0) * 100).toInt()
}