package com.target.targetcasestudy.ui

import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import com.target.targetcasestudy.R


class DealItemFragment : Fragment() {

  lateinit var viewModel : DealItemDetailsViewModel
  var id : String = ""
  lateinit var imageView : ImageView
  lateinit var priceTextView : TextView

  lateinit var regularPriceTextView : TextView
  lateinit var title : TextView
  lateinit var description : TextView


  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    val view =  inflater.inflate(R.layout.fragment_deal_item, container, false)
    imageView = view.findViewById<ImageView>(R.id.deal_list_item_image_view)
    priceTextView = view.findViewById<TextView>(R.id.deal_list_item_sale_price)
    regularPriceTextView = view.findViewById<TextView>(R.id.deal_list_item_regular_price)

    title = view.findViewById<TextView>(R.id.deal_list_item_title)
    description = view.findViewById<TextView>(R.id.deal_list_item_desc)


    return view
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    viewModel = ViewModelProvider(this).get(DealItemDetailsViewModel::class.java)

    subscribeToGetDeals()
  }

  private fun subscribeToGetDeals() {
    viewModel.dealDetails.observe(this.viewLifecycleOwner, Observer { deal ->
      // Fill UI Data using data from
      Picasso.with(context).load(deal.image_url)
              .into(imageView)

       if(deal.sale_price == null){
        priceTextView.visibility = View.INVISIBLE
       }else {
         priceTextView.text = deal.sale_price?.display_string
         regularPriceTextView.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG;
       }

      regularPriceTextView.text = "Reg : " + deal.regular_price?.display_string

      title.text = deal.title
      description.text = deal.description

    })

  }

  override fun onResume() {
    super.onResume()
    viewModel.getDealDetails(arguments!!.getInt("id"))
  }

}
