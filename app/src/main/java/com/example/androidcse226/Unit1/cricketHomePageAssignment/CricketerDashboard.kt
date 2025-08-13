package com.example.androidcse226.Unit1.cricketHomePageAssignment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcse226.R


class CricketerDashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cricketer_dashboard)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val cricketers = listOf(
            CricketerData("Virat Kohli", "India", 890),
            CricketerData("Babar Azam", "Pakistan", 870),
            CricketerData("Steve Smith", "Australia", 860),
            CricketerData("Rohit Sharma", "India", 850),
            CricketerData("Kane Williamson", "New Zealand", 845),
            CricketerData("Joe Root", "England", 840),
            CricketerData("David Warner", "Australia", 835),
            CricketerData("Shubman Gill", "India", 830),
            CricketerData("Marnus Labuschagne", "Australia", 825),
            CricketerData("Quinton de Kock", "South Africa", 820)
        )

        val adapter = CricketAdapter(cricketers)
        recyclerView.adapter = adapter
    }
}