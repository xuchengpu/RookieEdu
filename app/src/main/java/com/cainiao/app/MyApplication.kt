package com.cainiao.app

import com.alibaba.android.arouter.launcher.ARouter
import com.cainiao.common.BaseApplication
import com.cainiao.common.ktx.application
import com.cainiao.login.loginModules
import com.cainiao.mine.mineModules
import com.cainiao.study.studyModules
import com.xcp.service.assistant.AssistantApp
import com.xcp.service.serviceModules
import org.koin.core.context.loadKoinModules

/**
 * Created by 许成谱 on 2021/1/12 15:58.
 * qq:1550540124
 * 热爱生活每一天！
 */
class MyApplication : BaseApplication() {
    private val modules = listOf(loginModules, studyModules, serviceModules, mineModules)

    override fun initConfig() {
        super.initConfig()
        if (BuildConfig.DEBUG) {           // These two lines must be written before init, otherwise these configurations will be invalid in the init process
            ARouter.openLog()     // Print log
            ARouter.openDebug()   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
        }
        ARouter.init(this); // As early as possible, it is recommended to initialize in the Application
        AssistantApp.initConfig(application)

        loadKoinModules(modules)
    }
}