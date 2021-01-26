package com.target.targetcasestudy.data

import com.google.gson.annotations.SerializedName

data class DealsInfo(
    @SerializedName("products")
    var deals : List<DealItem>
)