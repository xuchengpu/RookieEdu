package com.cainiao.study.ui

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.lifecycleScope
import com.cainiao.common.base.BaseFragment
import com.cainiao.study.R
import com.cainiao.study.databinding.FragmentStudyBinding
import com.xcp.service.repo.DbHelper
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by 许成谱 on 2021/1/13 18:32.
 * qq:1550540124
 * 热爱生活每一天！
 */
class StudyFragment : BaseFragment() {
    private val viewModel: StudyViewModel by viewModel()
    override fun bindView(view: View, savedInstanceState: Bundle?): ViewDataBinding? {
        return FragmentStudyBinding.bind(view).apply {
            vm = viewModel
        }
    }

    override fun initConfig() {
        super.initConfig()
        DbHelper.getLiveUserInfo(requireContext()).observeKt {
            viewModel.obUserInfo.set(it)
            viewModel.getStudyData()
            viewModel.adapter.refresh()
        }
        viewModel.apply {
            //方式一 传统方式
//            liveStudyList.observeKt {
//                adapter.submitData(it?.datas?: emptyList())
//            }
            //方式二 paging方式
            lifecycleScope.launchWhenCreated {
                viewModel. pagingData().observeKt {
                    it?.let {
                        viewModel.adapter.submitData(lifecycle, it)
                    }
                }
            }
            liveBoughtList.observeKt {

            }
        }


    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_study
    }

}