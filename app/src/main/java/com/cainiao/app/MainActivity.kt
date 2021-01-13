package com.cainiao.app

import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.cainiao.app.databinding.ActivityMainBinding
import com.cainiao.common.base.BaseActivity
import com.didichuxing.doraemonkit.DoraemonKit

class MainActivity : BaseActivity<ActivityMainBinding>() {
//region
    //BottomNavigationView原始用法使用示例
/*
            val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
//     Passing each menu ID as a set of Ids because each
//     menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)*/
    //endregion
    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        super.initView()
    }

    override fun initConfig() {
        super.initConfig()
    }

    override fun initData() {
        super.initData()
    }

}
