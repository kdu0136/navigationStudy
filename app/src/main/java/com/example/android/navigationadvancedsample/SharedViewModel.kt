package com.example.android.navigationadvancedsample

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.navigationadvancedsample.rx.SchedulerProvider
import com.example.android.navigationadvancedsample.rx.with
import io.reactivex.Observable

class SharedViewModel: AbstractViewModel() {
    val beforFragmentStr = MutableLiveData<String>()

    fun endFragment(fragName: String) {
        beforFragmentStr.value = fragName
//        launch {
//            Observable.create<String> {
////                this.resultCode = SupportData.setResultCode(oldResultCode = this.resultCode, newResultCode = resultCode)
//                it.onNext(fragName)
//                it.onComplete()
//            }.with(scheduler = scheduler).subscribe {
//                beforFragmentStr.value = it
//            }
//        }
    }
}