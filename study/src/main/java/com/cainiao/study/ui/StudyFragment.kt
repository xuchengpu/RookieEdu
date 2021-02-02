package com.cainiao.study.ui

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import com.cainiao.common.base.BaseFragment
import com.cainiao.study.R
import com.cainiao.study.databinding.FragmentStudyBinding
import com.cainiao.study.ui.play.PlayActivity
import com.xcp.service.repo.DbHelper
import kotlinx.android.synthetic.main.fragment_study.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by 许成谱 on 2021/1/13 18:32.
 * qq:1550540124
 * 热爱生活每一天！
 */
class StudyFragment : BaseFragment() {
    private val viewModel: StudyViewModel by viewModel()

    //我的学习列表适配器
    val adapter = StudyPageAdapter {
        PlayActivity.openPlay(requireContext(), it)
    }

    override fun bindView(view: View, savedInstanceState: Bundle?): ViewDataBinding? {
        return FragmentStudyBinding.bind(view).apply {
            vm = viewModel
            adapter = this@StudyFragment.adapter
        }
    }

    override fun initConfig() {
        super.initConfig()
        DbHelper.getLiveUserInfo(requireContext()).observeKt {
            viewModel.obUserInfo.set(it)
            viewModel.getStudyData()
            if (it == null) {
                lifecycleScope.launchWhenCreated {
                    adapter.submitData(PagingData.empty())//清除列表
                }
            }

        }
        viewModel.apply {
            //方式一 传统方式
//            liveStudyList.observeKt {
//                adapter.submitData(it?.datas?: emptyList())
//            }
            //方式二 paging方式
            lifecycleScope.launchWhenCreated {
                viewModel.pagingData().observeKt {
                    it?.let {
                        adapter.submitData(lifecycle, it)
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