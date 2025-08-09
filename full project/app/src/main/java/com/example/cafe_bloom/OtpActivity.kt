package com.example.cafe_bloom

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.Toast


class OtpActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.otp_activity)
    }

    fun goBack(view: View?) {
        finish() // This closes the current activity and goes to the previous one
    }

    //submit button
    fun visitpasswpordreset(view: View?) {
        val otp1 = findViewById<EditText>(R.id.otp_box1).text.toString()
        val otp2 = findViewById<EditText>(R.id.otp_box2).text.toString()
        val otp3 = findViewById<EditText>(R.id.otp_box3).text.toString()
        val otp4 = findViewById<EditText>(R.id.otp_box4).text.toString()

        if (otp1.isEmpty()||otp2.isEmpty() || otp3.isEmpty()|| otp4.isEmpty()) {
            Toast.makeText(this, "Incomplete OTP Number", Toast.LENGTH_SHORT).show()
        }
        else{
            val goToOtpPage = Intent(applicationContext,ChangeActivity::class.java)
            startActivity(goToOtpPage)
        }
        val gotonext = Intent(applicationContext, MenuActivity::class.java)
        startActivity(gotonext)

    }
}