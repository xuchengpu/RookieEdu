package com.cainiao.study

import com.cainiao.common.network.KtRetrofit
import com.cainiao.study.net.StudyService
import com.cainiao.study.repo.IStudyResource
import com.cainiao.study.repo.StudyResource
import com.cainiao.study.ui.StudyViewModel
import com.cniao5.common.utils.getBaseHost
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * Created by 许成谱 on 2021/1/24 0024 18:36.
 * qq:1550540124
 * 热爱生活每一天！
 */
val studyModules = module {
    single {
        get<KtRetrofit> { parametersOf(getBaseHost()) }
            .getService(StudyService::class.java)
    }
    single {
        StudyResource(get())
    } bind IStudyResource::class

    viewModel {
        StudyViewModel(get())
    }

}