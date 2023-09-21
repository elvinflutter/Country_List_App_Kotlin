package com.example.countrylistappkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.countrylistappkotlin.R
import com.example.countrylistappkotlin.model.Model

class CountryAdapter(private val countryList: ArrayList<Model>):RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
    class CountryViewHolder(private var itemView: View) : RecyclerView.ViewHolder(itemView) {
        val countryName: TextView = itemView.findViewById(R.id.countryName)
        val countryRegion: TextView = itemView.findViewById(R.id.countryRegion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.countryName.text = countryList[position].countryName
        holder.countryRegion.text = countryList[position].countryRegion
    }

    fun updateCountryList(newCountryList:List<Model>) {
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }
}