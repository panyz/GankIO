package com.panyz.wanandroidapp.http

import com.panyz.wanandroidapp.datas.responses.ProjectTree
import io.reactivex.Observable
import retrofit2.http.GET

interface HttpApi {

    @GET("project/tree/json")
    open fun getProjectTree() : Observable<List<ProjectTree>>

}