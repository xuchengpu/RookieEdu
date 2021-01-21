package com.cainiao.mine.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import com.cainiao.mine.net.MineService
import com.cainiao.mine.net.UserInfoRsp
import com.cniao5.common.network.support.serverData
import com.xcp.service.network.onBizzError
import com.xcp.service.network.onBizzOK
import com.xcp.service.network.onFailure
import com.xcp.service.network.onSuccess

/**
 * Created by 许成谱 on 2021/1/21 18:25.
 * qq:1550540124
 * 热爱生活每一天！
 */
class MineResource(val service: MineService) : IMineResource {

    private val userInfoRegister = MutableLiveData<UserInfoRsp>()


    override val _userInfoRegister: LiveData<UserInfoRsp?>
        get() = userInfoRegister

    override suspend fun getUserInfo(token: String?) {
        service.getUserInfo(token)
            .serverData()
            .onSuccess {
                onBizzOK<UserInfoRsp> { code, data, message ->
                    userInfoRegister.value = data
                    LogUtils.w("获取用户信息 onBizzOK $data")
                }
                onBizzError { code, message ->
                    LogUtils.w("获取用户信息 BizError $code,$message")
                }
            }
            .onFailure {
                LogUtils.e("获取用户信息 接口异常 ${it.message}")
            }


    }
}