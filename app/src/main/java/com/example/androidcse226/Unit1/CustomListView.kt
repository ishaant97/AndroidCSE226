package com.example.androidcse226.Unit1

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidcse226.R

class CustomListView : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_custom_list_view)
        listView = findViewById<ListView>(R.id.customListView)

        val myItems = listOf(
            Item("Item 1", "Sub Item 1", R.drawable.ic_launcher_background),
            Item("Item 2", "Sub Item 2", R.drawable.ic_launcher_background),
            Item("Item 3", "Sub Item 3", R.drawable.ic_launcher_background),
            Item("Item 4", "Sub Item 4", R.drawable.ic_launcher_background),
            Item("Item 5", "Sub Item 5", R.drawable.ic_launcher_background),
        )
        val adapter = CustomListAdapter(this, myItems)
        listView.adapter = adapter

        listView.setOnItemClickListener(object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = myItems[position]
                Toast.makeText(this@CustomListView, "Clicked on ${selectedItem.title}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
