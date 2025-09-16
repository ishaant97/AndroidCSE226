package com.example.androidcse226.Unit3.UnboundService

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.androidcse226.R

class UnboundMainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_unbound_main_page)

        val btnStart = findViewById<Button>(R.id.btnStart)
        val btnStop = findViewById<Button>(R.id.btnStop)

        val serviceIntent = Intent(this, MyUnboundService::class.java)

        btnStart.setOnClickListener {
            startService(serviceIntent)
        }

        btnStop.setOnClickListener {
            stopService(serviceIntent)
        }
    }
}