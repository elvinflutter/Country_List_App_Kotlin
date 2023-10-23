package com.example.countrylistappkotlin.view



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.countrylistappkotlin.R
import com.example.countrylistappkotlin.adapter.CountryAdapter
import com.example.countrylistappkotlin.viewmodel.HomeViewModel


class HomeFragment : Fragment() {

    private lateinit var viewModel : HomeViewModel
    private val countryAdapter = CountryAdapter(arrayListOf())



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.refreshData()

        val countryListRecyclerView = view.findViewById<RecyclerView>(R.id.countryList)
        countryListRecyclerView.layoutManager = LinearLayoutManager(context)
        countryListRecyclerView.adapter = countryAdapter

        observelLiveData(view)

    }

     private fun observelLiveData(view: View){

        viewModel.countries.observe(viewLifecycleOwner, Observer {
            countries -> countries?.let {
                view.findViewById<RecyclerView>(R.id.countryList).visibility = View.VISIBLE
                countryAdapter.updateCountryList(countries)
            }
        })

         viewModel.countryError.observe(viewLifecycleOwner, Observer {
             error -> error?.let {
                 if(it){
                    view.findViewById<TextView>(R.id.errorConnectText).visibility = View.VISIBLE
                     view.findViewById<RecyclerView>(R.id.countryList).visibility = View.GONE
                 } else {
                     view.findViewById<TextView>(R.id.errorConnectText).visibility = View.GONE
                 }
         }
         })

         viewModel.countryLoading.observe(viewLifecycleOwner, Observer {
             loading -> loading?.let {
                 if(it) {
                     view.findViewById<ProgressBar>(R.id.countryLoading).visibility = View.VISIBLE
                     view.findViewById<RecyclerView>(R.id.countryList).visibility = View.GONE
                     view.findViewById<TextView>(R.id.errorConnectText).visibility = View.GONE
                 } else {
                     view.findViewById<ProgressBar>(R.id.countryLoading).visibility = View.GONE
                 }
         }
         })


    }
}




