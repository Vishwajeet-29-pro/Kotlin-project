package com.practice.examples.oops

// In kotlin we can create constructor right after class-name using open close parenthesis
// and we can use these values inside the class for various operations
class PrimaryConstructor(val id: Int, val name: String, val isOpen: Boolean) {
    fun printDetails(){
        println("The id is $id and name is $name and isOpen: ${if(isOpen) "Yes" else "No"}")
    }
}

fun main() {
    // to create object of that class we invoked the constructor and pass the required values from constructor
    val p = PrimaryConstructor(101, "Showroom", true)
    p.printDetails()

    val p2 = PrimaryConstructor(102, "Home",false)
    p2.printDetails()
}