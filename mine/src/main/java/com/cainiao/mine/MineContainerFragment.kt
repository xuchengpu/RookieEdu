package com.cainiao.mine

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.cainiao.common.base.BaseFragment
import com.cainiao.mine.databinding.FragmentContainerBinding

/**
 * Created by 许成谱 on 2021/1/21 16:35.
 * qq:1550540124
 * 热爱生活每一天！
 */
class MineContainerFragment : BaseFragment() {
    override fun bindView(view: View, savedInstanceState: Bundle?): ViewDataBinding? {
        return FragmentContainerBinding.bind(view)
    }

    override fun getLayoutRes() = R.layout.fragment_container
}