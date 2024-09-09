package com.practice.examples.oops

class InitBlockExample(val property: String, val value: Int) {
    // If you need to run some code during object initialization, you can use the init block.
    // this block executes when object gets created.
    init {
        println("The property of class is $property and value for class is $value")
    }
}

fun main() {
    val initBlockExample = InitBlockExample("Init", 1)
}