package com.practice.examples.oops


// All classes in Kotlin have common superclass is `Any`, which is default superclass for class with no default
// supertypes declared
// Any has three methods equals(), hashCode(), and toString(). These methods are defined for all the Kotlin classes.
// By default, Kotlin classes are final - They can't be inherited. To make them inheritable, mark it with open keyword.

//In Kotlin, a class can inherit from another class using the : symbol. The class that is being inherited from is called
// the superclass (or parent class), and the class that is inheriting is called the subclass (or child class).
open class Base(p: Int) // this class will inherit.

// to declare an explicit supertype, place a type after colons in the class header:

class Derived(p: Int): Base(p)

// if the derived class has primary constructor, then the base class can be (must be) initialized in that primary
// constructor according to its parameter
//If the derived class has no primary constructor, then each secondary constructor has to initialize the base type
// using the super keyword, or it has to delegate to another constructor which does. Note that in this case different
// secondary constructors can call different constructors of the base type:

//class MyView: View {
//    constructor(ctx: Context) : super(ctx)
//    constructor(ctx: Context, attributeSet: AttributeSet) : super(ctx, attributeSet)
//}

// example:
open class Vehicle(val brand: String) {
    fun drive() {
        println("$brand is driving...")
    }
}

class CarType(brand: String, val model: String): Vehicle(brand) {
    fun details() {
        println("Brand: $brand, Model: $model")
    }
}

fun main() {
    val myCar = CarType("Toyota","Innova")
    myCar.details()
    myCar.drive()
}

