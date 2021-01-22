package com.cainiao.mine

import android.renderscript.ScriptGroup
import com.cainiao.common.network.KtRetrofit
import com.cainiao.mine.net.MineService
import com.cainiao.mine.repo.IMineResource
import com.cainiao.mine.repo.MineResource
import com.cainiao.mine.ui.MineViewModel
import com.cniao5.common.utils.getBaseHost
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * Created by 许成谱 on 2021/1/20 0020 7:59.
 * qq:1550540124
 * 热爱生活每一天！
 */
val mineModules = module {
    single {
        /* KtRetrofit
             .initConfig(getBaseHost())
             .getService(MineService::class.java)*/
        get<KtRetrofit> { parametersOf(getBaseHost()) }.getService(MineService::class.java)
    }
    single { MineResource(get()) } bind IMineResource::class


    viewModel { MineViewModel(get()) }
}