package com.cainiao.login.repo

import com.cainiao.login.net.LoginRequest

/**
 * Created by 许成谱 on 2021/1/15 18:12.
 * qq:1550540124
 * 热爱生活每一天！
 * 登录模块的相关的抽象数据接口
 */
interface ILoginResource {
    /**
     * 校验手机号是否注册，合法
     */
    suspend fun checkRegister(mobi:String)
    /**
     * 手机号合法的基础上，调用登录，获取登录结果token
     */
    suspend fun requestLogin(body:LoginRequest)
}