package com.cainiao.mine.net

import com.xcp.service.network.BaseResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

/**
 * Created by 许成谱 on 2021/1/21 18:18.
 * qq:1550540124
 * 热爱生活每一天！
 */
interface MineService {
    /**
     * 获取用户信息
     * @param token String?
     * @return Call<BaseResponse>
     */
    @GET(value = "/member/userinfo")
    fun getUserInfo(@Header("token") token: String?): Call<BaseResponse>
}