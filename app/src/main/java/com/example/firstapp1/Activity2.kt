package com.example.firstapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

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
       // val textView = findViewById<TextView>(R.id.text)
// ...

// Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "http://kodpocztowy.intami.pl/api/41-500"
// Request a string response from the provided URL.
        val jsonObjectRequest = JsonArrayRequest(Request.Method.GET, url, null,
            Response.Listener { response ->
                textView.text = "Motto na dziś ${response.getJSONObject(0).getString("miasto")}"
            },
            Response.ErrorListener { error ->
                // TODO: Handle error
            }
        )

// Add the request to the RequestQueue.
        queue.add(jsonObjectRequest)


    }
}