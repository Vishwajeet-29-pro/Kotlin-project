package com.practice.examples.coroutines

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun mainChannel() = runBlocking {
    val channel = Channel<Int>()
    val sender = launch {
        for (x in 1..5) {
            channel.send(x * x)
            println("Sent: ${x * x}")
        }
        channel.close()
    }

    val receiver = launch {
        for (y in channel) {
            println("Received: $y")
        }
    }

    sender.join()
    receiver.join()
}

// Channel: A way to communicate between coroutines.