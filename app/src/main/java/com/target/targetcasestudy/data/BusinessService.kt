package com.target.targetcasestudy.data

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BusinessService {

    @GET("mobile_case_study_deals/v1/deals")
    fun getDeals( ) : Single<DealsInfo>

    @GET("mobile_case_study_deals/v1/deals/{id}")
    fun getDealDetails(@Path("id") dealid : Int ) : Single<DealItem>

}