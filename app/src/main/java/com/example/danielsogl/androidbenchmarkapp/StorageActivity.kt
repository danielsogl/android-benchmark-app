package com.example.danielsogl.androidbenchmarkapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_storage.*

class StorageActivity : AppCompatActivity() {

    private class Data(var id: Int, var body: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage)
        title = "Storage Benchmark"

        Paper.init(applicationContext)


        btnStoreAll.setOnClickListener {
            var items = ArrayList<Data>()

            val startTime = System.currentTimeMillis()

            for (i in 0..1000) {
                items.add(Data(i, "Lorem ipsum"))
            }

            Paper.book().write("items", items)

            val stopTime = System.currentTimeMillis()
            val elapsedTime = stopTime - startTime

            Log.d("Elapsed Time", elapsedTime.toString())
        }

        btnStoreSingle.setOnClickListener {

            val startTime = System.currentTimeMillis()

            for (i in 0..1000) {
                Paper.book().write("items_" + i, Data(i, "Lorem ipsum"))
            }

            val stopTime = System.currentTimeMillis()
            val elapsedTime = stopTime - startTime

            Log.d("Elapsed Time", elapsedTime.toString())
        }

        btnReadAll.setOnClickListener {
            val startTime = System.currentTimeMillis()

            Paper.book().read<Data>("items")

            val stopTime = System.currentTimeMillis()
            val elapsedTime = stopTime - startTime

            Log.d("Elapsed Time", elapsedTime.toString())
        }

        btnReadSingle.setOnClickListener {
            val startTime = System.currentTimeMillis()

            for (i in 0..1000) {
                Paper.book().read<Data>("items_" + i)
            }

            val stopTime = System.currentTimeMillis()
            val elapsedTime = stopTime - startTime

            Log.d("Elapsed Time", elapsedTime.toString())
        }

    }
}
