package com.cainiao.login

import com.cainiao.common.network.KtRetrofit
import com.cainiao.login.net.LoginService
import com.cainiao.login.repo.ILoginResource
import com.cainiao.login.repo.LoginRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * Created by 许成谱 on 2021/1/15 18:28.
 * qq:1550540124
 * 热爱生活每一天！
 */
val loginModules = module {
    //service retrofit
    single {
        KtRetrofit.initConfig("https://course.api.cniao5.com/")
            .getService(LoginService::class.java)
    }
    // respository
    single {
        LoginRepository(get())
    } bind ILoginResource::class
    // viewModel
    viewModel { LoginViewModel(get()) }
}