package com.example.tutorialapplication

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

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

        onBackPressedDispatcher.addCallback(callback)

    }
}