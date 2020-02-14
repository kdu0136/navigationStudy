package com.example.android.navigationadvancedsample.rx

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * 처리는 io 스레드로 전달하고, 처리 이후 ui 스레드로 전달 (Single Type)
 *
 * @param scheduler 요청 처리 스케줄러
 *
 * @return Single<T>
 */
fun <T> Single<T>.with(scheduler: SchedulerProvider): Single<T> = observeOn(scheduler.ui()).subscribeOn(scheduler.io())

/**
 * 처리는 io 스레드로 전달하고, 처리 이후 ui 스레드로 전달 (Observable Type)
 *
 * @param scheduler 요청 처리 스케줄러
 *
 * @return Single<T>
 */
fun <T> Observable<T>.with(scheduler: SchedulerProvider): Observable<T> = observeOn(scheduler.ui()).subscribeOn(scheduler.io())

/**
 * 처리는 io 스레드로 전달하고, 처리 이후 ui 스레드로 전달 (Flowable Type)
 *
 * @param scheduler 요청 처리 스케줄러
 *
 * @return Single<T>
 */
fun <T> Flowable<T>.with(scheduler: SchedulerProvider): Flowable<T> = observeOn(scheduler.ui()).subscribeOn(scheduler.io())

/**
 * 처리는 io 스레드로 전달하고, 처리 이후 ui 스레드로 전달 (Completable Type)
 *
 * @param scheduler 요청 처리 스케줄러
 *
 * @return Single<T>
 */
fun Completable.with(scheduler: SchedulerProvider): Completable = observeOn(scheduler.ui()).subscribeOn(scheduler.io())
