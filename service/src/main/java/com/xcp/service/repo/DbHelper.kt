package com.xcp.service.repo

import android.content.Context

/**
 * Created by 许成谱 on 2021/1/20 13:25.
 * qq:1550540124
 * 热爱生活每一天！
 */
object DbHelper {

    /**
     * 以普通数据对象的形式，获取userInfo
     */
    fun getUserInfo(context: Context) = DataBase.getInstance(context).userDao().queryUser()

    /**
     * 获取room数据表中存储的userInfo
     * return liveData形式
     */
    fun getLiveUserInfo(context: Context) = DataBase.getInstance(context).userDao().queryLiveData()

    /**
     * 删除数据表中的userInfo信息
     */
    fun deleteUserInfo(context: Context) {
        val userInfo = getUserInfo(context) ?: return
        DataBase.getInstance(context).userDao().deleteUser(userInfo)
    }

}