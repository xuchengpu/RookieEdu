package com.cainiao.study.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.blankj.utilcode.util.LogUtils
import com.cainiao.study.net.BoughtRsp
import com.cainiao.study.net.StudiedRsp
import com.cainiao.study.net.StudyInfoRsp
import com.cainiao.study.net.StudyService
import com.cniao5.common.network.support.serverData
import com.cniao5.common.utils.getBaseHost
import com.xcp.service.network.onBizzError
import com.xcp.service.network.onBizzOK
import com.xcp.service.network.onFailure
import com.xcp.service.network.onSuccess
import kotlinx.coroutines.flow.Flow

/**
 * Created by 许成谱 on 2021/1/24 0024 21:11.
 * qq:1550540124
 * 热爱生活每一天！
 */
class StudyResource(private val service: StudyService) : IStudyResource {
    private val pageSize = 100

    private val _studyInfo = MutableLiveData<StudyInfoRsp>()
    private val _studyList = MutableLiveData<StudiedRsp>()
    private val _boughtList = MutableLiveData<BoughtRsp>()

    override val liveStudyInfo: LiveData<StudyInfoRsp> = _studyInfo
    override val liveStudyList: LiveData<StudiedRsp> = _studyList
    override val liveBoughtList: LiveData<BoughtRsp> = _boughtList

    /**
     * 学习情况
     */
    override suspend fun getStudyInfo() {
        service.getStudyInfo()
            .serverData()
            .onSuccess {
                onBizzOK<StudyInfoRsp> { code, data, message ->
                    _studyInfo.value = data
                    LogUtils.i("获取学习信息 BizOK $data")
                }
                onBizzError { code, message ->
                    LogUtils.w("获取学习信息 BizError $code,$message")
                }
            }
            .onFailure {
                LogUtils.e("获取学习信息 接口异常 ${it.message}")
            }
    }

    /**
     * 最近学习列表
     */
    override suspend fun getStudyList() {
        service.getStudyList()
            .serverData()
            .onSuccess {
                //只要不是接口响应成功，
                onBizzError { code, message ->
                    LogUtils.w("获取学习过的课程列表 BizError $code,$message")
                }
                onBizzOK<StudiedRsp> { code, data, message ->
                    _studyList.value = data?.apply {
                        datas?.forEach {
                            if (it.img_url?.startsWith("/") == true) {
                                it.img_url = "${getBaseHost()}${it.img_url}"
                            }
                        }
                    }
                    LogUtils.i("获取学习过的课程列表 BizOK $data")
                    return@onBizzOK
                }
            }.onFailure {
                LogUtils.e("获取学习过的课程列表 接口异常 ${it.message}")
            }
    }

    /**
     * 购买的课程
     */
    override suspend fun getBoughtCourse() {

        service.getBoughtCourse().serverData()
            .onSuccess {
                //只要不是接口响应成功，
                onBizzError { code, message ->
                    LogUtils.w("获取购买的课程 BizError $code,$message")
                }
                onBizzOK<BoughtRsp> { code, data, message ->
                    _boughtList.value = data
                    LogUtils.i("获取购买的课程 BizOK $data")
                    return@onBizzOK
                }
            }.onFailure {
                LogUtils.e("获取购买的课程 接口异常 ${it.message}")
            }

    }

    /**
     * 将studyPageSource转化为flow数据
     */
    override suspend fun pagingData(): Flow<PagingData<StudiedRsp.Data>> {
        val config = PagingConfig(
            pageSize = pageSize,
            prefetchDistance = 5,
            initialLoadSize = 10,
            maxSize = pageSize * 3
        )
        return Pager(config = config, null) {
            StudyItemPagingSource(service)
        }.flow

    }

}

/**
 * 处理分页逻辑
 */
class StudyItemPagingSource(val service: StudyService) : PagingSource<Int, StudiedRsp.Data>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, StudiedRsp.Data> {
        var result: LoadResult<Int, StudiedRsp.Data> =
            LoadResult.Error<Int, StudiedRsp.Data>(Exception("加载中..."))
        val firstPage = params.key ?: 1
        var nextPage = firstPage + 1
        service.getStudyList(firstPage, params.loadSize)
            .serverData()
            .onSuccess {
                onBizzError { code, message ->
                    LogUtils.w("获取学习过的课程列表 BizError $code,$message")
                    result = LoadResult.Error(Exception(message))
                }
                onBizzOK<StudiedRsp> { code, data, message ->
                    LogUtils.i("获取学习过的课程列表 BizOK $data")
                    val totalPage = data?.total_page ?: 0
                    //加载下一页的key 如果传null就说明到底了
                    val nextKey = if (nextPage <= totalPage) nextPage else null
                    result = LoadResult.Page<Int, StudiedRsp.Data>(
                        data?.datas ?: emptyList(),
                        null,
                        nextKey
                    )
                }
            }
            .onFailure {
                LogUtils.e("获取学习过的课程列表 接口异常 ${it.message}")
                result = LoadResult.Error(it)
            }
        return result

    }

}