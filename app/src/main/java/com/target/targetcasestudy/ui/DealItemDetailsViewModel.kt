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

class DealItemDetailsViewModel : ViewModel() {

    var businessService: BusinessInteractor = BusinessInteractor()

    val dealDetails = MutableLiveData<DealItem>()
    private val compositeDisposable = CompositeDisposable()

    fun getDealDetails(id : Int) {
        businessService?.getDealDetails(id)?.observeOn(AndroidSchedulers.mainThread())?.subscribeOn(
                Schedulers.io())?.subscribeBy(
                onSuccess = {
                    dealDetails.postValue(it)
                },
                onError = {
                    Log.i("", it.message)
                }
        )?.let {
            compositeDisposable.add(it)
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}
