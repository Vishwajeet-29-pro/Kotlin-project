package com.practice.examples.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

// Use async to run coroutines in parallel and await to get their results.

suspend fun fetchFirstValue(): Int {
    delay(1000L)
    return 10
}

suspend fun fetchSecondValue(): Int {
    delay(1000L)
    return 20
}

fun mainCoroutine() = runBlocking {
    val time = measureTimeMillis {
        val first = async { fetchFirstValue() }
        val second = async { fetchSecondValue() }
        val result = first.await() + second.await()
        println("Result: $result")
    }
    println("Completed in $time ms")
}

/*
* async { ... }: Starts a coroutine that returns a result (Deferred)
* await(): Waits for the result of the Deferred coroutine.
* measureTimeMillis { ... }: Measures the execution time of the block.
*
* Both coroutines run in parallel, so the total time is approximately 1 second.
* */