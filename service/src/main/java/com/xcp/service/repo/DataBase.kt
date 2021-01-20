package com.xcp.service.network

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by 许成谱 on 2021/1/17 0017 21:57.
 * qq:1550540124
 * 热爱生活每一天！
 */













//1、entity的定义
@Keep
@Entity(tableName = "tb_user")
data class UserInfo(
    @PrimaryKey
    val id:Int,
    val course_permission: Boolean,
    val token: String?,
    val user: User?
) {
    @Keep
    data class User(
        val id:Int,
        val logo_url: String?,//用户头像
        val reg_time: String?,//用户注册时间
        val username: String?//用户名
    )
}