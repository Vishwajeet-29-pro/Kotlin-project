package com.practice.examples.functional_programming

fun createShoppingCart(): (String) -> List<String> {
    val cart = mutableListOf<String>()

    return { item ->
        cart.add(item)
        cart
    }
}

fun main() {
    val cart = createShoppingCart()

    println(cart("Apple"))
    println(cart("Banana"))
    println(cart("Orange"))
}