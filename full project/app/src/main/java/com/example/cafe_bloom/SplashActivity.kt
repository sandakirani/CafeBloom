package com.example.cafe_bloom

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class SplashActivity: AppCompatActivity() {
    private val splashTime : Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val goToNextScreen = Intent(this, MainActivity::class.java)
            startActivity(goToNextScreen)
            finish()
        }, splashTime)
    }
}