package com.cainiao.common.base

import android.bluetooth.BluetoothClass
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * Created by 许成谱 on 2021/1/17 0017 19:18.
 * qq:1550540124
 * 热爱生活每一天！
 */
abstract class BaseViewModel : ViewModel() {

    private val jobs = mutableListOf<Job>()
    val isLoading = MutableLiveData<Boolean>()//标记网络loading状态
    /**
     * 协程 网络请求
     */
    protected fun serverAwait(block: suspend CoroutineScope.() -> Unit) = viewModelScope.launch {
        isLoading.value = true
        block()
        isLoading.value = false
    }.addTo(jobs)

    override fun onCleared() {
        jobs.forEach { it.cancel() }
        super.onCleared()
    }
}

/**
 * 扩展函数，用于viewModel中的job 添加到list方便
 */
private fun Job.addTo(list: MutableList<Job>) {
    list.add(this)
}