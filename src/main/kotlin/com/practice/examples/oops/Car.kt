package com.practice.examples.oops

// we can create class using the class keyword followed by name of the class
class Car {

    // these are some properties of the class. i.e. fields
    val name: String = "Fortuner"
    val brand: String = "Toyota"

    fun printDetails() {
        println("The name of Car $name and brand is $brand")
    }
}

fun main() {
    // to initiate object for the class, given syntax is used.
    // on that object we can access properties and functions of that class.
    val car = Car()
    car.brand
    car.printDetails()
}