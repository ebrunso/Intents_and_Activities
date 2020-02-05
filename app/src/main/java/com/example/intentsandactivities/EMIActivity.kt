package com.example.intentsandactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import kotlin.math.pow
import android.util.Log
import kotlinx.android.synthetic.main.activity_emi.*

class EMIActivity : AppCompatActivity() {

    lateinit var sbktPrincipal: SeekBar
    lateinit var sbktRate: SeekBar
    lateinit var sbktMonths: SeekBar
    lateinit var tvktEMI: TextView

    var p = 0
    var t = 0
    var r = 0
    var emi = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emi)



        tvktEMI = findViewById(R.id.tvEMI)
        sbktPrincipal = findViewById(R.id.sbPrinciple) as SeekBar
        sbktRate = findViewById(R.id.sbRate) as SeekBar
        sbktMonths = findViewById(R.id.sbMonths) as SeekBar

        sbktPrincipal.max = 100
        sbktMonths.max = 100
        sbktRate.max = 100

        sbktPrincipal.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                p = progress
                tvPrincipleValue.text = p.toString()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
        sbktMonths.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                t = progress
                tvMonthsValue.text = t.toString()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
        sbktRate.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                r = progress
                tvRateValue.text = r.toString()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }

    fun onClick(view: View){
        // Calculate EMI with equation: EMI = (P.r.(1+r)^t) / ((1+r)^t – 1)

        emi = ((p * r * (1 + r).toDouble().pow(t.toDouble()))/
                ((1 + r).toDouble().pow(t.toDouble())))

        tvEMIValue.text = emi.toString()

    }
}
