package com.cainiao.login.net

import com.xcp.service.network.BaseResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by 许成谱 on 2021/1/15 17:46.
 * qq:1550540124
 * 热爱生活每一天！
 */
interface LoginService {
    @GET("accounts/phone/is/register")
    suspend fun isRegister(@Query(value = "mobi") mobile:String): Call<BaseResponse>
    @POST
    suspend fun login(@Body requestBody:LoginRequest):Call<BaseResponse>
}