package com.target.targetcasestudy.data

import android.util.Log
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import retrofit2.Call
import retrofit2.Response


open class BusinessInteractor   {

    val businessService : BusinessService? =
          RetrofitClient.getRetrofitInstance()?.create(BusinessService::class.java) // Due to time contraint not using DI tool

    fun getDeals( ) : Single<DealsInfo>? {
        return businessService?.getDeals()
    }

    fun getDealDetails(id: Int): Single<DealItem>? {
        return businessService?.getDealDetails(id)
    }

}
