package com.panyz.gankio.datasource

import com.panyz.core_frame.http.HttpResponse
import com.panyz.gankio.datas.response.Banners
import com.panyz.gankio.http.HttpApi
import com.panyz.gankio.http.RetrofitManagement
import io.reactivex.Observable

class GankIoMainDataSource {
    var service: HttpApi = RetrofitManagement.instance.getService()

    fun getBanners() : Observable<HttpResponse<List<Banners>>> {
        return service.getBanners()
    }

}