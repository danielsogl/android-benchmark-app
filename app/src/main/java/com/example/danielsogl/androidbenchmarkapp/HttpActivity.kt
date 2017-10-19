package com.example.danielsogl.androidbenchmarkapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.fuel.httpPut
import kotlinx.android.synthetic.main.activity_http.*

class HttpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http)
        title = "HTTP Benchmark"

        FuelManager.instance.basePath = "https://jsonplaceholder.typicode.com"

        btnGet.setOnClickListener {

            val startTime = System.currentTimeMillis()
            var counter = 0

            for (i in 1..200) {

                "/comments".httpGet().responseString { request, response, result ->
                    counter++
                    if (counter == 200) {
                        val stopTime = System.currentTimeMillis()
                        val elapsedTime = stopTime - startTime
                        Log.d("Elapsed Time", elapsedTime.toString())
                    }
                }
            }

        }

        btnPost.setOnClickListener {
            val startTime = System.currentTimeMillis()
            var counter = 0

            for (i in 1..200) {

                ("/comments/").httpPost().body("{ \"id\" : \"1\", \"name\" : \"Lorem Ipsum\", \"email\" : \"test@mail.com\", \"body\" : \"laudantium enim quasi est quidem magnam voluptate ipsam eos\\ntempora quo necessitatibus\\ndolor quam autem quasi\\nreiciendis et nam sapiente accusantium\" }").response { request, response, result ->
                    counter++
                    if (counter == 200) {
                        val stopTime = System.currentTimeMillis()
                        val elapsedTime = stopTime - startTime
                        Log.d("Elapsed Time", elapsedTime.toString())
                    }
                }
            }
        }

        btnPut.setOnClickListener {
            val startTime = System.currentTimeMillis()
            var counter = 0

            for (i in 1..200) {

                ("/comments/" + i.toString()).httpPut().body("{ \"id\" : \"1\", \"name\" : \"Lorem Ipsum\", \"email\" : \"test@mail.com\", \"body\" : \"laudantium enim quasi est quidem magnam voluptate ipsam eos\\ntempora quo necessitatibus\\ndolor quam autem quasi\\nreiciendis et nam sapiente accusantium\" }").response { request, response, result ->
                    counter++
                    if (counter == 200) {
                        val stopTime = System.currentTimeMillis()
                        val elapsedTime = stopTime - startTime
                        Log.d("Elapsed Time", elapsedTime.toString())
                    }
                }
            }
        }

        btnDelete.setOnClickListener {
            val startTime = System.currentTimeMillis()
            var counter = 0

            for (i in 1..500) {

                ("/comments/" + i.toString()).httpDelete().response { request, response, result ->
                    counter++
                    if (counter == 500) {
                        val stopTime = System.currentTimeMillis()
                        val elapsedTime = stopTime - startTime
                        Log.d("Elapsed Time", elapsedTime.toString())
                    }
                }
            }
        }

    }
}
