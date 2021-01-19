package com.cainiao.mine

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.ObservableField
import com.blankj.utilcode.util.ToastUtils
import com.cainiao.common.base.BaseActivity
import com.cainiao.mine.databinding.ActivityMineBinding
import com.cainiao.mine.widget.ItemSettingsView

class MineActivity : BaseActivity<ActivityMineBinding>() {

    override fun getLayoutRes() = R.layout.activity_mine

    override fun initConfig() {
        super.initConfig()
        mBinding.apply {
            viewSetting.setTitle("我的订单")
            val ib =
                ItemSettingsView.ItemSettingsBean(iconRes = R.drawable.ic_shoping, title = "学习卡")

            val obBean = ObservableField(ib)
            bean = obBean
            ib.title = "我的学习卡"//这种方式需要ItemSettingsView提供对应的set方法
            ib.titleColor = Color.RED

            ib.arrowColor = R.color.colorPrimary

            ib.iconRes = "https://www.easyicon.net/api/resizeApi.php?id=1283371&size=96"
//            isvCard.setIcon("https://www.easyicon.net/api/resizeApi.php?id=1283371&size=96")
            viewSetting.onClickArrow {
                ToastUtils.showShort("点击了Arrow箭头")
            }
            viewSetting.setOnClickListener {
                ToastUtils.showShort("点击整个Item")
            }


        }


    }

    override fun initView() {
        super.initView()

    }

}