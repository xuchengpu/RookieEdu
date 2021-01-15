package com.cniao5.common.network

import com.cniao5.common.network.support.IHttpCallback

/**
 * 作者： 志威  zhiwei.org
 * 主页： Github: https://github.com/zhiwei1990
 * 日期： 2020年08月18日 00:49
 * 签名： 天行健，君子以自强不息；地势坤，君子以厚德载物。
 *      _              _           _     _   ____  _             _ _
 *     / \   _ __   __| |_ __ ___ (_) __| | / ___|| |_ _   _  __| (_) ___
 *    / _ \ | '_ \ / _` | '__/ _ \| |/ _` | \___ \| __| | | |/ _` | |/ _ \
 *   / ___ \| | | | (_| | | | (_) | | (_| |  ___) | |_| |_| | (_| | | (_) |
 *  /_/   \_\_| |_|\__,_|_|  \___/|_|\__,_| |____/ \__|\__,_|\__,_|_|\___/  -- 志威 zhiwei.org
 *
 * You never know what you can do until you try !
 * ----------------------------------------------------------------
 * 网络请求的统一接口类
 */
interface HttpApi {

    /**
     * 抽象的http的get请求封装,异步
     */
    fun get(params: Map<String, Any>, urlStr: String, callback: IHttpCallback)

    /**
     * 抽象的http同步的 get请求
     */
    fun getSync(params: Map<String, Any>, urlStr: String): Any? {
        return Any()
    }

    /**
     * 抽象的http的post的请求 异步
     */
    fun post(body: Any, urlStr: String, callback: IHttpCallback)

    /**
     * 抽象的Http的post 同步请求
     */
    fun postSync(body: Any, urlStr: String): Any? = Any()


    fun cancelRequest(tag: Any)

    fun cancelAllRequest()
}


