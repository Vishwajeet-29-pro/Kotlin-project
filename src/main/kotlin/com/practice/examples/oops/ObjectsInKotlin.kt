package com.practice.examples.oops

// types of objects in kotlin are:
// 1. Instance of class
// 2. Singleton object
// 3. companion object

// type 1: Instance of class
class SimpleObject(val type: String) {
    init {
        println("The type of object is '$type'")
    }
}

// type 2: Singleton object (using object keyword)
// kotlin provide a way to declare a singleton object using object keyword. This object is initiated once
// and can be accessed globally.
object DatabaseSingleton {
    val url: String = "localhost"
    val host: Int = 8080

    fun connect() {
        println("The database connected at $url:$host")
    }
}

// type: 3 Companion Object (static-like behaviour)
// A companion object is used to define members of a class that are shared across all instances
// (like static methods in Java).
class CarClass(val model: String, val make: Int) {
    companion object {
        fun carInfo() = "This is a car class."
    }
}

fun main() {
    val simpleObject = SimpleObject("Instance of class")
    DatabaseSingleton.connect()
    println(CarClass.carInfo())
}