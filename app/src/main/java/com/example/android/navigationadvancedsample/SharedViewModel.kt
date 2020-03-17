package com.example.android.navigationadvancedsample

import androidx.lifecycle.MutableLiveData

class SharedViewModel : AbstractViewModel() {
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