package com.cainiao.study.ui

import androidx.compose.runtime.savedinstancestate.rememberSavedInstanceState
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.cainiao.common.base.BaseViewModel
import com.cainiao.study.net.BoughtRsp
import com.cainiao.study.net.StudiedRsp
import com.cainiao.study.net.StudyInfoRsp
import com.cainiao.study.repo.StudyResource
import com.xcp.service.repo.UserInfo

/**
 * Created by 许成谱 on 2021/1/24 0024 18:34.
 * qq:1550540124
 * 热爱生活每一天！
 */
class StudyViewModel(private val resource: StudyResource) : BaseViewModel() {
    //学习页面的数据
    val liveStudyInfo: LiveData<StudyInfoRsp> = resource.liveStudyInfo
    val liveStudyList: LiveData<StudiedRsp> = resource.liveStudyList
    val liveBoughtList: LiveData<BoughtRsp> = resource.liveBoughtList
    //用户信息
    val obUserInfo = ObservableField<UserInfo>()

    fun getStudyData() = serverAwait {
        resource.getStudyInfo()
        resource.getStudyList()
        resource.getBoughtCourse()
    }

    suspend fun pagingData()= resource.pagingData().asLiveData()



}