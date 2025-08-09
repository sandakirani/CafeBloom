package com.example.cafe_bloom

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class HelpAndSupport : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.helpandsupport)

        // Buttons and EditText
        val contactButton: Button = findViewById(R.id.contact_button)
        val feedbackInput: EditText = findViewById(R.id.feedback_input)
        val submitFeedbackButton: Button = findViewById(R.id.submit_feedback_button)

        // Handle "Contact Support" button click
        contactButton.setOnClickListener {
            // Open email app to contact support
            val emailIntent = Intent(Intent.ACTION_SEND).apply {
                type = "message/rfc822"
                putExtra(Intent.EXTRA_EMAIL, arrayOf("support@coffeeshop.com"))
                putExtra(Intent.EXTRA_SUBJECT, "Help & Support Request")
                putExtra(Intent.EXTRA_TEXT, "Hello, I need help with...")
            }
            startActivity(Intent.createChooser(emailIntent, "Choose an Email client:"))
        }

        // Handle "Submit Feedback" button click
        submitFeedbackButton.setOnClickListener {
            val feedback = feedbackInput.text.toString()
            if (feedback.isNotEmpty()) {
                // Submit feedback (you can save to a database or send to a server)
                Toast.makeText(this, "Thank you for your feedback!", Toast.LENGTH_SHORT).show()
                feedbackInput.text.clear()
            } else {
                Toast.makeText(this, "Please enter your feedback before submitting.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
