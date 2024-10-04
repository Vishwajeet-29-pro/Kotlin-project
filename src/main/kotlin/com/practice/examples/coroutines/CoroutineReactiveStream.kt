package com.practice.examples.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun simpleFlow(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100L)
        emit(i)
    }
}

fun mainReactiveStream() = runBlocking {
    simpleFlow().collect { value ->
        println("Received $value")
    }
}