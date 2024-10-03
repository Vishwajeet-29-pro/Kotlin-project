package com.practice.examples.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

fun mainSupervisorScope() = runBlocking {
    supervisorScope {
        val child1 = launch {
            try {
                println("Child 1 starts")
                delay(1000L)
                println("Child 1 completes")
            } catch (e: Exception) {
                println("Child 1 failed: ${e.localizedMessage}")
            }
        }

        val child2 = launch {
            println("Child 2 starts")
            delay(500L)
            throw Exception("Child 2 exception")
        }
    }

    println("supervisor scope is over.")
}