package com.panyz.wanandroidapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.panyz.wanandroidapp.R
import com.panyz.wanandroidapp.http.RetrofitManagement
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_wan_android_app.*

class WanAndroidAppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wan_android_app)

        tv.setOnClickListener{
            val projectTree = RetrofitManagement.instance.getService().getProjectTree()
            projectTree.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    println(it.data)
                }
        }
    }
}