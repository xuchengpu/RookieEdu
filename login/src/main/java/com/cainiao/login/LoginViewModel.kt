package com.cainiao.login

import android.content.Context
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blankj.utilcode.util.ToastUtils
import com.cainiao.common.base.BaseViewModel
import com.cainiao.login.net.LoginRequest
import com.cainiao.login.repo.ILoginResource
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

/**
 * Created by 许成谱 on 2021/1/15 14:31.
 * qq:1550540124
 * 热爱生活每一天！
 */
class LoginViewModel(private val resourse: ILoginResource) : BaseViewModel() {
    val obMobile = ObservableField<String>()
    val obPassword = ObservableField<String>()

    val registerRsp = resourse.registerRsp
    val loginRsp = resourse.loginRsp

    /**
     * 调用登录，两步，1，判断手机号是否已经注册
     * 2，已经注册的，才去调用登录
     */
    fun goLogin() {
        val account = obMobile.get() ?: return
        checkRegister(account)
    }

    /**
     * 调用登录
     * val mobi: String = "18648957777",
     * val password: String = "cn5123456"
     */
    internal fun relogin() {
        val account = obMobile.get() ?: return
        val password = obPassword.get() ?: return
        serverAwait {
            resourse.requestLogin(LoginRequest(account, password))
        }
    }

    private fun checkRegister(account: String) = serverAwait {
        resourse.checkRegister(account)
    }

    fun wechat(ctx: Context) {
        ToastUtils.showShort("点击了微信登录")
    }

    fun qq(view: View) {
        ToastUtils.showShort("点击了QQ登录")
    }

    fun weibo() {
        ToastUtils.showShort("点击了微博登录")
    }
    fun forget(v:View) {
        ToastUtils.showShort("忘记密码")
    }
}