package com.example.danielsogl.androidbenchmarkapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    private var listItems = ArrayList<Data>()
    var id: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        title = "List View Benchmark"

        // Init List View
        val listView = findViewById<ListView>(R.id.lv)
        val arrayAdapter = ArrayAdapter<Data>(this, android.R.layout.simple_list_item_1, listItems)

        listView.adapter = arrayAdapter

        btnCreate.setOnClickListener {
            listItems.clear()
            listItems.addAll(buildData())
            arrayAdapter.notifyDataSetChanged()
        }

        btnCreateLots.setOnClickListener {
            listItems.clear()
            listItems.addAll(buildData(10000))
            arrayAdapter.notifyDataSetChanged()
        }

        btnAppend.setOnClickListener {
            listItems.addAll(buildData(10000))
            arrayAdapter.notifyDataSetChanged()
        }

        btnUpdate.setOnClickListener {
            for (i in 0..listItems.size step 10) {
                listItems[i].label += " !!!"
            }
            arrayAdapter.notifyDataSetChanged()
        }

        btnClear.setOnClickListener {
            listItems.clear()
            arrayAdapter.notifyDataSetChanged()
        }
    }

    private fun buildData(count: Int = 1000): ArrayList<Data> {
        val adjectives: Array<String> = arrayOf("pretty", "large", "big", "small", "tall", "short", "long", "handsome", "plain", "quaint", "clean", "elegant", "easy", "angry", "crazy", "helpful", "mushy", "odd", "unsightly", "adorable", "important", "inexpensive", "cheap", "expensive", "fancy")
        val colours: Array<String> = arrayOf("red", "yellow", "blue", "green", "pink", "brown", "purple", "brown", "white", "black", "orange")
        val nouns: Array<String> = arrayOf("table", "chair", "house", "bbq", "desk", "car", "pony", "cookie", "sandwich", "burger", "pizza", "mouse", "keyboard")

        val data = ArrayList<Data>()

        for (i in 0..count) {
            data.add(Data(id, adjectives[random(0, adjectives.size)] + " " + colours[random(0, colours.size)] + " " + nouns[random(0, nouns.size)]))
            id++
        }

        return data

    }

    private fun random(from: Int, to: Int) = (Math.random() * (to - from) + from).toInt()
}

class Data(var id: Int, var label: String)
