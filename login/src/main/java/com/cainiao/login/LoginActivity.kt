package com.cainiao.login

import com.blankj.utilcode.util.ToastUtils
import com.cainiao.common.base.BaseActivity
import com.cainiao.login.databinding.ActivityLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginActivity : BaseActivity<ActivityLoginBinding>() {
    private val viewModel: LoginViewModel by viewModel ()
    override fun getLayoutRes() = R.layout.activity_login

    override fun initConfig() {
        super.initConfig()
        viewModel.apply {

        }


    }

    override fun initView() {
        super.initView()
        mBinding.apply {
            loginVm=viewModel
            toolbarLogin.setNavigationOnClickListener { finish() }
            tvRegisterLogin.setOnClickListener {
                ToastUtils.showShort("当前课程项目未实现注册账号功能")
            }
        }
    }

    override fun initData() {
        super.initData()
    }

}