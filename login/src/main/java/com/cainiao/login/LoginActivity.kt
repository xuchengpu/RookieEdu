package com.cainiao.login

import androidx.activity.viewModels
import androidx.databinding.Observable
import com.blankj.utilcode.util.ToastUtils
import com.cainiao.common.base.BaseActivity
import com.cainiao.login.databinding.ActivityLoginBinding


class LoginActivity : BaseActivity<ActivityLoginBinding>() {
    private val viewModel: LoginViewModel by viewModels { defaultViewModelProviderFactory }

    override fun getLayoutRes() = R.layout.activity_login

    override fun initConfig() {
        super.initConfig()
        mBinding.apply {
            mBinding.lvm=viewModel
        }
        viewModel.obMobile.addOnPropertyChangedCallback(object :
            Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                ToastUtils.showShort(viewModel.obMobile.get())
            }

        })
    }

    override fun initView() {
        super.initView()
    }

    override fun initData() {
        super.initData()
    }

}