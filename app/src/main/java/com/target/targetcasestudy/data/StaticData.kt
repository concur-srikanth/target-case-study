package com.target.targetcasestudy.data

// TODO this can be deleted once you start fetching the data from the API
object StaticData {
  val deals: List<DealItem> = listOf(
    DealItem(
      id = 0,
      title = "Product 1",
      description = "This is product number 1",
      aisle = "a1",
      image_url =  "sample",
      regular_price  = Price(0, "$" , "$0"),
              sale_price  = Price(0, "$" , "$0")

  ))
}