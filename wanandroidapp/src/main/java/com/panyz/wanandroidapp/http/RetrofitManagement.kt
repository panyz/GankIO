package com.panyz.wanandroidapp.http

import com.panyz.core_frame.http.AbsRetrofitManagement
import retrofit2.Retrofit

/**
 * Created by：panyz
 * Time：1/28/21
 * Desc：wanandroid组件Retrofit全局单例(静态内部类实现)
 */
class RetrofitManagement private constructor() : AbsRetrofitManagement() {
    var retrofit: Retrofit? = null

    companion object {
        val instance = Holder.holder
    }

    init {
        retrofit = getRetrofit("https://www.wanandroid.com")
    }


    object Holder {
        val holder = RetrofitManagement()
    }

    open fun getService(): HttpApi {
        return retrofit?.create(HttpApi::class.java)!!
    }

}