package com.example.androidcse226.Unit1.listViewCricketDasboard

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidcse226.R

class Dashboard : AppCompatActivity() {

    private lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        listView = findViewById(R.id.listView)
        val myItem = listOf(
            CricketerItem ("Virat Kohli", "India", 890, 4.5, R.drawable.ic_launcher_background),
            CricketerItem ("Babar Azam", "Pakistan", 870, 2.5, R.drawable.ic_launcher_background),
            CricketerItem ("Steve Smith", "Australia", 860, 4.7, R.drawable.ic_launcher_background),
            CricketerItem ("Rohit Sharma", "India", 850, 4.8, R.drawable.ic_launcher_background),
            CricketerItem ("Kane Williamson", "New Zealand", 845, 4.9, R.drawable.ic_launcher_background),
            CricketerItem ("Joe Root", "England", 840, 5.0, R.drawable.ic_launcher_background),
            CricketerItem ("David Warner", "Australia", 835, 5.1, R.drawable.ic_launcher_background),
            CricketerItem ("Shubman Gill", "India", 830, 5.2, R.drawable.ic_launcher_background),
            CricketerItem ("Marnus Labuschagne", "Australia", 825, 5.3, R.drawable.ic_launcher_background),
            CricketerItem ("Quinton de Kock", "South Africa", 820, 5.4, R.drawable.ic_launcher_background)
        )

        val adapter = CricketerListViewAdapter(this, myItem)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = myItem[position]
            Toast.makeText(this, "Clicked on ${selectedItem.name}", Toast.LENGTH_SHORT).show()
        }
    }
}