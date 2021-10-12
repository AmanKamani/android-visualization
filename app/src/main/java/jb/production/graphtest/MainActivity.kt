package jb.production.graphtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import jb.production.graphtest.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val entries = mutableListOf<Entry>()
    private val chart = RoundedLineChart(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for(i in 0..200){
            val random = Random.nextInt(0, i+1)
            val entry = Entry(i.toFloat(),random.toFloat())
            entries.add(entry)
        }

        val lineDataSet = LineDataSet(entries,"Line Chart")
        chart.styleChart(binding.chart)

        binding.chart.data = LineData(lineDataSet)

        binding.chart.xAxis.valueFormatter = RoundedLineChart.WeekXLabels()
        binding.chart.setVisibleXRangeMaximum(6f)
        binding.chart.invalidate()

    }
}