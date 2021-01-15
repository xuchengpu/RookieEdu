package com.cainiao.login.repo

import com.cainiao.login.net.LoginRequest
import com.cainiao.login.net.LoginService

/**
 * Created by 许成谱 on 2021/1/15 18:18.
 * qq:1550540124
 * 热爱生活每一天！
 */
class LoginRepository(private val service:LoginService):ILoginResource {

    override suspend fun checkRegister(mobi: String) {
        service.isRegister(mobi)
    }

    override suspend fun requestLogin(body: LoginRequest) {
        service.login(body)
    }
}