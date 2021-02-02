package com.panyz.gankio.fragment

import androidx.lifecycle.Observer
import com.panyz.core_frame.base.BaseFragment
import com.panyz.gankio.R
import com.panyz.gankio.viewmodel.GankIoMainViewModel


class GankIoFragment : BaseFragment() {

    private lateinit var viewModel : GankIoMainViewModel

    override fun getContentView(): Int {
        return R.layout.fragment_gank_io
    }

    override fun initViewModel() {
        viewModel = GankIoMainViewModel(loadingCallBack)
        viewModel.bannersData.observe(this, Observer {
            println(it)
        })
    }

    override fun loadData() {
        viewModel.getBanners()
    }


}