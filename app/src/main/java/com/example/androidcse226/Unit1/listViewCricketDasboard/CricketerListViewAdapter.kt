package com.example.androidcse226.Unit1.listViewCricketDasboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.example.androidcse226.R

class CricketerListViewAdapter(private val context: Context, private val dataSource: List<CricketerItem>) : BaseAdapter() {
    private val inflater = LayoutInflater.from(context)
    override fun getCount(): Int = dataSource.size
    override fun getItem(position: Int): Any = dataSource[position]
    override fun getItemId(position: Int): Long = position.toLong()
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: inflater.inflate(R.layout.card_view_item_cricketer, parent, false)
        val logo = view.findViewById<ImageView>(R.id.logo)
        val name = view.findViewById<TextView>(R.id.tvName)
        val country = view.findViewById<TextView>(R.id.tvCountry)
        val teamRating = view.findViewById<TextView>(R.id.tvRating)
        val rating = view.findViewById<RatingBar>(R.id.rating)

        val item = getItem(position) as CricketerItem
        logo.setImageResource(item.logoId)
        name.text = item.name
        country.text = item.country
        teamRating.text = item.teamRating.toString()
        rating.rating = item.rating.toFloat()

        return view
    }

}