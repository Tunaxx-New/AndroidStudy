package com.nik.diceassignment

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DiceActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice)

        val roll: Button = findViewById<Button>(R.id.dice_roll)
        val result: TextView = findViewById<TextView>(R.id.dice_text)
        val image: ImageView = findViewById<ImageView>(R.id.dice_image)

        val dice: DiceViewModel = DiceViewModel()
        val scope = CoroutineScope(Dispatchers.Main)
        scope.launch {
            dice.uiState.collect {
                result.text = dice.uiState.value.result
                val drawableResource: Int? = when (dice.uiState.value.value) {
                    1 -> R.drawable.dice_1
                    2 -> R.drawable.dice_2
                    3 -> R.drawable.dice_3
                    4 -> R.drawable.dice_4
                    5 -> R.drawable.dice_5
                    6 -> R.drawable.dice_6
                    else -> null
                }
                if (drawableResource != null)
                    image.setImageResource(drawableResource)
            }
        }

        roll.setOnClickListener {
            dice.roll(applicationContext)
        }
    }
}
