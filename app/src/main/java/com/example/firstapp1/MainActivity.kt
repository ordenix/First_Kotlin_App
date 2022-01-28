package com.example.firstapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

const val TEXT_TO_SEND = "com.example.FirstApp1.MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun sendName(view: View) {
        val input_text_name = findViewById<EditText>(R.id.input_name).text.toString()
        val activity2 = Intent(this, Activity2::class.java).apply {
            putExtra(TEXT_TO_SEND, input_text_name)
        }
        startActivity(activity2)
    }
}