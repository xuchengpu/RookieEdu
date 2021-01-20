package com.cainiao.common

import android.app.Application
import android.content.Context
import com.didichuxing.doraemonkit.DoraemonKit
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.koinApplication

/**
 * Created by 许成谱 on 2021/1/12 0012 22:47.
 * qq:1550540124
 * 热爱生活每一天！
 */
abstract class BaseApplication :Application() {
    companion object{
        lateinit var context: Context
    }
    override fun onCreate() {
        super.onCreate()
        context=applicationContext
        initConfig()
        initData()
    }

    /**
     * 配置初始化
     */
    protected open fun initConfig(){
        startKoin {
            androidLogger(level = Level.ERROR)//log level Error方能保证这句话不会报错，要么就不写这个
            androidContext(this@BaseApplication)
//            modules()
        }
    }

    /**
     * 数据初始化
     */
    protected open fun initData(){}
}