package com.practice.examples.function

fun main() {

    println(add(10,20))
    println(sum(10, 20))
}

// to make your code more concise we can use the single expression function.
// here is this function can be converted to single expression by simple means.
fun add(i: Int, j: Int): Int {
    return i + j
}

// We can remove the curly braces {} and declare the function body using the assignment
// operator =. When you use the assignment operator =, Kotlin uses type inference, so you can
// also omit the return type. The add() function then becomes one line:
// for conflict change name of the function.
fun sum(i: Int, j: Int) = i + j

// Early returns in functions
// to stop the code in your function being processed further than a certain point, use the return
// keyword. This example uses if to return from a function earl if the conditional expression is found to be true.
// A list of registered usernames
val registeredUsername = mutableListOf("john_doe", "john_smith","john_snow")
// A list of registered emails
val registeredEmails = mutableListOf("johndoe@example.com", "johnsmith@example.com","johnsnow@example.com")

fun registerUser(username: String, email: String): String {
    // Early return if the username is already taken
    if (username in registeredUsername) {
        return "Username already taken, Please choose a different one."
    }
    // Early return if the email is already registered
    if (email in registeredEmails) {
        return "Email already registered. Please use a different the email."
    }
    // proceed with the registration if the username and email are not taken
    registeredEmails.add(username)
    registeredEmails.add(email)

    return "User registered successfully: $username"
}