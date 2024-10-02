package com.practice.examples.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

// Control which threads coroutines run on using dispatchers.

fun mainDispatcher() = runBlocking {
    launch(Dispatchers.Default) {
        println("Default Dispatcher: ${Thread.currentThread().name}")
    }
    launch(Dispatchers.IO) {
        println("IO Dispatcher: ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Unconfined) {
        println("Unconfined Dispatcher: ${Thread.currentThread().name}")
    }
    launch(newSingleThreadContext("MyThread")) {
        println("New Thread: ${Thread.currentThread().name}")
    }
}