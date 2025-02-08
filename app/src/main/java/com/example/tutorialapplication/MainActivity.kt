package com.example.tutorialapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import com.example.tutorialapplication.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        binding.first.setOnClickListener {
            binding.diarySection.setText(R.string.first_text)
        }

        binding.second.setOnClickListener {
            binding.diarySection.setText(R.string.second_text)
        }

        binding.diarySection.setOnClickListener {
            val intent = Intent(this, DiaryActivity::class.java)

            intent.putExtra("text", binding.diarySection.text)

            startActivity(intent)
        }
    }
}