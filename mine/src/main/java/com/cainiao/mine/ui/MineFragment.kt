package com.cainiao.mine.ui

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.navigation.fragment.findNavController
import com.alibaba.android.arouter.launcher.ARouter
import com.cainiao.common.base.BaseFragment
import com.cainiao.mine.R
import com.cainiao.mine.databinding.FragmentMineBinding
import com.cainiao.mine.net.UserInfoRsp
import com.xcp.service.repo.DbHelper
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by 许成谱 on 2021/1/13 18:32.
 * qq:1550540124
 * 热爱生活每一天！
 */
class MineFragment : BaseFragment() {

    private val viewModel: MineViewModel by viewModel()
    override fun bindView(view: View, savedInstanceState: Bundle?): ViewDataBinding? {
        return FragmentMineBinding.bind(view).apply {
            vm = viewModel
            btnLogoutMine.setOnClickListener {
                DbHelper.deleteUserInfo(requireContext())
                ARouter.getInstance().build("/login/login").navigation()
            }
            ivUserIconMine.setOnClickListener {
                viewModel.userInfo.value?.let {
                    val action =
                        MineFragmentDirections.actionMineFragmentToUserInfoFragment(it)
                    findNavController().navigate(action)
                }

            }
        }
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_mine
    }

    override fun initConfig() {
        super.initConfig()
        DbHelper.getLiveUserInfo(requireContext()).observeKt {
            //用户信息变化时应该立即去请求用户信息
            viewModel.getUserInfo(it?.token)
        }

    }

}