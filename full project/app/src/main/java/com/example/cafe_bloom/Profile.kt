package com.example.cafe_bloom

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout

class
Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_profile)

        // Find views
        val profilePicture = findViewById<ImageView>(R.id.profile_Pic) // Match your XML
        val personalInfo = findViewById<LinearLayout>(R.id.personal_info) // Match your XML
        val changepassword = findViewById<LinearLayout>(R.id.change_password)
        val myorder = findViewById<LinearLayout>(R.id.my_order)
        val help = findViewById<LinearLayout>(R.id.helpandsupport)
        val notification = findViewById<LinearLayout>(R.id.notification)

        // Navigate to Profile Information Page when profile picture is clicked
        profilePicture.setOnClickListener {
            val intent = Intent(this, PersonalInfo::class.java)
            startActivity(intent)
        }

        // Navigate to Profile Information Page when personal_info is clicked
        personalInfo.setOnClickListener {
            val intent = Intent(this, PersonalInfo::class.java)
            startActivity(intent)
        }
        myorder.setOnClickListener {
            val intent = Intent(this, Processing::class.java)
            startActivity(intent)
        }
        changepassword.setOnClickListener {
            val intent = Intent(this, ChangeActivity::class.java)
            startActivity(intent)
        }
        help.setOnClickListener{
            val intent = Intent(this,HelpAndSupport::class.java)
            startActivity(intent)
        }
        notification.setOnClickListener{
            val intent = Intent(this,MenuActivity::class.java)
            startActivity(intent)
        }
    }

    // Explicit method to handle back button navigation
    fun goBack(view: View?) {
        finish() // This closes the current activity and goes to the previous one
    }

    fun logout(view:View?){
        val logout = Intent(applicationContext,MainActivity::class.java)
        startActivity(logout)
    }
}


