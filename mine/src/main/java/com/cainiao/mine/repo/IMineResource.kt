package com.cainiao.mine.repo

import androidx.lifecycle.LiveData
import com.cainiao.mine.net.UserInfoRsp

/**
 * Created by 许成谱 on 2021/1/21 18:22.
 * qq:1550540124
 * 热爱生活每一天！
 */
interface IMineResource {
    /**
     * 用户信息返回的数据类
     */
    val _userInfoRegister: LiveData<UserInfoRsp?>

    /**
     * 获取用户信息
     * @param token String?
     */
    suspend fun getUserInfo(token: String?)
}