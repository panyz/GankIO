package com.panyz.core_frame.base

import android.annotation.SuppressLint
import android.widget.Toast
import com.panyz.core_frame.http.HttpResponse
import com.panyz.core_frame.http.callback.ILoadingCallBack
import com.panyz.core_frame.http.callback.IRequestCallBack
import com.panyz.core_frame.utils.HttpExceptionUtil
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

open class BaseDataSource(private var loading: ILoadingCallBack?) {


    @SuppressLint("CheckResult")
    fun <T> execute(response: Observable<HttpResponse<T>>, callBack: IRequestCallBack<T>) {
        response.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                loading?.startLoading()
            }
            .doFinally {
                loading?.stopLoading()
            }
            .subscribe({
                callBack.onSuccess(it.data)
            }, {
                it.printStackTrace()
                Toast.makeText(BaseApplication.mContext, HttpExceptionUtil.getExceptionMessage(it), Toast.LENGTH_SHORT).show()
            })
    }



}