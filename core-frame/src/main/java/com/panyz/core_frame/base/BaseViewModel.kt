package com.panyz.core_frame.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    val loadingStatu : MutableLiveData<Boolean> = MutableLiveData()

}