package com.cainiao.login.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import com.cainiao.login.net.LoginRequest
import com.cainiao.login.net.LoginRsp
import com.cainiao.login.net.LoginService
import com.cainiao.login.net.RegisterRsp
import com.cniao5.common.network.support.serverData
import com.xcp.service.network.onBizzError
import com.xcp.service.network.onBizzOK
import com.xcp.service.network.onFailure
import com.xcp.service.network.onSuccess

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
            .serverData()
            .onSuccess {
                onBizzError { code, message ->
                    LogUtils.w("是否注册 BizError $code,$message")
                    ToastUtils.showShort(message)
                }
                //此处传入的实例类型即为解密后的json串生成的实例
                onBizzOK<RegisterRsp> { code, data, message ->
                    _registerRsp.value = data
                    LogUtils.i("是否注册 BizOK $data")
                    return@onBizzOK
                }
            }.onFailure {
                LogUtils.e("是否注册 接口异常 ${it.message}")
                ToastUtils.showShort(it.message)
            }
    }

    override suspend fun requestLogin(body: LoginRequest) {
        service.login(body)
    }
}