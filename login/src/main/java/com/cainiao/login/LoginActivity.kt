package com.cainiao.login

import androidx.viewpager.widget.ViewPager
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ToastUtils
import com.cainiao.common.base.BaseActivity
import com.cainiao.common.ktx.context
import com.cainiao.common.ktx.dismissKeyBoard
import com.cainiao.login.databinding.ActivityLoginBinding
import com.cainiao.login.net.RegisterRsp
import com.xcp.service.repo.DbHelper
import org.koin.androidx.viewmodel.ext.android.viewModel

@Route(path = "/login/login")
class LoginActivity : BaseActivity<ActivityLoginBinding>() {
    private val viewModel: LoginViewModel by viewModel()
    override fun getLayoutRes() = R.layout.activity_login

    override fun initConfig() {
        super.initConfig()
        viewModel.apply {
            registerRsp.observeKt {
                if (it.is_register == RegisterRsp.FLAG_IS_REGISTERED) {
                    relogin()
                }
            }
            loginRsp.observeKt {
                ToastUtils.showShort("登录结果 " + it.toString())
                //存储到数据库
                it?.also {
                    DbHelper.insertUserInfo(context, it)
                }
                dismissKeyBoard(mBinding.root)
                //finish自己
                finish()
            }
        }
    }


    override fun initView() {
        super.initView()
        mBinding.apply {
            loginVm = viewModel
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