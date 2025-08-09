package com.example.cafe_bloom

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getstart(view: View?) {
        val goToNextScreen = Intent(applicationContext, LoginActivity::class.java)
        startActivity(goToNextScreen)
    }
}