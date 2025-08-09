package com.example.cafe_bloom

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import com.example.cafe_bloom.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(MenuFragment())

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    replaceFragment(MenuFragment())
                    replaceHeader(R.layout.activity_header_menu) // Example for the home header
                }
                R.id.notification -> {
                    replaceFragment(NotificationFragment())
                    replaceHeader(R.layout.activity_header_notification) // Ensure the header is shown
                }
                R.id.profile -> {
                    replaceFragment(ProfileFragment())
                    hideHeader() // Hide the header for the profile
                }

                R.id.cart -> {
                    replaceFragment(CartFragment())
                    hideHeader()
                }
                else -> {
                    // Handle other cases if needed
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

    private fun replaceHeader(headerLayoutResId: Int) {
        val headerContainer = findViewById<ViewGroup>(R.id.header) // Assuming your header container has the ID header
        headerContainer?.visibility = View.VISIBLE // Ensure the header is visible
        headerContainer?.removeAllViews() // Clear any existing header views

        // Inflate and add the new header layout
        val newHeader = layoutInflater.inflate(headerLayoutResId, headerContainer, false)
        headerContainer?.addView(newHeader)
    }

    private fun hideHeader() {
        val headerContainer = findViewById<ViewGroup>(R.id.header) // Assuming your header container has the ID header
        headerContainer?.visibility = View.GONE // Hide the header
    }
}