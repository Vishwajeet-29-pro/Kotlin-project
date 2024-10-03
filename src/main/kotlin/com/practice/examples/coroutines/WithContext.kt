package com.practice.examples.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

// Switch between dispatchers within a coroutine

suspend fun computeData(): Int = withContext(Dispatchers.Default) {
    var sum = 0
    for (i in 1..1_000_000){
        sum +=i
    }
    sum
}

fun mainWithContext() = runBlocking {
    println("Starting computation....")
    val result = computeData()
    println("Result: $result")
}