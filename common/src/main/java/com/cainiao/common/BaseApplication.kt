package com.cainiao.common

import android.app.Application
import android.content.Context
import com.blankj.utilcode.util.LogUtils
import com.cainiao.common.exception.CrashHandler
import me.jessyan.autosize.AutoSize
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Created by 许成谱 on 2021/1/12 0012 22:47.
 * qq:1550540124
 * 热爱生活每一天！
 */
abstract class BaseApplication : Application() {
    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        initConfig()
        initData()
    }

    /**
     * 配置初始化
     */
    protected open fun initConfig() {
        startKoin {
            androidLogger(level = Level.ERROR)//log level Error方能保证这句话不会报错，要么就不写这个
            androidContext(this@BaseApplication)
//            modules()
        }
        //今日头条适配方案：当 App 中出现多进程, 并且您需要适配所有的进程, 就需要在 App 初始化时调用 initCompatMultiProcess()
        AutoSize.initCompatMultiProcess(this)
        CrashHandler.getInstance().init(this)
    }

    /**
     * 数据初始化
     */
    protected open fun initData() {}
}