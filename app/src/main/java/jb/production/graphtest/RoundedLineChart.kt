package jb.production.graphtest

import android.content.Context
import android.util.Log
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.formatter.ValueFormatter

class RoundedLineChart(private val context: Context) {

    fun styleChart(lineChart: LineChart) {
        lineChart.apply {
            axisRight.isEnabled = false
            axisLeft.apply {
                axisMinimum = 0f
                setDrawGridLines(false)
            }
            xAxis.apply {
                position = XAxis.XAxisPosition.BOTTOM

                isGranularityEnabled = true
                granularity = 1f
                setDrawGridLines(false)
                isEnabled = true
            }

            description = null
            legend.isEnabled = false

            setTouchEnabled(true)
            isDragEnabled = true
            setScaleEnabled(true)
            setPinchZoom(true)
            isDoubleTapToZoomEnabled = false
        }
    }

    class WeekXLabels(): ValueFormatter() {

        private val weeks = arrayOf("sun","mon","tue","wed","thu","fri","sat")

        override fun getFormattedValue(value: Float): String {
            val index = (value.toInt()%7)
            return weeks.getOrElse(index){ "$index" }
        }
    }
}