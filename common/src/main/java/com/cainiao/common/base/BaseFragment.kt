package com.cainiao.common.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.LogUtils

/**
 * Created by 许成谱 on 2021/1/12 0012 23:25.
 * qq:1550540124
 * 热爱生活每一天！
 */
abstract class BaseFragment : Fragment {
    /**
     * 无参构造函数
     */
    constructor() : super()
    /**
     * 可以填入layout布局的构造函数，使用viewBinding的方便
     * [layout] layout布局文件的id
     */
    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

    //UI的viewDataBinding对象
    private var mBinding:ViewDataBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutRes(),container,false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding=bindView(view,savedInstanceState)
        mBinding?.lifecycleOwner=viewLifecycleOwner
        initConfig()
        initData()
//      Log.e("tag","${this}  onViewCreated")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        Log.e("tag","${this}  onCreate")
    }

    override fun onStart() {
        super.onStart()
//      Log.e("tag","${this}  onStart")
    }
    override fun onPause() {
        super.onPause()
//      Log.e("tag","${this}  onPause")
    }
    override fun onResume() {
        super.onResume()
//      Log.e("tag","${this}  onResume")
    }

    override fun onStop() {
        super.onStop()
//      Log.e("tag","${this}  onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
//      Log.e("tag","${this}  onDestroyView")
    }

    /**
     * view初始化后的必要配置
     */
    open fun initConfig() {
//      Log.e("tag","${this} 初始化 initConfig")
    }
    /**
     * view初始化后的必要数据
     */
    open fun initData() {
//      Log.e("tag","${this} 初始化 initData")
    }
    abstract fun bindView(view:View,savedInstanceState: Bundle?):ViewDataBinding?

    @LayoutRes
    abstract fun getLayoutRes():Int


    override fun onDestroy() {
//      Log.e("tag","${this}  onDestroy")
        super.onDestroy()
        mBinding?.unbind()
    }

    /**
     * 扩展liveData的observe函数
     */
    protected fun <T : Any?> LiveData<T>.observeKt(block: (T?) -> Unit) {
        this.observe(viewLifecycleOwner, Observer { data ->
            block(data)//另外一种写法
        })
    }

}