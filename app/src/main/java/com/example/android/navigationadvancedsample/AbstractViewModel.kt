package com.example.android.navigationadvancedsample

import androidx.annotation.CallSuper
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * 뷰모델 가상 클래스
 */
abstract class AbstractViewModel: ViewModel() {
    protected val viewModelTag = javaClass.simpleName

    private val disposable = CompositeDisposable() // 여러 disposable 객체를 관리할수 있는 CompositeDisposable 객체 (같은 이름 작업 처리 block)
    private val jobMap: HashMap<String, Boolean> = HashMap() // disposable 진행중 작업 리스트 이름 (같은 이름 작업 중복 처리위함)

    /**
     * disposable 객체에 작업 추가 (중복 작업 상관 없는 경우)
     */
    fun launch(job: () -> Disposable) {
        // disposable 작업 요청
        disposable.add(job())
    }

    /**
     * disposable 객체에 작업 추가 (중복 작업 들어가면 안될 경우)
     *
     * @param jobName 진행중 작업 리스트에 올릴 job name
     */
    fun launch(jobName: String, job: (String) -> Disposable) {
        if (jobMap[jobName] == null) {
            jobMap[jobName] = true
            // disposable 작업 요청
            disposable.add(job(jobName))
        }
    }

    /**
     * 진행중 작업 리스트에서 제거
     */
    fun endJob(jobName: String) {
        jobMap.remove(jobName)
    }

    /**
     * view model 이 clear 될 떄 disposable 객체 모두 해제
     */
    @CallSuper
    override fun onCleared() {
        super.onCleared()
        disposable.clear()
        jobMap.clear()
    }
}