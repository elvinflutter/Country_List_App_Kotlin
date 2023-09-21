package com.example.countrylistappkotlin.view



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        observelLiveData()

    }

    fun observelLiveData(){
        val countryListRecyclerView = view?.findViewById<RecyclerView>(R.id.countryList)
        val errorRecyclerView = view?.findViewById<RecyclerView>(R.id.errorConnectText)
        val loadingRecyclerView = view?.findViewById<RecyclerView>(R.id.countryLoad)
        viewModel.countries.observe(viewLifecycleOwner, Observer {
            countries -> countries?.let {
                countryListRecyclerView?.visibility = View.VISIBLE
                countryAdapter.updateCountryList(countries)
            }
        })

        viewModel.countryError.observe(viewLifecycleOwner, Observer {
            error -> error?.let {
                if(it) {
                    errorRecyclerView?.visibility = View.VISIBLE
                } else {
                    errorRecyclerView?.visibility = View.GONE
                }
        }
        })
        viewModel.countryLoading.observe(viewLifecycleOwner, Observer {
                error -> error?.let {
            if(it) {
                loadingRecyclerView?.visibility = View.VISIBLE
                countryListRecyclerView?.visibility = View.GONE
                errorRecyclerView?.visibility = View.GONE

            } else {
                loadingRecyclerView?.visibility = View.GONE
            }
        }
        })
    }
}

//        val data = view.findViewById<Button>(R.id.my_btn)
//
//        data.setOnClickListener{
//            //findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
//            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment()
//            Navigation.findNavController(it).navigate(action)
//        }


