package com.example.cafe_bloom

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class LoginAgainActivity: AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_again_activity)

        val login = findViewById<Button>(R.id.button)

        login.setOnClickListener {
            val userName = findViewById<EditText>(R.id.login).text?.toString()?.trim() ?: ""
            val inputPassword = findViewById<TextInputEditText>(R.id.password).text?.toString()?.trim() ?: ""

            if (userName.isEmpty() || inputPassword.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                val helper = DBHelperUser(applicationContext)
                val db = helper.readableDatabase

                // Use parameterized query to prevent SQL injection
                val query = "SELECT * FROM User WHERE UserName = ?"
                val cursor = db.rawQuery(query, arrayOf(userName))

                if (cursor.moveToFirst()) {
                    // Get stored password for the username
                    val storedPassword = cursor.getString(cursor.getColumnIndexOrThrow("Password"))

                    if (storedPassword == inputPassword) {
                        // Successful login
                        Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()

                        val goToMenu = Intent(applicationContext, MenuActivity::class.java)
                        startActivity(goToMenu)

                        // Navigate to the next activity or perform the next action
                    } else {
                        // Password does not match
                        Toast.makeText(this, "Invalid Credentials!", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // Username not found
                    Toast.makeText(this, "Invalid Credentials!", Toast.LENGTH_SHORT).show()
                }

                cursor.close()
                db.close()
            }
        }
    }
}