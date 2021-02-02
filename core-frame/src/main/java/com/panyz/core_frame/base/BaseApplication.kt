package com.panyz.core_frame.base

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.panyz.core_frame.BuildConfig

open class BaseApplication : Application() {

    companion object{
        lateinit var  mContext:Context
    }

    override fun onCreate() {
        super.onCreate()
        mContext = this
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}