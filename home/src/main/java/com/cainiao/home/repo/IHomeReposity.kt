package com.cainiao.home.repo

import androidx.lifecycle.LiveData
import com.cainiao.home.net.BannerList
import com.cainiao.home.net.HomeList
import com.cniao5.common.network.model.DataResult
import com.xcp.service.network.BaseResponse

/**
 * Created by 许成谱 on 2021/1/31 0031 10:27.
 * qq:1550540124
 * 热爱生活每一天！
 */
interface IHomeReposity {

    val liveBanner: LiveData<BannerList>
    val liveHomeList: LiveData<HomeList>

    suspend fun getBannerDatas()

    suspend fun getHomeList()

    suspend fun  getModuleDatas(moduleId: Int): DataResult<BaseResponse>

}