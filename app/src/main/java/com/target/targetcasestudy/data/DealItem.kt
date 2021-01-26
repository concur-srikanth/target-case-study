package com.target.targetcasestudy.data

import com.google.gson.annotations.SerializedName

data class DealItem(
  var id: Int,
  var title: String,
  var description: String,
  var aisle: String,
  val image_url : String ,
  val regular_price : Price?,
  val sale_price : Price?

)