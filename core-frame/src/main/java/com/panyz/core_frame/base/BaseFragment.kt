package com.panyz.core_frame.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import com.panyz.core_frame.R
import com.panyz.core_frame.http.ILoadingCallBack
import kotlinx.android.synthetic.main.fragment_base.*

abstract class BaseFragment : Fragment() {


    var loadingCallBack: ILoadingCallBack?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view  = inflater.inflate(R.layout.fragment_base, container, false) as RelativeLayout
        view.addView(inflater.inflate(getContentView(), container, false), 0)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadingCallBack = object : ILoadingCallBack {
            override fun startLoading() {
                loading_view.visibility = View.VISIBLE
            }

            override fun stopLoading() {
                loading_view.visibility = View.INVISIBLE
            }

        }
        initViewModel()
        loadData()


    }


    /**
     * 获取子类fragment布局
     */
    abstract fun getContentView():Int

    /**
     * 初始化ViewModel
     */
    abstract fun initViewModel()

    /**
     * 加载数据
     */
    abstract fun loadData()

}