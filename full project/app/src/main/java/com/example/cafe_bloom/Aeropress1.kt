package com.example.cafe_bloom

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class Aeropress1 : AppCompatActivity() {

    private var quantity = 1
    private var sizePrice = 1900
    private var toppingPrice = 0
    private var chocolatePrice = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.aeropress)

        val btnMinus = findViewById<Button>(R.id.btnMinus)
        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val tvQuantity = findViewById<TextView>(R.id.tvQuantity)
        val tvTotalPrice = findViewById<TextView>(R.id.tvTotalPrice)
        val tvSelectedItems = findViewById<TextView>(R.id.tvSelectedItems)

        val btnSmall = findViewById<Button>(R.id.btnSmall)
        val btnMedium = findViewById<Button>(R.id.btnMedium)
        val btnLarge = findViewById<Button>(R.id.btnLarge)

        val btnWhippedCream = findViewById<Button>(R.id.btnWhippedCream)
        val btnMarshmallows = findViewById<Button>(R.id.btnMarshMalllows)

        val btnDark = findViewById<Button>(R.id.btnDark)
        val btnMilk = findViewById<Button>(R.id.btnMilk)
        val btnWhite = findViewById<Button>(R.id.btnWhite)

        val btnAddToCart = findViewById<Button>(R.id.btnAddToCart)
        val buynow = findViewById<Button>(R.id.btnBuyNow)

        buynow.setOnClickListener{
            val intent = Intent(this, confirmorder::class.java)
            startActivity(intent)
            finish()
        }

        // Quantity logic
        btnMinus.setOnClickListener {
            if (quantity > 1) {
                quantity--
                tvQuantity.text = quantity.toString()
                updatePrice(tvTotalPrice)
                updateSelectedItems(tvSelectedItems)
            }
        }

        btnPlus.setOnClickListener {
            quantity++
            tvQuantity.text = quantity.toString()
            updatePrice(tvTotalPrice)
            updateSelectedItems(tvSelectedItems)
        }

        // Size selection logic
        btnSmall.setOnClickListener {
            selectSize(btnSmall, btnMedium, btnLarge, 1900, tvTotalPrice)
            updateSelectedItems(tvSelectedItems)
        }
        btnMedium.setOnClickListener {
            selectSize(btnMedium, btnSmall, btnLarge, 2000, tvTotalPrice)
            updateSelectedItems(tvSelectedItems)
        }
        btnLarge.setOnClickListener {
            selectSize(btnLarge, btnSmall, btnMedium, 2100, tvTotalPrice)
            updateSelectedItems(tvSelectedItems)
        }

        btnWhippedCream.setOnClickListener {
            selectTopping(btnWhippedCream, 50, tvTotalPrice)
            updateSelectedItems(tvSelectedItems)
        }
        btnMarshmallows.setOnClickListener {
            selectTopping(btnMarshmallows, 30, tvTotalPrice)
            updateSelectedItems(tvSelectedItems)
        }

        btnDark.setOnClickListener {
            selectChocolateType(btnDark, 100, tvTotalPrice)
            updateSelectedItems(tvSelectedItems)
        }
        btnMilk.setOnClickListener {
            selectChocolateType(btnMilk, 80, tvTotalPrice)
            updateSelectedItems(tvSelectedItems)
        }
        btnWhite.setOnClickListener {
            selectChocolateType(btnWhite, 120, tvTotalPrice)
            updateSelectedItems(tvSelectedItems)
        }
        btnAddToCart.setOnClickListener {
            val ProductName = findViewById<TextView>(R.id.tvTitle)
            val totalPrice = (sizePrice + toppingPrice + chocolatePrice) * quantity
            val cartItem = CartItem(
                productName = ProductName.text.toString(),
                productPrice = totalPrice.toDouble(),
                quantity = quantity
            )

            // Add the product to the cart
            CartManager.addItem(cartItem)

            // Optionally, show a message or update UI
            Toast.makeText(this, "Item added to cart!", Toast.LENGTH_SHORT).show()
            val go = Intent(applicationContext,AddToCartActivity::class.java)
            startActivity(go)
        }
    }

    fun goBack(view: View?) {
        finish()
    }
    private fun selectSize(selected: Button, unselected1: Button, unselected2: Button, price: Int, tvTotalPrice: TextView) {
        selected.isSelected = true
        unselected1.isSelected = false
        unselected2.isSelected = false

        sizePrice = price
        updatePrice(tvTotalPrice)
    }

    private fun selectTopping(selected: Button, price: Int, tvTotalPrice: TextView) {
        if (selected.isSelected) {
            selected.isSelected = false
            toppingPrice = 0
        } else {
            selected.isSelected = true
            toppingPrice = price
        }
        updatePrice(tvTotalPrice)
    }

    private fun selectChocolateType(selected: Button, price: Int, tvTotalPrice: TextView) {
        if (selected.isSelected) {
            selected.isSelected = false
            chocolatePrice = 0
        } else {
            selected.isSelected = true
            chocolatePrice = price
        }
        updatePrice(tvTotalPrice)
    }

    private fun updatePrice(tvTotalPrice: TextView) {
        val totalPrice = (sizePrice + toppingPrice + chocolatePrice) * quantity
        tvTotalPrice.text = "Rs. $totalPrice"
    }

    private fun updateSelectedItems(tvSelectedItems: TextView) {
        val selectedItems = StringBuilder()
        selectedItems.append("Quantity: $quantity\n")
        selectedItems.append("Size: ${if (sizePrice == 1900) "Small" else if (sizePrice == 2000) "Medium" else "Large"}\n")

        if (chocolatePrice > 0) {
            selectedItems.append("Type of Ice: ${if (chocolatePrice == 100) "Extra Ice" else if (chocolatePrice == 80) "Regular Ice" else "Light Ice"}\n")
        }

        if (toppingPrice > 0) {
            selectedItems.append("Topping: ${if (toppingPrice == 50) "Lemon Wedge" else "Mint Leaves"}\n")
        }

        tvSelectedItems.text = selectedItems.toString()
    }

}
