package com.practice.examples.oops

class SecondaryConstructor(val brand: String) {
    var year: Int = 2000

    // to create secondary constructor we need this constructor keyword
    // to pass the primary constructor value in the constructor we again use following syntax
    constructor(brand: String, year: Int): this(brand) {
        this.year = year
    }

    fun printInfo() {
        // this will take the primary constructor values
        println("This the ${brand}'s Car with model year $year")
    }
}

fun main() {
    // this is  primary constructor example and which takes the value for year default one.
    val s = SecondaryConstructor("toyota")
    println(s.brand)
    s.printInfo()

    // here we are creating an object with new values.
    val ss = SecondaryConstructor("Toyota",2022)
    println("Brand is ${ss.brand} and year is: ${ss.year}")
    s.printInfo()
}