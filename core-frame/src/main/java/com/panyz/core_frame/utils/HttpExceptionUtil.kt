package com.panyz.core_frame.utils

import com.panyz.core_frame.constant.HttpStatusCode

/**
 * Created by：panyz
 * Time：2/3/21
 * Desc：网络请求异常工具类
 */
object HttpExceptionUtil {
//    fun getExceptionMessage(e: Throwable): String {
//        if
//    }

    fun getExceptionMessage(code: Int): String {
        if (HttpStatusCode.ERR_FORBIDDEN == code) {
            return "请求接口不存在"
        }
        return "网络请求发生未知错误"
    }
}