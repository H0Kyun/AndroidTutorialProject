package com.example.tutorialapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DiaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)

        val text = intent.getStringExtra("text")
        val diary = findViewById<TextView>(R.id.diary)

        diary.text = text

    }
}