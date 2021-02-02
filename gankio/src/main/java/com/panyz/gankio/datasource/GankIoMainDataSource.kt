package com.panyz.gankio.datasource

import com.panyz.core_frame.base.BaseDataSource
import com.panyz.core_frame.http.callback.ILoadingCallBack
import com.panyz.core_frame.http.callback.IRequestCallBack
import com.panyz.gankio.datas.response.Banners
import com.panyz.gankio.http.HttpApi
import com.panyz.gankio.http.RetrofitManagement

class GankIoMainDataSource(loadingCallBack: ILoadingCallBack?) :BaseDataSource(loadingCallBack) {

    var service: HttpApi = RetrofitManagement.instance.getService()

    fun getBanners(callBack: IRequestCallBack<List<Banners>>)  {
        execute(service.getBanners(),callBack)
    }


}