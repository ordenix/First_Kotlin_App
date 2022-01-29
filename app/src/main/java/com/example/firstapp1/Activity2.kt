package com.example.firstapp1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject


class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        // Get message from last activity
        val postal_code = intent.getStringExtra(TEXT_TO_SEND)

        // set mess
        val textView = findViewById<TextView>(R.id.text_output).apply {
            text = "Witgaj!! $postal_code"
        }

        val queue = Volley.newRequestQueue(this)
        val url = "https://polish-zip-codes1.p.rapidapi.com/$postal_code"

        val req: JsonArrayRequest = object : JsonArrayRequest(Request.Method.GET,  url, null,
            Response.Listener {response ->
                textView.text = "Motto na dziś ${response.getJSONObject(0).getString("miejscowosc")}"
            }, Response.ErrorListener { error ->
                textView.text = "ERROR: $error"
            }) {
            override fun getHeaders(): Map<String, String> {
                val headers = HashMap<String, String>()
                headers["x-rapidapi-host"] = "polish-zip-codes1.p.rapidapi.com"
                headers["x-rapidapi-key"] = "c12d626061msh43653fb2a1f88cbp1d0a56jsndebedd586ca5"
                return headers
            }
        }
        queue.add(req)
    }
}


