package com.example.cafe_bloom


import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast

class ChangeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.change_activity)
    }

    fun visitAgainLogin(view: View?) {
        val oldPassword = findViewById<TextInputEditText>(R.id.oldpassword).text.toString()
        val newPassword = findViewById<TextInputEditText>(R.id.newpassword).text.toString()
        val confirmPassword = findViewById<TextInputEditText>(R.id.confirmpassword).text.toString()


        if (newPassword != confirmPassword) {
            Toast.makeText(this, "Passwords do not match.", Toast.LENGTH_SHORT).show()
            return
        }

        val dbHelper = DBHelperUser(this)
        val userId = dbHelper.getUserIdByPassword(oldPassword)

        if (userId != -1) { // Valid user ID
            val rowsUpdated = dbHelper.updatePassword(userId, newPassword)
            if (rowsUpdated > 0) {
                Toast.makeText(this, "Password updated successfully!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginAgainActivity::class.java))
            } else {
                Toast.makeText(this, "Failed to update password. Try again.", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Old password is incorrect.", Toast.LENGTH_SHORT).show()
        }
    }
}