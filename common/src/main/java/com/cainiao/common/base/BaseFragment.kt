package com.cainiao.common.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Created by 许成谱 on 2021/1/12 0012 23:25.
 * qq:1550540124
 * 热爱生活每一天！
 */
class BaseFragment : Fragment {

    constructor() : super()

    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

    /**
     * 扩展liveData的observe函数
     */
    protected fun <T : Any> LiveData<T>.observeKt(block: (T) -> Unit) {

        this.observe(viewLifecycleOwner, Observer { data ->
            block.invoke(data)//另外一种写法
        })
    }
}