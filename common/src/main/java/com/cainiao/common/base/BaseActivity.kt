package com.cainiao.common.base

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.cainiao.common.ktx.viewLifeCycleOwner

/**
 * Created by 许成谱 on 2021/1/12 0012 22:52.
 * qq:1550540124
 * 热爱生活每一天！
 */
abstract class BaseActivity : AppCompatActivity() {

    /**
     * 扩展liveData的observe函数
     */
    protected fun <T : Any> LiveData<T>.observeKt(block: (T) -> Unit) {
        this.observe(viewLifeCycleOwner, Observer { data ->
            block(data)
        })
    }

}