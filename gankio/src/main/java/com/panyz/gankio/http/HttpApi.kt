package com.panyz.gankio.http

import com.panyz.core_frame.http.HttpResponse
import com.panyz.gankio.datas.response.Banners
import io.reactivex.Observable
import retrofit2.http.GET

interface HttpApi {

    @GET("bannerss")
    open fun getBanners(): Observable<HttpResponse<List<Banners>>>


}