package com.example.cafe_bloom

import android.content.Intent
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

class BrewingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_brewing, container, false)

        val firstproduct = view.findViewById<ConstraintLayout>(R.id.firstproduct)
        val secondproduct = view.findViewById<ConstraintLayout>(R.id.secondproduct)
        val thirdproduct = view.findViewById<ConstraintLayout>(R.id.thirdproduct)
        val fourthproduct = view.findViewById<ConstraintLayout>(R.id.fourthproduct)
        val fifthproduct = view.findViewById<ConstraintLayout>(R.id.fifthproduct)
        val sixthproduct = view.findViewById<ConstraintLayout>(R.id.sixthproduct)
        val seventhproduct = view.findViewById<ConstraintLayout>(R.id.seventhproduct)
        val eightproduct = view.findViewById<ConstraintLayout>(R.id.eightproduct)

        firstproduct.setOnClickListener {
            val intent = Intent(activity, Frenchpress1::class.java)
            startActivity(intent)
        }
        secondproduct.setOnClickListener {
            val intent = Intent(activity, Pourover1::class.java)
            startActivity(intent)
        }
        thirdproduct.setOnClickListener {
            val intent = Intent(activity, Aeropress1::class.java)
            startActivity(intent)
        }
        fourthproduct.setOnClickListener {
            val intent = Intent(activity, Coldbrew1::class.java)
            startActivity(intent)
        }
        fifthproduct.setOnClickListener {
            val intent = Intent(activity, Chemax1::class.java)
            startActivity(intent)
        }
        sixthproduct.setOnClickListener {
            val intent = Intent(activity, Siphon1::class.java)
            startActivity(intent)
        }
        seventhproduct.setOnClickListener {
            val intent = Intent(activity, Mokapot1::class.java)
            startActivity(intent)
        }
        eightproduct.setOnClickListener {
            val intent = Intent(activity, Turkish1::class.java)
            startActivity(intent)
        }

        // Inflate the layout for this fragment
        return view

    }
}