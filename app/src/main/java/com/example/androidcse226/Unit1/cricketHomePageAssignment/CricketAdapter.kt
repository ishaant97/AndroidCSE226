package com.example.androidcse226.Unit1.cricketHomePageAssignment


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcse226.R


class CricketAdapter(private val cricketers:List<CricketerData>):
    _root_ide_package_.androidx.recyclerview.widget.RecyclerView.Adapter<CricketAdapter.CricketerViewHolder>() {
    class CricketerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tvName)
        val country: TextView = itemView.findViewById(R.id.tvCountry)
        val rating: TextView = itemView.findViewById(R.id.tvRating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CricketerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cricketer, parent, false)
        return CricketerViewHolder(view)
    }

    override fun onBindViewHolder(holder: CricketerViewHolder, position: Int) {
        val cricketer = cricketers[position]
        holder.name.text = cricketer.name
        holder.country.text = cricketer.country
        holder.rating.text = "Rating: ${cricketer.rating}"
    }

    override fun getItemCount(): Int = cricketers.size
}

