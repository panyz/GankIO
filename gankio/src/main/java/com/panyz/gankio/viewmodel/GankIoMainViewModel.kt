package com.panyz.gankio.viewmodel

import androidx.lifecycle.MutableLiveData
import com.panyz.core_frame.base.BaseViewModel
import com.panyz.gankio.datas.response.Banners
import com.panyz.gankio.datasource.GankIoMainDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GankIoMainViewModel : BaseViewModel() {

    private var dataSource: GankIoMainDataSource = GankIoMainDataSource()

    val bannersData = MutableLiveData<List<Banners>>()

    fun getBanners() {
        val banners = dataSource.getBanners()
        val subscribe =
            banners.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    bannersData.value = it.data
                }
    }

}