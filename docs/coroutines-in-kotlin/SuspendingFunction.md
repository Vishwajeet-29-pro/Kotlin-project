# Suspending Function
In Kotlin, a suspending function is a function that can be paused and resumed later without blocking the thread's  running on. Suspending functions are the backbone of Kotlin's coroutine system,
allowing for writing asynchronous code in a sequential style. The `suspend` keyword is used to define such functions, and they can only be called from within a coroutine or another suspending function.

## Key Concepts of Suspending Functions:
1. **Non-blocking:** Unlike traditional threads, suspending functions don't block the thread they're running on. Instead, they suspend execution and can later resume without occupying the 
    thread, making them more resource-efficient.
2. **Sequential Code:** Even though suspending functions run asynchronously, they allow you to write code in a sequential manner, which is easier to read and maintain compared to callback based code.
3. **`suspend` Keyword:** This is used to declare a suspending function. It tells the kotlin compiler that the function might suspend execution and resume later.
4. **Coroutine Context:** Suspending functions are designed to work with coroutines. They should be called either from within a coroutine or another suspending function.

**Syntax of a Suspending Function:**
    
```kotlin

suspend fun mySuspendingFunction() {
    delay(1000L)
    println("This will print after 1 second")
}
```
In the above example, `mySuspendingFunction` is a suspending function that simulates a delay (pausing) using the `delay()` function, which is itself a suspending function. The thread running 
this code will not be blocked during the delay.

### How to Call a Suspending Function
A suspending function must be called from a coroutine or another suspending function.
Example:
```kotlin
    fun main() = runBlocking {
        // Call the suspending function from within a coroutine
        mySuspendingFunction()
        println("After calling the suspending function")
    }

suspend fun mySuspendingFunction() {
    delay(1000L)
    println("This is executed after 1 second delay")
}
```
Here:
- `runBlocking { }` starts a new coroutine in the main thread.
- `mySuspendingFunction()` is called from within the coroutine.
- The program suspends for 1 second during the `delay(1000L)` call, but without blocking the thread.

### Benefits of Suspending Functions:
1. Non-blocking asynchronous code: Suspending functions allow you to run asynchronous code without blocking the main thread (or any other thread). This is especially useful for tasks like network calls, file I/O, or heavy computations.
2. Sequential flow: You can write asynchronous code in a sequential and more readable manner without needing callbacks or complex thread management.
3. Resource Efficiency: Since suspending functions don't block threads, they are more efficient in terms of resource usage compared to traditional thread-based concurrency.

### Use Cases:
**Network requests:** Making API calls without blocking the UI thread.
**Database operations:** Querying or updating a database asynchronously.
**Heavy computations:** Running long-running tasks without freezing the application.


