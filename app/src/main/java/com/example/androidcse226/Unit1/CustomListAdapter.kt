package com.example.androidcse226.Unit1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.androidcse226.R

class CustomListAdapter(private val context: Context, private val dataSource: List<Item>) : BaseAdapter() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int  = dataSource.size
    override fun getItem(position: Int): Any = dataSource[position]
    override fun getItemId(position: Int): Long  = position.toLong()
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = convertView ?: inflater.inflate(R.layout.list_item, parent, false)
        val imageView = rowView.findViewById<ImageView>(R.id.image)
        val titleTextView = rowView.findViewById<TextView>(R.id.title)
        val subtitleTextView = rowView.findViewById<TextView>(R.id.subtitle)

        val item = getItem(position) as Item
        imageView.setImageResource(item.imageId)
        titleTextView.text = item.title
        subtitleTextView.text = item.subtitle

        return rowView
    }

}