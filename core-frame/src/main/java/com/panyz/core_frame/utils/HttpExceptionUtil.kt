package com.panyz.core_frame.utils

import com.panyz.core_frame.constant.HttpStatusCode
import com.panyz.core_frame.http.exception.ConnectionException
import com.panyz.core_frame.http.exception.ForbidenUrlException
import com.panyz.core_frame.http.exception.HttpRequestException

/**
 * Created by：panyz
 * Time：2/3/21
 * Desc：网络请求异常工具类
 */
object HttpExceptionUtil {
    fun getExceptionMessage(e: Throwable): String {
        return when (e) {
            is ConnectionException -> {
                "网络连接失败，请稍后再试"
            }
            is ForbidenUrlException -> {
                "请求接口不存在"
            }
            is HttpRequestException -> {
                "服务器内部错误"
            }
            else -> "网络请求发生未知错误"
        }
    }

    fun getExceptionMessage(code: Int): String {
        return when (code) {
            HttpStatusCode.ERR_FORBIDDEN -> {
                "请求接口不存在"
            }
            HttpStatusCode.ERR_HTTP_REQUEST -> {
                "服务器内部错误"
            }
            HttpStatusCode.ERR_HTTP_CONNECTION -> {
                "网络连接失败，请稍后再试"
            }
            else -> "网络请求发生未知错误"
        }
    }
}