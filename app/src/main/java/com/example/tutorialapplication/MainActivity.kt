package com.example.tutorialapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.RecyclerView
import com.example.tutorialapplication.adaptor.DayGridAdaptor

class MainActivity : ComponentActivity() {

    private var canClose = false

    private val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (canClose) {
                finish()
            }

            canClose = true

            Handler(Looper.getMainLooper()).postDelayed({ canClose = false }, 500)

            Toast.makeText(this@MainActivity, "한 번 더 누르면 종료함 ㅅㄱ", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list: MutableList<String> = arrayListOf()
        for (i: Int in 1..30 ) {
            list.add("$i")
        }

        val adaptor = DayGridAdaptor(list)
        adaptor.diarySection = findViewById(R.id.diary_section)
        adaptor.diarySection.setOnClickListener {
            val intent = Intent(this, DiaryActivity::class.java)
            intent.putExtra("text", adaptor.diarySection.text)
            startActivity(intent)
        }

        val recycleGrid = findViewById<RecyclerView>(R.id.date_grid)
        recycleGrid.adapter = adaptor

        onBackPressedDispatcher.addCallback(callback)

    }
}