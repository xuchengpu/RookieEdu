package com.cainiao.login.net

import androidx.annotation.Keep
import com.xcp.service.network.UserInfo

/**
 * Created by 许成谱 on 2021/1/15 17:59.
 * qq:1550540124
 * 热爱生活每一天！
 * 登录模块相关的结果响应类
 */

/**
 * 查询手机号码是否注册的接口响应
 */
@Keep
data class RegisterRsp(
    val is_register: Int = FLAG_UN_REGISTERED// 1 表示注册，0 表示未注册
) {
    companion object {
        const val FLAG_IS_REGISTERED = 1//已经注册的
        const val FLAG_UN_REGISTERED = 0//0 表示未注册
    }
}

/**
 * 手机号和密码登录 接口响应
 */
typealias LoginRsp = UserInfo