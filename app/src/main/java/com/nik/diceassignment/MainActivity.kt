package com.nik.diceassignment


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nik.diceassignment.Lemonade.LemonadeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val intent1: Intent = Intent(this, DiceActivity::class.java)
        //startActivity(intent1)

        val intent2: Intent = Intent(this, LemonadeActivity::class.java)
        startActivity(intent2)
    }
}