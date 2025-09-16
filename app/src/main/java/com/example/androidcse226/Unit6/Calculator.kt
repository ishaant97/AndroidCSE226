package com.example.androidcse226.Unit6

import android.util.Log

class Calculator {
    fun add(a: Int, b: Int): Int {
//        Log.d("Calculator", "Adding $a and $b")
        return a + b
    }

    fun subtract(a: Int, b: Int): Int {
        Log.d("Calculator", "Subtracting $a and $b")
        return a - b
    }

    fun multiply(a: Int, b: Int): Int {
        Log.d("Calculator", "Multiplying $a and $b")
        return a * b
    }

    fun divide(a: Int, b: Int): Int {
        return try {
            a/b
        }
        catch (e: Exception){
//            Log.d("Calculator", "Error dividing $a by $b: ${e.message}")
            0
        }
    }
}