package com.practice.examples.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

suspend fun doTask(taskName: String, time: Long) {
    delay(time)
    println("$taskName completed")
}

fun mainParallelDecomposition() = runBlocking {
    val tasks = listOf(
        async { doTask("Task 1", 1000L) },
        async { doTask("Task 2", 2000L) },
        async { doTask("Task 3", 1500L) }
    )
    tasks.awaitAll()
    println("All tasks completed.")
}

// async { ... }: Starts coroutines that can run in parallel.
// awaitAll(): Waits for all coroutines to complete.