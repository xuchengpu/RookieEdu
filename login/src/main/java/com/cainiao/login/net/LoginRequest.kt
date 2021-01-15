package com.cainiao.login.net

import androidx.annotation.Keep

/**
 * Created by 许成谱 on 2021/1/15 17:59.
 * qq:1550540124
 * 热爱生活每一天！
 */
@Keep
data class LoginRequest(
    val mobi:String,
    val password:String
) {
}