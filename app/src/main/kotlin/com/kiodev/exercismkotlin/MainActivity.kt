package com.kiodev.exercismkotlin;

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_hello.setOnClickListener{
            val intent = Intent(this, HelloWorldActivity::class.java)
            startActivity(intent)
        }

        button_leap.setOnClickListener{
            val intent = Intent(this, LeapYearActivity::class.java)
            startActivity(intent)
        }
    }
}
