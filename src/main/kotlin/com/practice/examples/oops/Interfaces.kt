package com.practice.examples.oops

// In Kotlin, an interface is similar to a class but can contain only abstract method declarations (without body) or
// default method implementations. Interfaces define a contract that classes can implement, allowing for multiple
// inheritance of behavior.

// 1. Defining an Interface:
// An interface in Kotlin is declared using the interface keyword. Interfaces can contain abstract properties and
// methods, as well as concrete (non-abstract) methods with default implementations.

// Abstract members: Members of an interface are abstract by default, so you don't need to mark them with abstract.
// Concrete members: You can also provide default implementations for methods inside the interface.

// Classes implement interfaces using the : symbol (similar to inheritance from a class). A class that implements an
// interface must provide implementations for all the abstract methods of that interface unless the class is abstract.

interface MyInterface {
    fun sound()
    val numberOfLegs: Int
}

class DogClass: MyInterface {
    override fun sound() {
        println("Dog is barking...")
    }

    override val numberOfLegs: Int = 4
}

fun main() {
    val dog = DogClass()
    dog.sound()
    println("The number of legs are ${dog.numberOfLegs}")
}

