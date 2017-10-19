package com.example.danielsogl.androidbenchmarkapp

import android.util.Log

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_http.*
import java.net.URL

class HttpActivity : AppCompatActivity() {

    var url = URL("https://jsonplaceholder.typicode.com")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http)
        title = "HTTP Benchmark"

        btnGet.setOnClickListener {

        }

        btnPost.setOnClickListener {

        }

        btnPut.setOnClickListener {

        }

        btnDelete.setOnClickListener {

        }

    }
}
