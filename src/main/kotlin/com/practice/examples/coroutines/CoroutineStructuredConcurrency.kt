package com.practice.examples.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun doWork() = coroutineScope {
    launch {
        delay(1000L)
        println("work 1 completed")
    }
    launch {
        delay(1000L)
        println("Work 2 completed")
    }
    println("Coroutine scope is over")
}

fun mainCoroutineScope() = runBlocking {
    doWork()
    println("Main Function completed.")
}

// coroutineScope { ... } : Suspends until all child coroutines complete.