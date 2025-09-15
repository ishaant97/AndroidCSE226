package com.example.androidcse226.Unit5.FusedLocationContineous

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.*
import com.example.androidcse226.R

class MainPage : AppCompatActivity() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationRequest: LocationRequest
    private lateinit var locationCallback: LocationCallback

    private lateinit var tvLocation: TextView
    private lateinit var btnStart: Button
    private lateinit var btnStop: Button

    private var isUpdating = false

    private val locationPermissionRequest =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            if (permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true ||
                permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true) {
                startLocationUpdates()
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        tvLocation = findViewById(R.id.tvLocation)
        btnStart = findViewById(R.id.btnStartUpdates)
        btnStop = findViewById(R.id.btnStopUpdates)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        // Create LocationRequest
        locationRequest = LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 5000) // 5 sec
            .setMinUpdateIntervalMillis(2000) // 2 sec min
            .build()

        // LocationCallback to receive updates
        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                for (location in locationResult.locations) {
                    val locText = "Lat: ${location.latitude}, Lng: ${location.longitude}"
                    tvLocation.text = locText
                }
            }
        }

        btnStart.setOnClickListener {
            locationPermissionRequest.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }

        btnStop.setOnClickListener {
            stopLocationUpdates()
        }
    }

    private fun startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }

        fusedLocationClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            mainLooper
        )
        isUpdating = true
        Toast.makeText(this, "Started Location Updates", Toast.LENGTH_SHORT).show()
    }

    private fun stopLocationUpdates() {
        if (isUpdating) {
            fusedLocationClient.removeLocationUpdates(locationCallback)
            isUpdating = false
            Toast.makeText(this, "Stopped Location Updates", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onPause() {
        super.onPause()
        // Stop updates when app goes to background (to save battery)
        stopLocationUpdates()
    }
}
