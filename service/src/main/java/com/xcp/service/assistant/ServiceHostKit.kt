package com.xcp.service.assistant

import android.content.Context
import com.didichuxing.doraemonkit.kit.AbstractKit
import com.xcp.service.R

/**
 * Created by 许成谱 on 2021/1/14 15:00.
 * qq:1550540124
 * 热爱生活每一天！
 * 自定义调试工具类，用于添加到dokit里切换host
 */
class ServiceHostKit :AbstractKit(){
    override val icon: Int
        get() = R.drawable.icon_server_host
    override val name: Int
        get() = R.string.str_server_host_dokit

    override fun onAppInit(context: Context?) {

    }

    override fun onClick(context: Context?) {

    }

}