package com.nik.diceassignment.Lemonade

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.nik.diceassignment.DiceViewModel
import com.nik.diceassignment.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LemonadeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lemonade)
        Log.i("LOL", "123");
        val layout: LinearLayout = findViewById<LinearLayout>(R.id.lemonade_layout)
        val text: TextView = findViewById<TextView>(R.id.lemonade_text)
        val image: ImageView = findViewById<ImageView>(R.id.lemonade_image)

        val lemonade: LemonadeViewModel = LemonadeViewModel()
        val scope = CoroutineScope(Dispatchers.Main)
        scope.launch {
            lemonade.uiState.collect {
                text.text = lemonade.uiState.value.text
                val drawableResource: Int? = lemonade.uiState.value.imageResource
                if (drawableResource != null)
                    image.setImageResource(drawableResource)
            }
        }

        lemonade.action(applicationContext)
        layout.setOnClickListener {
            lemonade.action(applicationContext)
        }
    }
}