package com.target.targetcasestudy.data

import com.google.gson.annotations.SerializedName

data class Price (
    @SerializedName("amount_in_cents")
    val  amount_in_cents : Long,
    @SerializedName("currency_symbol")
    val  currency_symbol : String,
    @SerializedName("display_string")
    val  display_string : String
)
