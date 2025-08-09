package com.example.cafe_bloom

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout

class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Find the Personal Info section in the layout
        val personalInfoSection = view.findViewById<LinearLayout>(R.id.personal_info)
        val notificationSection = view.findViewById<LinearLayout>(R.id.notification)
        val changenotificationsection = view.findViewById<LinearLayout>(R.id.change_password)
        val myordersection = view.findViewById<LinearLayout>(R.id.my_order)
        val helpandsupport = view.findViewById<LinearLayout>(R.id.helpandsupport)
        val logout = view.findViewById<Button>(R.id.logout)

        // Set an OnClickListener to navigate to Personal Info activity
        personalInfoSection.setOnClickListener {
            val intent = Intent(activity, PersonalInfo::class.java)
            startActivity(intent)
        }

        notificationSection.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                replace(R.id.frame_layout, NotificationFragment()) // Replace with NotificationFragment
                addToBackStack(null) // Add to back stack for navigation
                commit()
            }
            // Replace the header layout
            replaceHeader(R.layout.activity_header_notification)

            val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
            bottomNavigationView?.selectedItemId = R.id.notification
        }

        changenotificationsection.setOnClickListener {
            val intent2 = Intent(activity, ChangeActivity::class.java)
            startActivity(intent2)
        }

        myordersection.setOnClickListener {
            val intent2 = Intent(activity, Processing::class.java)
            startActivity(intent2)
        }

        helpandsupport.setOnClickListener {
            val intent2 = Intent(activity, HelpAndSupport::class.java)
            startActivity(intent2)
        }

        logout.setOnClickListener {
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
        }


        return view
    }

    private fun replaceHeader(headerLayoutResId: Int) {
        val headerContainer = activity?.findViewById<ViewGroup>(R.id.header) // Assuming your header container has the ID header
        headerContainer?.visibility = View.VISIBLE // Ensure the header is visible
        headerContainer?.removeAllViews() // Clear any existing header views

        // Inflate and add the new header layout
        val newHeader = layoutInflater.inflate(headerLayoutResId, headerContainer, false)
        headerContainer?.addView(newHeader)
    }


}