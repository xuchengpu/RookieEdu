package com.cainiao.mine.ui

import androidx.lifecycle.MutableLiveData
import com.cainiao.common.base.BaseViewModel
import com.xcp.service.repo.UserInfo

/**
 * Created by 许成谱 on 2021/1/20 0020 8:07.
 * qq:1550540124
 * 热爱生活每一天！
 */
class MineViewModel : BaseViewModel() {
    val userInfo=MutableLiveData<UserInfo>()

}