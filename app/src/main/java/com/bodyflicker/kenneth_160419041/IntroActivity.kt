package com.bodyflicker.kenneth_160419041

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : AppCompatActivity() {
    companion object {
        val playerName = "PlayerName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        buttonStart.setOnClickListener {
            // var nameInput = editPlayerName.text
            var nameInput = editPlayerName.text.toString()

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(playerName, nameInput)
            startActivity(intent)
        }
    }

}