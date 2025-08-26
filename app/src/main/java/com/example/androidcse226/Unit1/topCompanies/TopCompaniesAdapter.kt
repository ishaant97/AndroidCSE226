package com.example.androidcse226.Unit1.topCompanies

import android.content.Context
import android.view.LayoutInflater
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.androidcse226.R

class TopCompaniesAdapter(private val context: Context, private val dataSource: List<TopCompaniesDataClass>) : BaseAdapter() {
    private val inflater = LayoutInflater.from(context)
    override fun getCount(): Int = dataSource.size
    override fun getItem(position: Int): Any? = dataSource[position]
    override fun getItemId(position: Int): Long = position.toLong()
    override fun getView(position: Int, convertView: android.view.View?, parent: android.view.ViewGroup?): android.view.View {
        val view = convertView ?: inflater.inflate(R.layout.card_view_top_companies, parent, false)
        val companyLogo = view.findViewById<ImageView>(R.id.companyLogo)
        val companyName = view.findViewById<TextView>(R.id.companyName)

        val company = getItem(position) as TopCompaniesDataClass
        companyLogo.setImageResource(company.logo)
        companyName.text = company.companyName
        return view
    }
}