package com.cainiao.login

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

/**
 * Created by 许成谱 on 2021/1/15 14:31.
 * qq:1550540124
 * 热爱生活每一天！
 */
class LoginViewModel : ViewModel() {
    val obMobile = ObservableField<String>()
    val obPassword = ObservableField<String>()
    fun goLogin(){

    }
}