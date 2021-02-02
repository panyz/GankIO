package com.panyz.gankio.viewmodel

import androidx.lifecycle.MutableLiveData
import com.panyz.core_frame.base.BaseViewModel
import com.panyz.core_frame.http.callback.ILoadingCallBack
import com.panyz.core_frame.http.callback.IRequestCallBack
import com.panyz.gankio.datas.response.Banners
import com.panyz.gankio.datasource.GankIoMainDataSource

class GankIoMainViewModel(loadingCallBack: ILoadingCallBack?) : BaseViewModel() {

    private var dataSource: GankIoMainDataSource = GankIoMainDataSource(loadingCallBack)

    val bannersData = MutableLiveData<List<Banners>>()

    fun getBanners() {
      dataSource.getBanners(object : IRequestCallBack<List<Banners>> {
          override fun onSuccess(data: List<Banners>) {
              bannersData.value = data
          }
      })

    }

}