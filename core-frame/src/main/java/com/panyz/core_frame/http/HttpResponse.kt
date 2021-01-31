package com.panyz.core_frame.http

data class HttpResponse<T>(
    val data: T,
    val errorCode: Int,
    val errorMsg: String
)