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


// Default method
// Interfaces in kotlin can have methods with default implementation. Classes that implements the interface can choose to
// override these methods or use the default ones.
interface VehicleInterface {
    fun drive() {
        println("Default method: Vehicle is driving")
    }

    fun stop() // abstract method
}

class VehicleInterfaceImpl: VehicleInterface {
    override fun stop() {
        println("Vehicle stopped!!")
    }
}

// Properties in Interface
// Kotlin interface can also contain properties. These properties can be abstract or have a default implementation. If the
// property is abstract, the class implementing the interface must provide the getter (and setter if it's mutable)
interface Person {
    val name: String
    val age: Int
        get() = 30
}

class Student(override val name: String) : Person


// Multiple Interfaces
// A class can implement multiple interfaces. If two interfaces have same methods with the same signature, the class must
// explicitly override methods and resolve any conflicts.
interface A {
    fun show() {
        println("A's Show")
    }
}

interface B {
    fun show() {
        println("B's Show")
    }
}

class C: A, B {
    override fun show() {
        super<A>.show()
        super<B>.show()
    }
}

// Kotlin support Functional Interfaces and SAM Conversions
// Kotlin support functional interfaces, which are interfaces with single abstract method(SAM - Single Abstract Method)
// These are useful lambda expressions. Kotlin automatically converts a lambda to an instance of Functional interface.
// The `fun` keyword is used to create a functional interface.
fun interface MyFunction {
    fun invoke(x: Int): Int
}

fun main() {
    val dog = DogClass()
    dog.sound()
    println("The number of legs are ${dog.numberOfLegs}")

    println("\nDefault methods")
    val vehicle = VehicleInterfaceImpl()
    vehicle.drive()
    vehicle.stop()

    println("\nProperties in interface")
    val student = Student("Vishwajeet")
    println(student.name)
    println(student.age)

    println("\nMultiple interface ")
    val c = C()
    c.show()

    println("\nFunctional Interface")
    // kotlin automatically converts the lambda to an instance of the interface.
    val square: MyFunction = MyFunction { it * it }
    val result = square.invoke(10)
    println("The square of number $result")
}

