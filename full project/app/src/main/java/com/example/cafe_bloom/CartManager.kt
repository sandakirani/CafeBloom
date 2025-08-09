package com.example.cafe_bloom

// Adjust the package name to your project structure

// Define the CartManager Singleton
object CartManager {

    // A Mutable list that holds cart items
    private val cartItems: MutableList<CartItem> = mutableListOf()

    // Function to add an item to the cart
    fun addItem(cartItem: CartItem) {
        cartItems.add(cartItem)
    }

    // Function to get all items in the cart
    fun getCartItems(): List<CartItem> {
        return cartItems
    }

    // Function to calculate the total price of all items in the cart
    fun getTotalPrice(): Double {
        var totalPrice = 0.0
        for (cartItem in cartItems) {
            totalPrice += cartItem.productPrice * cartItem.quantity
        }
        return totalPrice
    }

    // Function to remove an item from the cart
    fun removeItem(cartItem: CartItem) {
        cartItems.remove(cartItem)
    }

    // Function to clear all items in the cart
    fun clearCart() {
        cartItems.clear()
    }
}
