package com.practice.examples.oops

// overriding methods
//In Kotlin, you can override methods from the parent class in the child class. To do this, you must mark the method in
// the parent class with the open keyword, and in the child class, you use the override keyword.

open class Animal {
    open fun sound() {
        println("Animal making sound")
    }
}

class Dog: Animal() {
    override fun sound() {
        println("Dog barks")
    }
}

// overriding properties
// Similar to methods, you can override properties in the child class. Both the property in the parent class and the
// overriding property in the child class must be marked with the open and override keywords, respectively.
open class Shape {
    open val name: String = "Shape"
}

class Circle: Shape() {
    override val name: String = "Circle"
}

// Calling Superclass Methods
// You can call the methods or properties of the parent class from the child class using the super keyword. This is
// helpful when you want to extend or modify the behavior of a method rather than completely replacing it.
class Cat: Animal() {
    override fun sound() {
        super.sound()
        println("Cat meows")
    }
}

fun main() {
    val animal = Dog()
    animal.sound()

    val shape = Circle()
    println(shape.name)

    val cat = Cat()
    cat.sound()
}