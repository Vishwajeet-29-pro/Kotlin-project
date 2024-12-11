package com.practice.examples.features

fun main() {
    var a: String = "abc"
    // a = null // Null can not be a value of a non-null type String
    println(a)
    // to assign null value to string use ?
    // This expression makes String a type that can accept null:
    var b: String? = "abc"
    b = null
    println(b)
    // if we directly try access length property on it gives you this error
    // Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?
    // val length = b.length

    // to access the length of the b we need place the safe call (?.)
    val length = b?.length

    // check for null values with the if conditional
    // this way we're first checking the value of b if it is not null then we return length else returning -1
    // that's how we successfully avoid NPE
    val l = if (b != null) b.length else -1
    println(l)

    // In the example above, the compiler performs a smart cast to change the type from nullable String?
    // to non-nullable String. It also tracks the information about the check you performed and
    // allows the call to length inside the if conditional.

    // Assigns a nullable string to a variable
    val bb: String? = "Kotlin"

// Checks for nullability first and then accesses length
    if (bb != null && bb.length > 0) {
        print("String of length ${bb.length}")
        // Provides alternative if the condition is not met
    } else {
        println("Empty string")
        // String of length 6
    }
}