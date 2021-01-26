package com.target.targetcasestudy.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.target.targetcasestudy.data.BusinessInteractor
import com.target.targetcasestudy.data.DealItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class DealItemViewModel : ViewModel() {

    var businessService  : BusinessInteractor = BusinessInteractor()

    val deals = MutableLiveData<List<DealItem>>()
    private val compositeDisposable = CompositeDisposable()

     fun getDeals() {
       businessService?.getDeals()?.observeOn(AndroidSchedulers.mainThread())?.subscribeOn(
            Schedulers.io())?.subscribeBy(
            onSuccess = {
                deals.postValue(it.deals)
            },
            onError = {
                Log.i( "", it.message)
            }
        )?.let {
            compositeDisposable.add(
                it
            )
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}