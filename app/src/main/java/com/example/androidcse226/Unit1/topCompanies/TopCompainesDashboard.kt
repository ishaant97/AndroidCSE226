package com.example.androidcse226.Unit1.topCompanies

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidcse226.R
import kotlin.jvm.java

class TopCompainesDashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_top_compaines_dashboard)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listView = findViewById<ListView>(R.id.listView)
        val companyItem = listOf(
            TopCompaniesDataClass("Android Companies", R.drawable.android_logo),
            TopCompaniesDataClass("Ios Companies", R.drawable.ios_logo),
            TopCompaniesDataClass("React Companies", R.drawable.react_logo),
            TopCompaniesDataClass("Full Stack Companies", R.drawable.full_stack_logo)
        )
        val adapter = TopCompaniesAdapter(this, companyItem)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = companyItem[position]
            Toast.makeText(this, "Clicked on ${selectedItem.companyName}", Toast.LENGTH_SHORT).show()
            if(selectedItem.companyName == "Android Companies"){
                startActivity(Intent(this, AndroidTopCompanies::class.java))
            }
            else if(selectedItem.companyName == "Ios Companies"){
                startActivity(Intent(this, IosTopCompanies::class.java))
            }
            else if(selectedItem.companyName == "React Companies"){
                startActivity(Intent(this, ReactTopCompanies::class.java))
            }
            else if(selectedItem.companyName == "Full Stack Companies"){
                startActivity(Intent(this, FullStackTopCompanies::class.java))
            }
            else{
                Toast.makeText(this, "No Activity Found", Toast.LENGTH_SHORT).show()
            }
        }
    }
}