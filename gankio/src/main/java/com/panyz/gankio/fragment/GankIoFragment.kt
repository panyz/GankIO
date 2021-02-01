package com.panyz.gankio.fragment

import androidx.lifecycle.Observer
import com.panyz.core_frame.base.BaseFragment
import com.panyz.gankio.R
import com.panyz.gankio.viewmodel.GankIoMainViewModel


class GankIoFragment : BaseFragment() {

    private val viewModel:GankIoMainViewModel = GankIoMainViewModel(loadingCallBack)

    override fun getContentView(): Int {
        return R.layout.fragment_gank_io
    }

    override fun initViewModel() {
        viewModel.bannersData.observe(this, Observer {
            println(it)
        })
    }

    override fun loadData() {
        viewModel.getBanners()
    }



}