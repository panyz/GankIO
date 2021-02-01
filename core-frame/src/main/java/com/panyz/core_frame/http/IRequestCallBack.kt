package com.panyz.core_frame.http

interface IRequestCallBack<T> {
    fun onSuccess(data:T)

}