package com.example.danielsogl.androidbenchmarkapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import kotlinx.android.synthetic.main.activity_chart.*
import com.github.mikephil.charting.components.YAxis.AxisDependency
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import java.util.*


class ChartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)
        title = "Chart Benchmark"

        val chart = findViewById<LineChart>(R.id.chart)

        btnRenderChart.setOnClickListener {
            val valsComp1 = (0..500).map { Entry(it.toFloat(), random(1, 100).toFloat()) }

            val setComp1 = LineDataSet(valsComp1, "Data")
            setComp1.axisDependency = AxisDependency.LEFT

            val dataSets = ArrayList<ILineDataSet>()
            dataSets.add(setComp1)

            val data = LineData(dataSets)
            chart.data = data
            chart.invalidate() // refresh
        }
    }

    private fun random(from: Int, to: Int) = (Math.random() * (to - from) + from).toInt()
}
