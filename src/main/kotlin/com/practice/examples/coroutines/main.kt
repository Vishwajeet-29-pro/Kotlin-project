package com.practice.examples.coroutines

// common method to call other thread method.
fun main() {

//    mainLaunchSimple() // launch simple method
//    println()
//    mainCoroutine() // coroutine example
//    println()
//    mainDispatcher() // Dispatcher and Threading example

    println("Using withContext for Context Switching...")
    mainWithContext() // for context Switching
}