package com.example.android.navigationadvancedsample.rx

import io.reactivex.Scheduler

/**
 * Rx Scheduler Provider (Rx 코드를 어느 스레드에서 실행할지 지정)
 */
interface SchedulerProvider {
    /**
     * IO 스케줄러
     * 동기 I/O를 별도로 처리시켜 비동기 효율을 얻기 위한 스케줄러
     * 네트워크, 각종 I/O 작업을 위한 스케줄러
     *
     * @return Scheduler
     */
    fun io(): Scheduler

    /**
     * UI 스케줄러
     * 안드로이드의 UI 스레드
     * UI 변경을 위한 스케줄러
     *
     * @return Scheduler
     */
    fun ui(): Scheduler

    /**
     * 계산 스케줄러 (별도의 I/O가 없음)
     * 이벤트 루프에서 간단한 연산이나 콜백 처리를 위해 사용
     * 내부적으로 별도의 스레드 풀(RxComputationThreadPool)에서 동작
     * 별도의 설정 없으면 스레드 수는 프로세서의 수와 동일
     *
     * @return Scheduler
     */
    fun computation(): Scheduler
}
