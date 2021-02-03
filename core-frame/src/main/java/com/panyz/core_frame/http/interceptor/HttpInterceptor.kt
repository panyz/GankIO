package com.panyz.core_frame.http.interceptor

import com.panyz.core_frame.constant.HttpStatusCode
import com.panyz.core_frame.http.exception.ConnectionException
import com.panyz.core_frame.http.exception.ForbidenUrlException
import com.panyz.core_frame.http.exception.HttpRequestException
import okhttp3.Interceptor
import okhttp3.Response

class HttpInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val originalResponse: Response
        try {
            originalResponse = chain.proceed(request)
        } catch (e: Exception) {
            throw ConnectionException(HttpStatusCode.ERR_HTTP_CONNECTION)
        }

        if (originalResponse.code != HttpStatusCode.RESPONSE_SUCCESS) {
            if (originalResponse.code == HttpStatusCode.ERR_FORBIDDEN) {
                throw ForbidenUrlException(HttpStatusCode.ERR_FORBIDDEN)
            }
            throw HttpRequestException(HttpStatusCode.ERR_HTTP_REQUEST)
        }

        return originalResponse
    }

}