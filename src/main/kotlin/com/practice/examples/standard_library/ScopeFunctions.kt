package com.practice.examples.standard_library

class Person(var pName: String, var age: Int)

fun main() {
    val person = Person("Vishwajeet", 24)

    val updatedPerson = person.apply {
        pName = "Vishwajeet Kotkar"
        age = 25
    }.also {
        println("Updated person ${it.pName}")
    }.run {
        println("Performing further operations on $pName")
        this
    }
    println(updatedPerson)
}