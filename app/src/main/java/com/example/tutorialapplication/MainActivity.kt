package com.example.tutorialapplication

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstText = findViewById<TextView>(R.id.first)
        val secondText = findViewById<TextView>(R.id.second)
        val diarySection = findViewById<TextView>(R.id.diary_section)

        firstText.setOnClickListener {
            diarySection.setText(R.string.first_text)
        }

        secondText.setOnClickListener {
            diarySection.setText(R.string.second_text)
        }

        diarySection.setOnClickListener {
            val intent = Intent(this, DiaryActivity::class.java)

            intent.putExtra("text", diarySection.text)

            startActivity(intent)
        }
    }
}