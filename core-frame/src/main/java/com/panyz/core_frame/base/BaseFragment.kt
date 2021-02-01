package com.panyz.core_frame.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import com.panyz.core_frame.R
import kotlinx.android.synthetic.main.fragment_base.*

abstract class BaseFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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
        initViewModel()
        loadData()
    }


    /**
     * 展示加载框
     */
    fun startLoadingView() {
        loading_view.visibility = View.VISIBLE
    }

    /**
     * 隐藏加载框
     */
    fun stopLoadingView() {
        loading_view.visibility = View.INVISIBLE
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