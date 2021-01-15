package com.cainiao.login

import com.cainiao.common.BaseApplication
import org.koin.core.context.loadKoinModules

/**
 * Created by 许成谱 on 2021/1/15 18:25.
 * qq:1550540124
 * 热爱生活每一天！
 */
class LoginApplication:BaseApplication() {
    override fun initConfig() {
        super.initConfig()
        loadKoinModules(loginModules)
    }
}