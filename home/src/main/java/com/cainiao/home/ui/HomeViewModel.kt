package com.cainiao.home.ui

import com.cainiao.common.base.BaseViewModel
import com.cainiao.home.repo.IHomeReposity

/**
 * Created by 许成谱 on 2021/1/31 0031 10:29.
 * qq:1550540124
 * 热爱生活每一天！
 */
class HomeViewModel(val reposity: IHomeReposity) : BaseViewModel() {

    val liveBanner = reposity.liveBanner
    val liveHomeList = reposity.liveHomeList

    fun getHomeList() = serverAwait {
        reposity.getHomeList()
    }

    fun getBanner() = serverAwait {
        reposity.getBannerDatas()
    }

    suspend fun getModuleDatas(moduleId: Int) = reposity.getModuleDatas(moduleId)


}