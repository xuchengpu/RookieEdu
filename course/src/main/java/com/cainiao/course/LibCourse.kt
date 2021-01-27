package com.cainiao.course

import com.cainiao.common.network.KtRetrofit
import com.cainiao.course.net.CourseService
import com.cainiao.course.repo.CourseReposity
import com.cainiao.course.repo.ICourseReposity
import com.cainiao.course.ui.CourseViewModel
import com.cniao5.common.utils.getBaseHost
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * Created by 许成谱 on 2021/1/26 18:03.
 * qq:1550540124
 * 热爱生活每一天！
 */
val courseModules = module {
    single {
        get<KtRetrofit> { parametersOf(getBaseHost()) }
            .getService(CourseService::class.java)
    }

    single { CourseReposity(get()) } bind ICourseReposity::class


    viewModel { CourseViewModel(get()) }
}