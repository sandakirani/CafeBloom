package com.example.cafe_bloom

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button


class Processing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.processing)

        // Find views
        val processing = findViewById<Button>(R.id.processing)
        val picked = findViewById<Button>(R.id.picked_up)
        val cancel = findViewById<Button>(R.id.cancelled)


        processing.setOnClickListener {
            val intent = Intent(this,Processing::class.java)
            startActivity(intent)
        }
        picked.setOnClickListener {
            val intent = Intent(this,PickedUp::class.java) // Replace with your Edit Profile Activity
            startActivity(intent)
        }
        cancel.setOnClickListener {
            val intent = Intent(this,Canceled::class.java) // Replace with your Edit Profile Activity
            startActivity(intent)
        }

    }
    fun goBack(view: View?) {
        finish() // This closes the current activity and goes to the previous one
    }
}