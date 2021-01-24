package com.cainiao.study.repo

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.cainiao.study.net.BoughtRsp
import com.cainiao.study.net.StudiedRsp
import com.cainiao.study.net.StudyInfoRsp
import kotlinx.coroutines.flow.Flow

/**
 * Created by 许成谱 on 2021/1/24 0024 21:10.
 * qq:1550540124
 * 热爱生活每一天！
 */
interface IStudyResource {

    val liveStudyInfo: LiveData<StudyInfoRsp>
    val liveStudyList: LiveData<StudiedRsp>
    val liveBoughtList: LiveData<BoughtRsp>

    /**
     * 学习情况
     */
    suspend fun getStudyInfo()

    /**
     * 最近学习列表
     */
    suspend fun getStudyList()

    /**
     * 购买的课程
     */
    suspend fun getBoughtCourse()

    /**
     * 将studyPageSource转化为flow数据
     */
    suspend fun pagingData(): Flow<PagingData<StudiedRsp.Data>>

}