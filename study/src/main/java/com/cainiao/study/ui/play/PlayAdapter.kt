package com.cainiao.study.ui.play

import androidx.databinding.ObservableBoolean

/**
 * Created by 许成谱 on 2021/2/1 0001 22:31.
 * qq:1550540124
 * 热爱生活每一天！
 */
class PlayAdapter {
}
data class LessonSection(
    val viewType: Int,//类型，分组的标记，0 title 1 content item
    val title: String?,//章节的标题title
    val key: String? = null,//用于lesson 播放信息的key
    val tryIt: Boolean = false,//是否可试看
) {
    val isPlaying = ObservableBoolean(false)

    companion object {
        const val ITEM_TYPE_TITLE = 0
        const val ITEM_TYPE_CONTENT = 1
    }
}