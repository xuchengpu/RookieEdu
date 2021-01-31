package com.cainiao.home.ui

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.cainiao.common.base.BaseFragment
import com.cainiao.home.R
import com.cainiao.home.databinding.FragmentHomeBinding

/**
 * Created by 许成谱 on 2021/1/13 18:32.
 * qq:1550540124
 * 热爱生活每一天！
 */
class HomeFragment :BaseFragment(){
    override fun bindView(view: View, savedInstanceState: Bundle?): ViewDataBinding? {
        return FragmentHomeBinding.bind(view)
    }

    override fun getLayoutRes()= R.layout.fragment_home

}