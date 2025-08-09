package com.example.cafe_bloom

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.HorizontalScrollView



class MyOrders : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notifications)


        val scrollButton = findViewById<Button>(R.id.processing)
        val horizontalScrollView = findViewById<HorizontalScrollView>(R.id.horizontalScrollView)

        scrollButton.setOnClickListener {
            // Scroll right by 200 pixels
            horizontalScrollView.smoothScrollBy(200, 0)
        }
    }
}