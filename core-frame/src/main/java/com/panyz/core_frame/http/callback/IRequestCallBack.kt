package com.panyz.core_frame.http.callback

interface IRequestCallBack<T> {
    fun onSuccess(data:T)

}