package com.example.cafe_bloom

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView

class MenuFragment : Fragment() {
    private lateinit var shakeButton: ImageButton
    private lateinit var iceCoffeeButton: ImageButton
    private lateinit var hotDrinksButton: ImageButton
    private lateinit var cokeButton: ImageButton
    private lateinit var brewingButton: ImageButton
    private lateinit var breakfastButton: ImageButton


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        shakeButton = view.findViewById(R.id.shakes)
        shakeButton.setOnClickListener {
            shakeHeader()

        }

        iceCoffeeButton = view.findViewById(R.id.iceCoffee)
        iceCoffeeButton.setOnClickListener {
            icecoffeeHeader()

        }

        hotDrinksButton = view.findViewById(R.id.hotDrinks)
        hotDrinksButton.setOnClickListener {
           hotdrinksHeader()

        }

        cokeButton = view.findViewById(R.id.coke)
        cokeButton.setOnClickListener {
           cokeHeader()

        }


        brewingButton = view.findViewById(R.id.brewingCoffee)
        brewingButton.setOnClickListener {
            brewingcoffeeHeader()
        }

        breakfastButton = view.findViewById(R.id.breakfast)
        breakfastButton.setOnClickListener {
           breakfastHeader()
        }

        return view
    }

    private fun shakeHeader() {
        val shakeFragment = ShakeFragment()
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.frame_layout, shakeFragment)
            ?.addToBackStack(null)
            ?.commit()
        val headerContainer = activity?.findViewById<ViewGroup>(R.id.header)
        headerContainer?.removeAllViews() // Remove existing header views

        // Inflate and add the new header layout
        val newHeader = layoutInflater.inflate(R.layout.activity_header, headerContainer, false)
        headerContainer?.addView(newHeader)

        // Retrieve the newly inflated Shake button
        val newShakeButton = newHeader.findViewById<Button>(R.id.shake)

        // Change the Shake button's background to select_button
        newShakeButton.setBackgroundResource(R.drawable.select_button)

        // Now, get the container that holds all your horizontal buttons
        val buttonListContainer =
            headerContainer?.findViewById<LinearLayout>(R.id.listbutton)  // Replace with the correct container ID

        // If the container is found, move the new breakfast button to the first position
        buttonListContainer?.let {
            // Remove the new breakfast button from its current position
            buttonListContainer.removeView(newShakeButton)

            // Add the new breakfast button to the first position (index 0)
            buttonListContainer.addView(newShakeButton, 0)

            // Optionally, you can update the background here too
            newShakeButton.setBackgroundResource(R.drawable.select_button)
        }

        val newIceCoffeeButton = newHeader.findViewById<Button>(R.id.iced_coffee)
        val newHotDrinkeeButton = newHeader.findViewById<Button>(R.id.hot_drinks)
        val newCokeButton = newHeader.findViewById<Button>(R.id.coke)
        val newBrewingCoffeeButton = newHeader.findViewById<Button>(R.id.brewing_coffee)
        val newBreakfastButton = newHeader.findViewById<Button>(R.id.breakfast)

        newIceCoffeeButton.setOnClickListener {
            icecoffeeHeader()
        }
        newHotDrinkeeButton.setOnClickListener {
            hotdrinksHeader()
        }
        newCokeButton.setOnClickListener {
            cokeHeader()
        }
        newBrewingCoffeeButton.setOnClickListener {
            brewingcoffeeHeader()
        }
        newBreakfastButton.setOnClickListener {
            breakfastHeader()
        }
    }

    private fun icecoffeeHeader(){
        val iceCoffeeFragment = IceCoffeeFragment()
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.frame_layout, iceCoffeeFragment)
            ?.commit()

        val headerContainer = activity?.findViewById<ViewGroup>(R.id.header)
        headerContainer?.removeAllViews() // Remove existing header views

        // Inflate and add the new header layout
        val newHeader = layoutInflater.inflate(R.layout.activity_header, headerContainer, false)
        headerContainer?.addView(newHeader)

        // Retrieve the newly inflated Shake button
        val newIceCoffeeButton = newHeader.findViewById<Button>(R.id.iced_coffee)

        // Change the Shake button's background to select_button
        newIceCoffeeButton.setBackgroundResource(R.drawable.select_button)

        // Now, get the container that holds all your horizontal buttons
        val buttonListContainer = headerContainer?.findViewById<LinearLayout>(R.id.listbutton)  // Replace with the correct container ID

        // If the container is found, move the new breakfast button to the first position
        buttonListContainer?.let {
            // Remove the new breakfast button from its current position
            buttonListContainer.removeView(newIceCoffeeButton)

            // Add the new breakfast button to the first position (index 0)
            buttonListContainer.addView(newIceCoffeeButton, 0)

            // Optionally, you can update the background here too
            newIceCoffeeButton.setBackgroundResource(R.drawable.select_button)
        }
        val newShakeCoffeeButton = newHeader.findViewById<Button>(R.id.shake)
        val newHotDrinkeeButton = newHeader.findViewById<Button>(R.id.hot_drinks)
        val newCokeButton = newHeader.findViewById<Button>(R.id.coke)
        val newBrewingCoffeeButton = newHeader.findViewById<Button>(R.id.brewing_coffee)
        val newBreakfastButton = newHeader.findViewById<Button>(R.id.breakfast)

        newShakeCoffeeButton.setOnClickListener {
            shakeHeader()
        }
        newHotDrinkeeButton.setOnClickListener {
            hotdrinksHeader()
        }
        newCokeButton.setOnClickListener {
            cokeHeader()
        }
        newBrewingCoffeeButton.setOnClickListener {
            brewingcoffeeHeader()
        }
        newBreakfastButton.setOnClickListener {
            breakfastHeader()
        }

    }
    private fun hotdrinksHeader(){
        val hotDrinksFragment = HotDrinksFragment()
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.frame_layout, hotDrinksFragment)
            ?.commit()

        val headerContainer = activity?.findViewById<ViewGroup>(R.id.header)
        headerContainer?.removeAllViews() // Remove existing header views

        // Inflate and add the new header layout
        val newHeader = layoutInflater.inflate(R.layout.activity_header, headerContainer, false)
        headerContainer?.addView(newHeader)

        // Retrieve the newly inflated Shake button
        val newHotDrinksButton = newHeader.findViewById<Button>(R.id.hot_drinks)

        // Change the Shake button's background to select_button
        newHotDrinksButton.setBackgroundResource(R.drawable.select_button)

        // Now, get the container that holds all your horizontal buttons
        val buttonListContainer = headerContainer?.findViewById<LinearLayout>(R.id.listbutton)  // Replace with the correct container ID

        // If the container is found, move the new breakfast button to the first position
        buttonListContainer?.let {
            // Remove the new breakfast button from its current position
            buttonListContainer.removeView(newHotDrinksButton)

            // Add the new breakfast button to the first position (index 0)
            buttonListContainer.addView(newHotDrinksButton, 0)

            // Optionally, you can update the background here too
            newHotDrinksButton.setBackgroundResource(R.drawable.select_button)
        }
        val newIceCoffeeButton = newHeader.findViewById<Button>(R.id.iced_coffee)
        val newShakeCoffeeButton = newHeader.findViewById<Button>(R.id.shake)
        val newCokeButton = newHeader.findViewById<Button>(R.id.coke)
        val newBrewingCoffeeButton = newHeader.findViewById<Button>(R.id.brewing_coffee)
        val newBreakfastButton = newHeader.findViewById<Button>(R.id.breakfast)

        newIceCoffeeButton.setOnClickListener {
            icecoffeeHeader()
        }
        newShakeCoffeeButton.setOnClickListener {
            shakeHeader()
        }
        newCokeButton.setOnClickListener {
            cokeHeader()
        }
        newBrewingCoffeeButton.setOnClickListener {
            brewingcoffeeHeader()
        }
        newBreakfastButton.setOnClickListener {
            breakfastHeader()
        }
    }
    private fun cokeHeader(){
        val cokeFragment = CokeFragment()
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.frame_layout, cokeFragment)
            ?.commit()

        val headerContainer = activity?.findViewById<ViewGroup>(R.id.header)
        headerContainer?.removeAllViews() // Remove existing header views

        // Inflate and add the new header layout
        val newHeader = layoutInflater.inflate(R.layout.activity_header, headerContainer, false)
        headerContainer?.addView(newHeader)

        // Retrieve the newly inflated Shake button
        val newCokeButton = newHeader.findViewById<Button>(R.id.coke)

        // Change the Shake button's background to select_button
        newCokeButton.setBackgroundResource(R.drawable.select_button)

        // Now, get the container that holds all your horizontal buttons
        val buttonListContainer = headerContainer?.findViewById<LinearLayout>(R.id.listbutton)  // Replace with the correct container ID

        // If the container is found, move the new breakfast button to the first position
        buttonListContainer?.let {
            // Remove the new breakfast button from its current position
            buttonListContainer.removeView(newCokeButton)

            // Add the new breakfast button to the first position (index 0)
            buttonListContainer.addView(newCokeButton, 0)

            // Optionally, you can update the background here too
            newCokeButton.setBackgroundResource(R.drawable.select_button)
        }
        val newIceCoffeeButton = newHeader.findViewById<Button>(R.id.iced_coffee)
        val newShakeCoffeeButton = newHeader.findViewById<Button>(R.id.shake)
        val newHotDrinkeeButton = newHeader.findViewById<Button>(R.id.hot_drinks)
        val newBrewingCoffeeButton = newHeader.findViewById<Button>(R.id.brewing_coffee)
        val newBreakfastButton = newHeader.findViewById<Button>(R.id.breakfast)

        newIceCoffeeButton.setOnClickListener {
            icecoffeeHeader()
        }
        newShakeCoffeeButton.setOnClickListener {
            shakeHeader()
        }
        newHotDrinkeeButton.setOnClickListener {
            hotdrinksHeader()
        }
        newBrewingCoffeeButton.setOnClickListener {
            brewingcoffeeHeader()
        }
        newBreakfastButton.setOnClickListener {
            breakfastHeader()
        }
    }

    private fun brewingcoffeeHeader(){
        val brewingFragment = BrewingFragment()
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.frame_layout, brewingFragment)
            ?.commit()

        val headerContainer = activity?.findViewById<ViewGroup>(R.id.header)
        headerContainer?.removeAllViews() // Remove existing header views

        // Inflate and add the new header layout
        val newHeader = layoutInflater.inflate(R.layout.activity_header, headerContainer, false)
        headerContainer?.addView(newHeader)

        // Retrieve the newly inflated Shake button
        val newBrewingCoffeeButton = newHeader.findViewById<Button>(R.id.brewing_coffee)

        // Change the Shake button's background to select_button
        newBrewingCoffeeButton.setBackgroundResource(R.drawable.select_button)

        // Now, get the container that holds all your horizontal buttons
        val buttonListContainer = headerContainer?.findViewById<LinearLayout>(R.id.listbutton)  // Replace with the correct container ID

        // If the container is found, move the new breakfast button to the first position
        buttonListContainer?.let {
            // Remove the new breakfast button from its current position
            buttonListContainer.removeView(newBrewingCoffeeButton)

            // Add the new breakfast button to the first position (index 0)
            buttonListContainer.addView(newBrewingCoffeeButton, 0)

            // Optionally, you can update the background here too
            newBrewingCoffeeButton.setBackgroundResource(R.drawable.select_button)
        }
        val newIceCoffeeButton = newHeader.findViewById<Button>(R.id.iced_coffee)
        val newShakeCoffeeButton = newHeader.findViewById<Button>(R.id.shake)
        val newHotDrinkesButton = newHeader.findViewById<Button>(R.id.hot_drinks)
        val newCokeButton = newHeader.findViewById<Button>(R.id.coke)
        val newBreakfastButton = newHeader.findViewById<Button>(R.id.breakfast)

        newIceCoffeeButton.setOnClickListener {
            icecoffeeHeader()
        }
        newShakeCoffeeButton.setOnClickListener {
            shakeHeader()
        }
        newHotDrinkesButton.setOnClickListener {
            hotdrinksHeader()
        }
        newCokeButton.setOnClickListener {
            cokeHeader()
        }
        newBreakfastButton.setOnClickListener {
            breakfastHeader()
        }
    }

    private fun breakfastHeader() {
        val breakfastFragment = BreckfastFragment()
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.frame_layout, breakfastFragment)
            ?.addToBackStack(null) // Allow back navigation
            ?.commit()

        val headerContainer = activity?.findViewById<ViewGroup>(R.id.header)

        // Clear existing header views and add the new header
        headerContainer?.removeAllViews()
        val newHeader = layoutInflater.inflate(R.layout.activity_header, headerContainer, false)
        headerContainer?.addView(newHeader)

        // Retrieve the new breakfast button and set its background
        val newBreakfastButton = newHeader.findViewById<Button>(R.id.breakfast)
        newBreakfastButton.setBackgroundResource(R.drawable.select_button)

        // Find the button container
        val buttonListContainer = newHeader.findViewById<LinearLayout>(R.id.listbutton)
        buttonListContainer?.removeView(newBreakfastButton)
        buttonListContainer?.addView(newBreakfastButton, 0)

        // Set click listeners for other buttons
        val newIceCoffeeButton = newHeader.findViewById<Button>(R.id.iced_coffee)
        val newShakeCoffeeButton = newHeader.findViewById<Button>(R.id.shake)
        val newHotDrinkesButton = newHeader.findViewById<Button>(R.id.hot_drinks)
        val newCokeButton = newHeader.findViewById<Button>(R.id.coke)
        val newBrewingCoffeeButton = newHeader.findViewById<Button>(R.id.brewing_coffee)

        newIceCoffeeButton.setOnClickListener {
            icecoffeeHeader()
        }
        newShakeCoffeeButton.setOnClickListener {
            shakeHeader()
        }
        newHotDrinkesButton.setOnClickListener {
            hotdrinksHeader()
        }
        newCokeButton.setOnClickListener {
            cokeHeader()
        }
        newBrewingCoffeeButton.setOnClickListener {
            brewingcoffeeHeader()
        }
    }

   }