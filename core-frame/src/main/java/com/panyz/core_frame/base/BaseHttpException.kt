package com.panyz.core_frame.base

import com.panyz.core_frame.utils.HttpExceptionUtil

/**
 * Created by：panyz
 * Time：2/2/21
 * Desc：网络异常基础类
 */
open class BaseHttpException(var code: Int) : RuntimeException() {

    var msg: String = ""
        get() {
            return if (message.isNullOrEmpty()) HttpExceptionUtil.getExceptionMessage(code) else field
        }
        set(value) {
            field = value
        }

}