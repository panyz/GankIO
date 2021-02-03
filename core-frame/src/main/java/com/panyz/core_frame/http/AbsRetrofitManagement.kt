package com.panyz.core_frame.http

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.panyz.core_frame.BuildConfig
import com.panyz.core_frame.http.interceptor.HttpInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by：panyz
 * Time：1/28/21
 * Desc：Retrofit管理抽象类
 */
open class AbsRetrofitManagement {

    //超时时间
    private val READ_TIME_OUT : Long = 60000
    private val CONNECT_TIME_OUT : Long = 60000
    //自定义拦截器
    private val interceptorList = mutableListOf<Interceptor>()


     open fun getRetrofit(host: String): Retrofit {
        val builder = OkHttpClient.Builder()
            .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
            .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)

        if (interceptorList.isNullOrEmpty()) {
            for (interceptor in interceptorList) {
                builder.addInterceptor(interceptor)
            }
        }

         builder.addInterceptor(HttpInterceptor())

        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(loggingInterceptor)
        }

        val okHttpClient = builder.build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(host)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    fun addInterceptor(interceptor: Interceptor) {
        interceptorList.add(interceptor)
    }

}