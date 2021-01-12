package com.cainiao.common.model

import androidx.lifecycle.LiveData

/**
 * Created by 许成谱 on 2021/1/12 0012 23:42.
 * qq:1550540124
 * 热爱生活每一天！
 * 创建一个空的liveData对象类
 */
class AbsentLiveData <T :Any?>private constructor():LiveData<T>(){
    init {
        postValue(null)
    }
    companion object{
        fun <T:Any?> create():LiveData<T>{
            return AbsentLiveData<T>()
        }
    }
}