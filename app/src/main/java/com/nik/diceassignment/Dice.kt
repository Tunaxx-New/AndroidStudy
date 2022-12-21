package com.nik.diceassignment

import android.app.Activity
import android.content.Context

class Dice (val faceCount: Int = 6, val luckyNumber: Int = 4) {

    var value: Int = 0
        private set

    fun roll(): Int {
        value = (1..faceCount).random()
        return value
    }

    fun result(context: Context): String = when(value) {
        1, 2, 3 -> context.resources.getString(R.string.threw_lt3)
        4, 5, 6 -> context.resources.getString(R.string.threw_gt3)
        else    -> context.resources.getString(R.string.threw_else)
    }

    fun isLucky(): Boolean {
        return value == luckyNumber
    }
}