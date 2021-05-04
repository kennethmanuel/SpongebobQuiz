package com.bodyflicker.kenneth_160419041

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Define package name
        var sharedFile = "com.bodyflicker.kenneth_160419041"

        // Create/accessing SharedPreferences
        var shared:SharedPreferences = getSharedPreferences(sharedFile, Context.MODE_PRIVATE)

        // Access object value with related key
        var highScore = shared.getInt("HighScore", 0)

        textHighScore.text = highScore.toString()

    }
}