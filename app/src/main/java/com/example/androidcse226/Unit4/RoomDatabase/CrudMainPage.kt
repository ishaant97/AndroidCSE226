package com.example.androidcse226.Unit4.RoomDatabase

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcse226.R
import com.example.androidcse226.Unit4.RoomDatabase.db.UserAdapter
import com.example.androidcse226.Unit4.RoomDatabase.db.UserViewModel
import com.example.androidcse226.Unit4.RoomDatabase.db.UsersEntity

class CrudMainPage : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModels()
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_crud_main_page)

        val etName = findViewById<EditText>(R.id.etName)
        val etAge = findViewById<EditText>(R.id.etAge)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        adapter = UserAdapter(emptyList())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Observe LiveData
        userViewModel.allUsers.observe(this) { users ->
            adapter.setData(users)
        }

        // Insert user
        btnAdd.setOnClickListener {
            val name = etName.text.toString()
            val age = etAge.text.toString().toIntOrNull() ?: 0
            if (name.isNotEmpty()) {
                userViewModel.insert(UsersEntity(name = name, age = age))
                etName.text.clear()
                etAge.text.clear()
            }
        }


    }
}