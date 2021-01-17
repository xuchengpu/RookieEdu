package com.cainiao.login.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cainiao.login.net.LoginRequest
import com.cainiao.login.net.LoginRsp
import com.cainiao.login.net.LoginService
import com.cainiao.login.net.RegisterRsp

/**
 * Created by 许成谱 on 2021/1/15 18:18.
 * qq:1550540124
 * 热爱生活每一天！
 */
class LoginRepository(private val service: LoginService) : ILoginResource {
    private val _registerRsp = MutableLiveData<RegisterRsp>()
    private val _loginRsp = MutableLiveData<LoginRsp>()

    override val registerRsp: LiveData<RegisterRsp>
        get() = _registerRsp
    override val loginRsp: LiveData<LoginRsp>
        get() = _loginRsp

    override suspend fun checkRegister(mobi: String) {
        service.isRegister(mobi)
    }

    override suspend fun requestLogin(body: LoginRequest) {
        service.login(body)
    }
}