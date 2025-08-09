package com.example.cafe_bloom

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class EditProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val dbHelper = DBHelperUser(applicationContext)

        // Get references to input fields and the button
        val editProfileButton = findViewById<Button>(R.id.editProfileButton)
        val editName = findViewById<EditText>(R.id.editName)
        val editEmail = findViewById<EditText>(R.id.editEmail)
        val editPhone = findViewById<EditText>(R.id.editPhone)

        // Update button logic
        editProfileButton.setOnClickListener {
            val nameText = editName.text.toString().trim()
            val emailText = editEmail.text.toString().trim()
            val phoneText = editPhone.text.toString().trim()

            if (nameText.isNotEmpty() && emailText.isNotEmpty() && phoneText.isNotEmpty()) {
                val rowsUpdated = dbHelper.updateUser(nameText, emailText, phoneText)

                if (rowsUpdated > 0) {
                    Toast.makeText(this, "User details updated successfully!", Toast.LENGTH_SHORT).show()

                    // Pass updated data to the next page
                    val intent = Intent(this, PersonalInfo::class.java)
                    intent.putExtra("name", nameText)
                    intent.putExtra("email", emailText)
                    intent.putExtra("phone", phoneText)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Failed to update user details. Check the email.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "All fields must be filled!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Explicit method to handle back button navigation
    fun goBack(view: View?) {
        finish() // This closes the current activity and goes to the previous one
    }
}