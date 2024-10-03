package com.practice.examples.coroutines

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun mainExceptionHandling() = runBlocking {
    val handler = CoroutineExceptionHandler { _, exception ->
        println("Caught exception: ${exception.localizedMessage}")
    }

    val job = launch(handler) {
        throw Exception("Something went wrong")
    }

    job.join()
    println("Coroutine completed")
}

/*
* Explanation:
* - `CoroutineExceptionHandler : Catches uncaught exceptions in coroutines.
* */