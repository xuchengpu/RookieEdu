package com.cainiao.home

import com.cainiao.common.network.KtRetrofit
import com.cainiao.home.net.HomeService
import com.cainiao.home.repo.HomeRepo
import com.cainiao.home.repo.IHomeReposity
import com.cainiao.home.ui.HomeViewModel
import com.cniao5.common.utils.getBaseHost
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.get
import org.koin.core.parameter.parametersOf
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * Created by 许成谱 on 2021/1/31 0031 10:24.
 * qq:1550540124
 * 热爱生活每一天！
 */
val homeModules = module {
    single {
        get<KtRetrofit> { parametersOf(getBaseHost()) }.getService(HomeService::class.java)
    }

    single {
        HomeRepo(get())
    } bind IHomeReposity::class

    viewModel {
        HomeViewModel(get())
    }


}