package com.cainiao.login

import com.blankj.utilcode.util.ToastUtils
import com.cainiao.common.base.BaseActivity
import com.cainiao.login.databinding.ActivityLoginBinding
import com.cainiao.login.net.RegisterRsp
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginActivity : BaseActivity<ActivityLoginBinding>() {
    private val viewModel: LoginViewModel by viewModel ()
    override fun getLayoutRes() = R.layout.activity_login

    override fun initConfig() {
        super.initConfig()
        viewModel.apply {
            registerRsp.observeKt {
                if (it.is_register== RegisterRsp.FLAG_IS_REGISTERED){
                    relogin()
                }
            }
            loginRsp.observeKt {
                ToastUtils.showShort("登录结果 " + it.toString())
            }
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