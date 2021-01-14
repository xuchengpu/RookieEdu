package com.cainiao.mine

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.cainiao.common.base.BaseFragment
import com.cainiao.mine.databinding.FragmentMineBinding

/**
 * Created by 许成谱 on 2021/1/13 18:32.
 * qq:1550540124
 * 热爱生活每一天！
 */
class MineFragment :BaseFragment(){
    override fun bindView(view: View, savedInstanceState: Bundle?): ViewDataBinding? {
        return FragmentMineBinding.bind(view)
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_mine
    }

}