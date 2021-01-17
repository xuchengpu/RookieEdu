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

@Entity(tableName = "tb_cniao_user")
data class UserInfo(
    @PrimaryKey
    val id: Int,//主键
    val course_permission: Boolean,
    val token: String?,
    @Embedded
    val user: User?
) {
    @Keep
    data class User(
        @ColumnInfo(name = "cniao_user_id")
        val id: Int,//用户id
        val logo_url: String?,//用户头像
        val reg_time: String?,//用户注册时间
        val username: String?//用户名
    )
}