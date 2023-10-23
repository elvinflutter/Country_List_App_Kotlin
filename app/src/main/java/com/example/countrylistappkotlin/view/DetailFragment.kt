package com.example.countrylistappkotlin.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.countrylistappkotlin.R
import com.example.countrylistappkotlin.viewmodel.DetailViewModel


class DetailFragment : Fragment() {

    private lateinit var viewModel : DetailViewModel
    private var countryId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.getDataFromRoom()

        observelLiveData(view)
    }

    private fun observelLiveData(view: View){
        viewModel.countryLiveData.observe(viewLifecycleOwner, Observer {
            country -> country?.let {
            view.findViewById<TextView>(R.id.countryName).text = country.countryName
            view.findViewById<TextView>(R.id.countryCapital).text = country.countryCapital
            view.findViewById<TextView>(R.id.countryRegion).text = country.countryRegion
            view.findViewById<TextView>(R.id.countryCurrency).text = country.countryCurrency
            view.findViewById<TextView>(R.id.countryLanguage).text = country.countryLanguage

        }
        })
    }


}