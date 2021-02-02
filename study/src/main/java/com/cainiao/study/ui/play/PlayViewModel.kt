package com.cainiao.study.ui.play

import com.cainiao.common.base.BaseViewModel
import com.cainiao.study.repo.IStudyResource

/**
 * Created by 许成谱 on 2021/2/1 0001 22:31.
 * qq:1550540124
 * 热爱生活每一天！
 */
class PlayViewModel(val repo: IStudyResource) : BaseViewModel() {

    val livePermissionResult = repo.livePermissionResult
    val liveChapterList = repo.liveChapterList
    val livePlayCourse = repo.livePlayCourse

    fun hasPermission(courseId: Int) = serverAwait { repo.hasPermission(courseId) }

    fun getChapters(courseId: Int) = serverAwait { repo.getChapters(courseId) }

    fun getPlayInfo(key: String) = serverAwait {
        repo.getPlayInfo(key)
    }
}