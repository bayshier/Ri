package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.TimeUtils
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private var currentDegree: Float = 0.toFloat()

    private val MonthOfDay = 1440f//当天的总分钟数

    private val degree = 360 / MonthOfDay//每分钟所对应的角度

    private var currentTimeValue: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        currentTimeValue = getDatemHH_mm(System.currentTimeMillis())
        val split1 = currentTimeValue!!.split(":".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()
        val m = ParseUtil.parseInt(split1[0]) * 60 + ParseUtil.parseInt(split1[1])

        currentDegree = degree * m
        
        AnimatorUtils.rotateViewShow(this, iv_zhizhen, currentDegree)

    }

    fun getDatemHH_mm(time: Long): String {
        val format = SimpleDateFormat("HH:mm", Locale.CHINA)
        val date = Date(time)
        return format.format(date)
    }

}
