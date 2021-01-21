package com.cainiao.mine.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.cainiao.common.base.BaseFragment
import com.cainiao.mine.R
import com.cainiao.mine.databinding.FragmentUserInfoBinding

class UserInfoFragment : BaseFragment() {
    private val args by navArgs<UserInfoFragmentArgs>()
    override fun bindView(view: View, savedInstanceState: Bundle?): ViewDataBinding? {
        return FragmentUserInfoBinding.bind(view).apply {
            info = args.userinfo

            toolbarUserInfo.setNavigationOnClickListener {
                findNavController().navigateUp()
            }

            btnSaveUserInfo.setOnClickListener {
                findNavController().navigateUp()
            }


        }
    }

    override fun getLayoutRes() = R.layout.fragment_user_info

}