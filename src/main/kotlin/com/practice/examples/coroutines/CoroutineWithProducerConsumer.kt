package com.practice.examples.coroutines

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun mainProducerConsumer() = runBlocking {
    val channel = Channel<String>()
    val producer = launch {
        val items = listOf("Apple", "Banana", "Orange")
        for (item in items) {
            channel.send(item)
            println("Sent: $item")
        }
        channel.close()
    }

    val consumer = launch {
        for (item in channel) {
            println("Received: $item")
        }
    }

    producer.join()
    consumer.join()
}