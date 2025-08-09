package com.example.cafe_bloom

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class SignupActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val userName = findViewById<TextInputEditText>(R.id.username)
        val email = findViewById<TextInputEditText>(R.id.email)
        val phoneNumber = findViewById<TextInputEditText>(R.id.phonenumber)
        val enterPassword = findViewById<TextInputEditText>(R.id.password)
        val confirmedPassword = findViewById<TextInputEditText>(R.id.confirmpassword)
        val signup = findViewById<Button>(R.id.signup_button)

        signup.setOnClickListener {
            // Retrieve the updated values when the button is clicked
            val userNameText = userName.text?.toString()?.trim() ?: ""
            val emailText = email.text?.toString()?.trim() ?: ""
            val phoneText = phoneNumber.text?.toString()?.trim() ?: ""
            val passwordText = enterPassword.text?.toString()?.trim() ?: ""
            val confirmedPasswordText = confirmedPassword.text?.toString()?.trim() ?: ""

            // Validate the inputs
            when {
                userNameText.isEmpty() || emailText.isEmpty() || phoneText.isEmpty() || passwordText.isEmpty() -> {
                    Toast.makeText(applicationContext, "All fields are required", Toast.LENGTH_SHORT).show()
                }
                confirmedPasswordText.isEmpty() -> {
                    Toast.makeText(applicationContext, "Confirm Password", Toast.LENGTH_SHORT).show()
                }
                passwordText != confirmedPasswordText -> {
                    Toast.makeText(applicationContext, "Confirm Password is incorrect", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    //


                    val db = DBHelperUser(applicationContext);
                    db.insertUser(userNameText, emailText, phoneText, passwordText)

                    // If all validations pass, navigate to the Login screen
                    val gotoLogin = Intent(applicationContext, LoginActivity::class.java)
                    startActivity(gotoLogin)
                }
            }
        }

        val signin = findViewById<TextView>(R.id.sign_in)
        signin.setOnClickListener {
            val goToSignIn = Intent(applicationContext, LoginActivity::class.java)
            startActivity(goToSignIn)
        }
    }
}