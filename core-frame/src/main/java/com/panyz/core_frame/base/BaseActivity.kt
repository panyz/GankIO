package com.panyz.core_frame.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.panyz.core_frame.R
import com.panyz.core_frame.http.callback.ILoadingCallBack
import kotlinx.android.synthetic.main.activity_base.*

/**
 * Created by：panyz
 * Time：2/4/21
 * Desc：activity基础类
 */
abstract class BaseActivity : AppCompatActivity() {

    var loadingCallBack: ILoadingCallBack?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_base)
        content_view.addView(LayoutInflater.from(this).inflate(getContentView(),null))
        loadingCallBack = object : ILoadingCallBack {
            override fun startLoading() {
                loading_view.visibility = View.VISIBLE
            }

            override fun stopLoading() {
                loading_view.visibility = View.INVISIBLE
            }

        }
        initViewModel()
        initViews()
        loadData()
    }

    abstract fun getContentView(): Int

    /**
     * 初始化ViewModel
     */
    abstract fun initViewModel()

    abstract fun initViews()

    /**
     * 加载数据
     */
    abstract fun loadData()

    fun setTitle(title: String) {
        tv_title.text = title
    }

    fun canBack(flag: Boolean) {
        if (!flag) {
            iv_back.visibility = View.GONE
        }
    }

}