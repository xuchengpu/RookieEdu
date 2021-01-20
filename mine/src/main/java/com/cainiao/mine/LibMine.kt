package com.cainiao.mine

import com.cainiao.mine.ui.MineViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by 许成谱 on 2021/1/20 0020 7:59.
 * qq:1550540124
 * 热爱生活每一天！
 */
val mineModules = module {
    viewModel { MineViewModel() }
}