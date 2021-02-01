package com.panyz.gankio.http

import com.panyz.core_frame.http.AbsRetrofitManagement
import retrofit2.Retrofit

class RetrofitManagement private constructor() : AbsRetrofitManagement() {

    var retrofit : Retrofit? = null

    companion object {
        val instance = Holder.holder
    }

    init {
        retrofit = getRetrofit("https://gank.io/api/v2/")
    }

    object Holder {
        val holder = RetrofitManagement()
    }

    open fun getService(): HttpApi {
        return retrofit?.create(HttpApi::class.java)!!
    }
}