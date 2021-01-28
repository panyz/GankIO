package com.panyz.wanandroidapp.http

import com.panyz.core_frame.http.AbsRetrofitManagement

/**
 * Created by：panyz
 * Time：1/28/21
 * Desc：wanandroid组件Retrofit全局单例(静态内部类实现)
 */
class RetrofitManagement private constructor() : AbsRetrofitManagement() {


    companion object {
        val instance = Holder.holder
    }

    init {
        val retrofit = getRetrofit("https://www.wanandroid.com")
        val create = retrofit.create(HttpApi::class.java)
    }


    object Holder {
        val holder = RetrofitManagement()
    }

}