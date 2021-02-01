package com.cainiao.mine.ui

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.navigation.fragment.findNavController
import com.alibaba.android.arouter.launcher.ARouter
import com.cainiao.common.base.BaseFragment
import com.cainiao.common.webview.WebViewActivity
import com.cainiao.mine.R
import com.cainiao.mine.databinding.FragmentMineBinding
import com.cainiao.mine.net.UserInfoRsp
import com.cniao5.common.network.config.SP_KEY_USER_TOKEN
import com.cniao5.common.utils.CniaoSpUtils
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
                CniaoSpUtils.remove(SP_KEY_USER_TOKEN)
                DbHelper.deleteUserInfo(requireContext())
                ARouter.getInstance().build("/login/login").navigation()
            }
            tvUserNameMine.setOnClickListener {
                val info = viewModel.userInfo.value
                if (info == null) {
                    ARouter.getInstance().build("/login/login").navigation()
                }
            }
            ivUserIconMine.setOnClickListener {
                val info = viewModel.userInfo.value
                if (info == null) {
                    ARouter.getInstance().build("/login/login").navigation()
                } else {
                    val action =
                        MineFragmentDirections.actionMineFragmentToUserInfoFragment(info)
                    findNavController().navigate(action)
                }
            }
            tvOrdersMine.setOnClickListener {
                WebViewActivity.openUrl(requireContext(), "https://m.cniao5.com/user/order")
            }
            tvCouponMine.setOnClickListener {
                WebViewActivity.openUrl(requireContext(), "https://m.cniao5.com/user/coupon")
            }
            isvStudyCardMine.setOnClickListener {
                WebViewActivity.openUrl(requireContext(), "https://m.cniao5.com/sharecard")
            }
            isvShareSaleMine.setOnClickListener {
                WebViewActivity.openUrl(requireContext(), "https://m.cniao5.com/distribution")
            }
            isvGroupShoppingMine.setOnClickListener {
                WebViewActivity.openUrl(requireContext(), "https://m.cniao5.com/user/pintuan")
            }
            isvLikedCourseMine.setOnClickListener {
                WebViewActivity.openUrl(requireContext(), "https://m.cniao5.com/user/favorites")
            }
            isvFeedbackMine.setOnClickListener {
                WebViewActivity.openUrl(requireContext(), "https://cniao555.mikecrm.com/ktbB0ht")
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