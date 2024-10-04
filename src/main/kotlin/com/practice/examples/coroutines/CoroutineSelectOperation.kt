package com.practice.examples.coroutines

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.select

fun mainSelectOperation() = runBlocking {
    val channel1 = Channel<String>()
    val channel2 = Channel<String>()

    launch {
        delay(100L)
        channel1.send("From channel 1")
    }

    launch {
        delay(200L)
        channel2.send("From channel 2")
    }

    val result = select<String> {
        channel1.onReceive { it }
        channel2.onReceive { it }
    }

    println("Received $result")
}