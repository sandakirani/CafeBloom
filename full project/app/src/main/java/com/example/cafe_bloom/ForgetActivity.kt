package com.example.cafe_bloom

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.TextView


class ForgetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forget_activity)

    }
    fun goBack(view: View?) {
        finish() // This closes the current activity and goes to the previous one
    }
    //continue button

    fun visitotppage(view: View?) {
        val email = findViewById<EditText>(R.id.email).text.toString()
        val warningTextView = findViewById<TextView>(R.id.emailWarningText)

        val emailPattern = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")

        if (email.matches(emailPattern)) {
            warningTextView.visibility = View.GONE
            val goToOtpPage = Intent(applicationContext, OtpActivity::class.java)
            startActivity(goToOtpPage)
        } else {
            warningTextView.visibility = View.VISIBLE // Show the warning message
            warningTextView.text = "Please enter a valid email address"
        }

    }
}


