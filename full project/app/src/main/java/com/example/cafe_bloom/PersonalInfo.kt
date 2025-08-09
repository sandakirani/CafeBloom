package com.example.cafe_bloom

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class PersonalInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_info)

        // Get references to TextViews
        val nameView = findViewById<TextView>(R.id.nameView)
        val emailView = findViewById<TextView>(R.id.emailView)
        val phoneView = findViewById<TextView>(R.id.phoneView)

        // Get updated user details from the intent
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")

        // Display user details
        nameView.text = name
        emailView.text = email
        phoneView.text = phone
    }

    // Explicit method to handle back button navigation
    fun goBack(view: View?) {
        finish() // This closes the current activity and goes to the previous one
    }

}