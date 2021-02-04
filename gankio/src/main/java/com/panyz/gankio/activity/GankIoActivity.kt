package com.panyz.gankio.activity

import com.panyz.core_frame.base.BaseActivity
import com.panyz.gankio.R

class GankIoActivity : BaseActivity() {

    override fun getContentView(): Int {
        return R.layout.activity_gank_io
    }

    override fun initViewModel() {
    }

    override fun initViews() {
        setTitle("干货集中营")
        canBack(false)
    }

    override fun loadData() {

    }
}