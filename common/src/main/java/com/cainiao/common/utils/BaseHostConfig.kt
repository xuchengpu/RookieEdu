package com.cniao5.common.utils

import com.cainiao.common.BuildConfig
import com.cniao5.common.utils.Config.Companion.BASE_URL
import com.cniao5.common.utils.Config.Companion.HOST


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
 * 基础baseUrl的配置，可用于dokit的serverHost
 */
class Config {
    companion object {
        //配置host的key
        const val HOST = "host"

        //正式域名
        const val BASE_URL = "https://course.api.cniao5.com/"

        //测试域名
        const val TEST_BASE_URL = "https://course.api.cniao5.com.test/"
    }
}

/**
 * 获取当前配置的baseHost
 */
fun getBaseHost(): String {
    //从sp中获取
    return if (BuildConfig.DEBUG) {
        CniaoSpUtils.getString(HOST) ?: BASE_URL
    } else {
        BASE_URL
    }

}

/**
 * 更新配置host
 */
fun setBaseHost(host: String) {
    //设置到sp中
    CniaoSpUtils.put(Config.HOST, host)
}
