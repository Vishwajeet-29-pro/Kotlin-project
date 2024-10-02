package com.practice.examples.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        delay(1000)
        println("World!")
    }
    println("Hello,")
}

/*
* `runBlocking { ... }`: Starts a new coroutine and blocks the current thread until its completion.
* `lunch { ... }`: Launches a new coroutine without blocking the current thread.
* `delay(1000L): Suspends the coroutine for 1 second without blocking the thread.
*
*
* Output:
* Hello,
* World!
* */