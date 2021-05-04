package com.bodyflicker.kenneth_160419041

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // Index pertanyaan sekarang
    var currentQuestion = 0

    var score = 0

    // Array yang menyimpan pertanyaan
    var arrayOfQuestions = arrayOf(
            Question("Krusty Krab adalah burger favorit Bikini Bottom", false),
            Question("Spongebob tinggal di dasar laut di dalam rumah nanas", true),
            Question("Karen adalah nama istri Plankton", true),
            Question("Mermaid Man adalah mantan superhero bikini bottom", true),
            Question("Squidwards memiliki empat buah tangan", false)
    )

    fun newHighScore(score:Int) {
        // Define packagename as sharepref
        var sharedFile = "com.bodyflicker.kenneth_160419041"

        // Creating/acessing SharedPreferences
        var shared: SharedPreferences = getSharedPreferences(sharedFile, Context.MODE_PRIVATE)

        // Access the object and create key-value pair and store it
        var editor:SharedPreferences.Editor = shared.edit()
        editor.putInt("HighScore", score)
        editor.apply()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var playerName = intent.getStringExtra(IntroActivity.playerName)

        textWelcome.text = "Welcome " + playerName

        // Shuffle array
        // 1. Change to mutable list for shuffle()
        var mutableListQuestions = arrayOfQuestions.toMutableList()
        // 2. Shuffle questions
        mutableListQuestions.shuffle()
        // 3. Change back to array
        arrayOfQuestions = mutableListQuestions.toTypedArray()

        // Set question
        textQuestion.text = arrayOfQuestions[currentQuestion].question

        // Total questions
        var totalQuestions = arrayOfQuestions.size

        // Incorrect counter
        var incorrect = 0

        // Change current question index
        fun changeCurrentQuestionIndex() {
            currentQuestion++
            currentQuestion %= totalQuestions
        }

        buttonTrue.setOnClickListener {
            if(arrayOfQuestions[currentQuestion].answer)
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
            else if(incorrect > 4) {
                Toast.makeText(this, "Kamu kalah. Silahkan belajar lebih giat.", Toast.LENGTH_SHORT).show()
                buttonTrue.isEnabled = false
                buttonFalse.isEnabled = false
            }
            else {
                Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
                incorrect++
            }
            changeCurrentQuestionIndex()

            // Set currentQuestion index
            textQuestion.text = arrayOfQuestions[currentQuestion].question
        }

        buttonFalse.setOnClickListener {
            if(arrayOfQuestions[currentQuestion].answer)
                Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
            else if(incorrect > 4) {
                Toast.makeText(this, "Kamu kalah. Silahkan belajar lebih giat.", Toast.LENGTH_SHORT).show()
                buttonTrue.isEnabled = false
                buttonFalse.isEnabled = false
            }
            else {
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                incorrect++
            }
            changeCurrentQuestionIndex()

            // Set currentQuestion index
            textQuestion.text = arrayOfQuestions[currentQuestion].question
        }

    }
}