package com.xcp.service.assistant

import android.app.Application
import com.didichuxing.doraemonkit.DoraemonKit
import com.didichuxing.doraemonkit.kit.AbstractKit

/**
 * Created by 许成谱 on 2021/1/14 14:59.
 * qq:1550540124
 * 热爱生活每一天！
 */
object AssistantApp {
    fun initConfig(application: Application){
        DoraemonKit.install(application, mutableListOf<AbstractKit>(ServiceHostKit()),"cainiao")
    }
}