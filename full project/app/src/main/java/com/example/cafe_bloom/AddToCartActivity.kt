package com.example.cafe_bloom

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView

class AddToCartActivity : AppCompatActivity() {

    private lateinit var cartItemList: LinearLayout
    private lateinit var tvTotalPrice: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_cart)

        cartItemList = findViewById(R.id.cartItemList) // LinearLayout to display items
        tvTotalPrice = findViewById(R.id.tvSubtotal)

        displayCartItems()

        val buynow = findViewById<Button>(R.id.btnCheckout)

        buynow.setOnClickListener{
            val intent = Intent(this, confirmorder::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun displayCartItems() {
        cartItemList.removeAllViews()

        val cartItems = CartManager.getCartItems()
        var totalPrice = 0.0

        for (cartItem in cartItems) {
            val cartItemView = LayoutInflater.from(this).inflate(R.layout.cart_item_view, cartItemList, false)
            val tvProductName = cartItemView.findViewById<TextView>(R.id.tvProductName)
            val tvProductPrice = cartItemView.findViewById<TextView>(R.id.tvProductPrice)
            val btnDelete = cartItemView.findViewById<ImageButton>(R.id.btnDelete)

            tvProductName.text = "${cartItem.productName} x${cartItem.quantity}"
            tvProductPrice.text = "Rs. ${cartItem.productPrice * cartItem.quantity}"

            // Set up the delete button
            btnDelete.setOnClickListener {
                // Remove item from the cart
                CartManager.removeItem(cartItem)

                // Update the UI after deletion
                displayCartItems()
            }

            cartItemList.addView(cartItemView)
            totalPrice += cartItem.productPrice * cartItem.quantity
        }

        tvTotalPrice.text = "Total: Rs. $totalPrice"
    }
    fun goBack(view: View?) {
        finish()
    }
}
