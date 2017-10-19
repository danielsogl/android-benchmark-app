package com.example.danielsogl.androidbenchmarkapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ViewStackActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_stack)
        title ="View Stack Benchmark"
    }
}
