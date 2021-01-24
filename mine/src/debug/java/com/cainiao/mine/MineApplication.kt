package com.cainiao.mine

import android.app.Application
import com.cainiao.common.BaseApplication
import com.xcp.service.serviceModules
import org.koin.core.context.loadKoinModules

/**
 * Created by 许成谱 on 2021/1/23 0023 22:58.
 * qq:1550540124
 * 热爱生活每一天！
 */
class MineApplication:BaseApplication() {
    private val modules = listOf(serviceModules,mineModules)
    override fun initConfig() {
        super.initConfig()
        loadKoinModules(modules)
    }
}