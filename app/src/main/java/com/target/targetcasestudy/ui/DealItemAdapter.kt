package com.target.targetcasestudy.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.target.targetcasestudy.R
import com.target.targetcasestudy.data.DealItem

class DealItemAdapter(listener : DealItemClickListener) : RecyclerView.Adapter<DealItemViewHolder>() {

  var  deals : List<DealItem> = mutableListOf()
  var  listener : DealItemClickListener = listener

  lateinit var context : Context

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealItemViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    this.context = parent.context
    val view = inflater.inflate(R.layout.deal_list_item_2, parent, false)

    return DealItemViewHolder(view)
  }

  override fun getItemCount(): Int {
    return  deals.size
  }

  override fun onBindViewHolder(viewHolder: DealItemViewHolder, position: Int) {
    val item = deals[position]
    viewHolder.itemView.findViewById<TextView>(R.id.deal_list_item_title).text = item.title ?: ""
    viewHolder.itemView.findViewById<TextView>(R.id.deal_list_item_price).text = item.regular_price?.display_string?: ""
    viewHolder.itemView.findViewById<TextView>(R.id.deal_list_item_aisle).text = item.aisle

  Picasso.with(viewHolder.itemView.context).load(deals[position].image_url)
    .into(viewHolder.itemView.findViewById<ImageView>(R.id.deal_list_item_image_view))

    viewHolder.itemView.setOnClickListener(View.OnClickListener {
      listener.onClicked( deals[position].id)
    })
  }

}

class DealItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}