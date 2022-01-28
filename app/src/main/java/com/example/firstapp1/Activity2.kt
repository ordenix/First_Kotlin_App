package com.example.firstapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.volley.toolbox.StringRequest

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        // Get message from last activity
        val message = intent.getStringExtra(TEXT_TO_SEND)

        // set mess
        val textView = findViewById<TextView>(R.id.text_output).apply {
            text = "Witaj!! $message"
        }



    }
}