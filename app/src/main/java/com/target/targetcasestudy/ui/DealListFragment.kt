package com.target.targetcasestudy.ui

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.target.targetcasestudy.R


class DealListFragment : Fragment(), DealItemClickListener {

  lateinit var recyclerView : RecyclerView
  lateinit var viewModel : DealItemViewModel

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view =  inflater.inflate(R.layout.fragment_deal_list, container, false)

    view.findViewById<RecyclerView>(R.id.recycler_view).layoutManager = LinearLayoutManager(requireContext())
    recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
    recyclerView .adapter = DealItemAdapter(this)

    return view
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    viewModel = ViewModelProvider(this).get(DealItemViewModel::class.java)
    subscribeToGetDeals()

  }

  private fun subscribeToGetDeals() {

    viewModel.deals.observe(this.viewLifecycleOwner, Observer { deals ->
      val adapter = DealItemAdapter(this)
      adapter.deals = deals
      recyclerView.adapter = adapter
      adapter.notifyDataSetChanged()
    })

  }

  override fun onResume() {
    super.onResume()
    viewModel.getDeals()
  }

  override fun onClicked(id : Int) {
    val fragment = DealItemFragment()
    val args = Bundle()
    args.putInt("id",  id)
    fragment.arguments = args

    requireFragmentManager().beginTransaction().replace(R.id.container, fragment).commit()

  }

}
