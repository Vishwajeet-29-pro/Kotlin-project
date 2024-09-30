# Basics of Coroutines
Kotlin's coroutines are a way of writing asynchronous and non-blocking code in a simple and readable manner. Coroutines allow you to run tasks concurrently, making it easy to perform tasks like network calls or I/O operations without blocking the main thread.

**Key Concepts:**
   1. **Suspend Functions:** Functions that can be paused and resumed later.
   2. **Coroutine Scope:** The scope in which coroutines run, which helps in controlling their lifecycle.
   3. **Coroutine Context:** Defines the environment of the coroutine, including the dispatcher.
   4. **Dispatcher:** Controls which thread are coroutine run on (eg. Main, ID, Default).
   5. **Job:** Represents a cancellable unit of work with lifecycle control.


1. **What is a Coroutine?**
   A coroutine is a concurrency design pattern that you can use on Android to simplify code execute asynchronously. They are based on lightweight threads and provide a way to write asynchronous code sequentially.
    - **Lightweight:** Coroutines are much lighter than threads. You can create thousands of coroutines without impacting performance.
    - **Non-blocking:** Coroutines allow you to perform long-running tasks without blocking the main thread, making them ideal for tasks like network calls or file I/O.

2.  **Suspend Function:** A Suspend function is a function that can be paused and resumed later. It allows you to perform long-running operations like network requests without blocking the thread.
```
   suspend fun fetchData(): String {
	   // Simulate a long-running operation
	   delay(1000) // Delay for 1 second without blocking the thread.
	   return "Data fetched"
   }
```
   - `delay(1000)`: A suspend function that pauses the coroutine for 1 second.
   - The function can only be called from a coroutine or another suspend function.

3. **Coroutine Builders:**
   There are three main coroutines builders used to launch coroutines:
    - **launch**: Launches a new coroutine that runs concurrently with the rest of the code. It is fire-and-forget, meaning it doesn't return any result.
    - **async**: Launches a new coroutine and returns a Deferred, which is a future-like object that can return a result later.
    - **runBlocking:** Used to bridge regular blocking code with coroutine-based code. It blocks the thread while waiting for the coroutine to complete.
    - Example:
```
import kotlinx.coroutines.*

fun main() = runBlocking {
	launch {
		delay(1000L)
		println("Task from launch")
	}
	println("Task from runBlocking.")
}
```
- launch create a new coroutine, but the rest of the code continues to run.
- runBlocking: blocks the main thread until all coroutines inside it complete.

4. **Coroutine Dispatchers:**
   Coroutines can run on different threads using Dispatchers:
    - `Dispatchers.Main:` For UI-related tasks (Android specific).
    - `Dispatchers.IO`: For I/O operations like reading from files or network calls.
    - `Dispatchers.Default:` For CPU-intensive tasks like sorting large data.
    - `Dispatchers.Unconfined:` Starts in the caller thread, but can resume in a different thread.
      Example of Dispatchers:
```
import kotlinx.coroutines.*

fun main() = runBlocking {
	launch(Dispatchers.IO) {
		// Simulate a long I/O opertion
		println("Running on IO dispatcher")
		delay(1000L)
	}
	launch(Dispatchers.Default) {
		println("Running on Default dispatcher")
	}
}
```

5. **Coroutine Scope:**
   A coroutine scope defines the lifecycle of the coroutines. You can cancel all coroutines that run within the scope when the scope is canceled.
    - **GlobalScope:** Launches coroutines that run for the entire lifetime of the application.
    - **CoroutineScope:** A custom scope tied to a lifecycle like an Activity in Andorid.
      Example:
```
   import kotlinx.coroutines.*
   
   fun main() = runBlocking {
	   val scope = CoroutineScope(Dispatchers.Default)
	   
	   scope.launch {
		   delay(500L)
		   println("Coroutine inside custom scope.")
	   }
	   
	   println("Scope ends")
	}

```

6. **Job:** A job is a handle to control the coroutines's lifecycle, like canceling it or checking its completion.
  ```
import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        delay(1000L)
        println("Job is running")
    }

    println("Job is active: ${job.isActive}")
    job.join()  // Wait for the job to complete
    println("Job is completed: ${job.isCompleted}")
}
```
7. **Exception Handling in Coroutines:**
   Coroutines have their own mechanism for handling exception.
    - try-catch: Used for handling exceptions in a coroutine.
    - CoroutineExceptionHandler: Used to handle uncaught exception in structured concurrency.
      Example:
  ```
   import kotlinx.coroutines.*

fun main() = runBlocking {
    val handler = CoroutineExceptionHandler { _, exception ->
        println("Caught exception: $exception")
    }

    val job = GlobalScope.launch(handler) {
        throw ArithmeticException("Crash")
    }
    job.join()  // Wait for job to complete
}

```

8. **Structured Concurrency:**
   Structured concurrency ensures that all coroutines are completed when a scope ends. If you use launch inside a CoroutineScope. all child corotines are automatically canceled when the parent scope is canceled.
```
import kotlinx.coroutines.*

fun main() = runBlocking {
    val parentJob = launch {
        launch {
            delay(500L)
            println("Child coroutine")
        }
        println("Parent coroutine")
    }
    parentJob.join()
    println("End of parent job")
}

```

### Summary:

- **Coroutines**: Lightweight, non-blocking concurrency primitives.
- **Suspend functions**: Allow long-running tasks to be paused and resumed.
- **Coroutine builders**: `launch`, `async`, and `runBlocking` help in creating coroutines.
- **Dispatchers**: Control which thread a coroutine runs on (`Main`, `IO`, `Default`).
- **Scopes**: Control the lifecycle of coroutines (`GlobalScope`, `CoroutineScope`).
- **Jobs**: Used to manage coroutines (cancel, join, check status).
- **Structured concurrency** ensures all coroutines complete before the scope ends.