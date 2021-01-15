package com.cniao5.common.utils

import androidx.core.net.toUri
import okhttp3.Interceptor
import okhttp3.Response

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
 * 用于调试开发期间，替换baseHost的拦截器
 */
class HostInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originRequest = chain.request()
        val oldHost = originRequest.url.host//release.course.api.cniao5.com 不带scheme的
        val oldUrlStr = originRequest.url.toString()
        //调试使用
        val newHost = getBaseHost().toUri().host ?: oldHost
        val newUrlStr = if (newHost == oldHost) {
            oldUrlStr
        } else oldUrlStr.replace(oldHost, newHost)

        val newBuilder = originRequest.newBuilder()
//        LogUtils.i("Host 拦截器 ${originRequest.url} 拦截后 $newUrlStr")
        newBuilder.url(newUrlStr)
        return chain.proceed(newBuilder.build())
    }

}