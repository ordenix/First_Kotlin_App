package com.example.firstapp1

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley


class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val postal_code = intent.getStringExtra(TEXT_TO_SEND)

        val city = findViewById<TextView>(R.id.city)
        val community = findViewById<TextView>(R.id.community)
        val district = findViewById<TextView>(R.id.district)
        val voivodeship = findViewById<TextView>(R.id.voivodeship)

        val queue = Volley.newRequestQueue(this)
        val url = "https://polish-zip-codes1.p.rapidapi.com/$postal_code"

        val req: JsonArrayRequest = object : JsonArrayRequest(Request.Method.GET,  url, null,
            Response.Listener {response ->
                city.text = response.getJSONObject(0).getString("miejscowosc")
                community.text = response.getJSONObject(0).getString("gmina")
                district.text = response.getJSONObject(0).getString("powiat")
                voivodeship.text = response.getJSONObject(0).getString("wojewodztwo")
            }, Response.ErrorListener { error ->
                city.text = "ERROR: $error"
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
    fun back (view: View) {
        finish()
    }
}


