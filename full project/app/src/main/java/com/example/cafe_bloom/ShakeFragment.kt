package com.example.cafe_bloom

import android.content.Intent
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

class ShakeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_shake, container, false)

        val firstproduct = view.findViewById<ConstraintLayout>(R.id.firstproduct)
        val secondproduct = view.findViewById<ConstraintLayout>(R.id.secondproduct)
        val thirdproduct = view.findViewById<ConstraintLayout>(R.id.thirdproduct)
        val fourthproduct = view.findViewById<ConstraintLayout>(R.id.fourthproduct)
        val fifthproduct = view.findViewById<ConstraintLayout>(R.id.fifthproduct)
        val sixthproduct = view.findViewById<ConstraintLayout>(R.id.sixthproduct)

        firstproduct.setOnClickListener {
            val intent = Intent(activity, Classicvanilladreamshake1::class.java)
            startActivity(intent)
        }
        secondproduct.setOnClickListener {
            val intent = Intent(activity, Iconicchocolate1::class.java)
            startActivity(intent)
        }
        thirdproduct.setOnClickListener {
            val intent = Intent(activity, Strawberrysensation1::class.java)
            startActivity(intent)
        }
        fourthproduct.setOnClickListener {
            val intent = Intent(activity, Cookies1::class.java)
            startActivity(intent)
        }
        fifthproduct.setOnClickListener {
            val intent = Intent(activity, Nutella1::class.java)
            startActivity(intent)
        }
        sixthproduct.setOnClickListener {
            val intent = Intent(activity, Peanutty1::class.java)
            startActivity(intent)
        }


        // Inflate the layout for this fragment
        return view

    }
}