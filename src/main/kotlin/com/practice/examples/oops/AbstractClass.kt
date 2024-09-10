package com.practice.examples.oops

// Abstract class
// Kotlin supports abstract classes, which cannot be instantiated directly and can contain both abstract (unimplemented)
// and non-abstract methods. Abstract classes are useful when you want to provide a common base class for other classes
// but ensure that they implement certain methods.

abstract class AbstractAnimal(val food: String) {
    abstract fun sound()
    open fun eat() {
        println("Animal eating $food")
    }
}

class Cow(food: String): AbstractAnimal(food) {
    override fun eat() {
        super.eat()
        println("Cow drinks water")
    }
    override fun sound() {
        println("Cow making sound")
    }
}


fun main() {
    val cow = Cow("Grass")
    cow.sound()
    cow.eat()
}