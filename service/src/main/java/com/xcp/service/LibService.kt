package com.xcp.service

import com.cainiao.common.network.KtRetrofit
import org.koin.dsl.module

/**
 * Created by 许成谱 on 2021/1/14 15:01.
 * qq:1550540124
 * 热爱生活每一天！
 */
val serviceModules = module {
    //自定义参数类型
    single { (host: String) -> KtRetrofit.initConfig(host) }

}