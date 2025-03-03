package com.example.tutorialapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val exitDialogLayout = LayoutInflater.from(this@MainActivity).inflate(R.layout.exit_dialog, null)
            val alter = AlertDialog.Builder(this@MainActivity).setView(exitDialogLayout)
            val exitDialog = alter.show()

            exitDialog.findViewById<Button>(R.id.exit_no)?.setOnClickListener {
                exitDialog.onBackPressed()
            }
            exitDialog.findViewById<Button>(R.id.exit_yes)?.setOnClickListener {
                finish()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        onBackPressedDispatcher.addCallback(callback)

    }
}