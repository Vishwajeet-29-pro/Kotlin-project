# Launching Coroutines in Kotlin `launch` vs `async`:
Kotlin provides two primary ways to launch coroutines: `launch` and `async`. Both of these functions helps you create coroutines, 
but they serve different purposes depending on whether you need a result or not.

1. `launch`: Fire-and-Forgot Coroutine
    - **Purpose**: The `launch` function is used when you want to start a coroutine that performs some work, but you don't need any result from it.
    It is a fire-and-forgot operation, meaning that it doesn't return anything to the caller.
    - **Return Type:** `Job`
      - A Job is a handle to manage the lifecycle of the coroutine. You can use the Job to cancel the coroutine or check if it has completed.
    - **Common Use Case:** `launch` is often used for coroutines that update the UI, perform side effects, or background work that doesn't need to return any result.
    
    Example of Launch:
   ```kotlin
    
    fun main() = runBlocking {
        val job: Job = launch {
            delay(1000L)
            println("Task from coroutines")    
        }    
        println("Task from main thread")
        job.join() // wait for coroutine to finish
        println("Coroutine has completed")
    } 
   ```
   - Explanation:
     - The `launch` block starts a coroutine that delays for 1 second and then prints a message.
     - The `join()` method waits for the coroutine to finish before proceeding.
   - Key Points:
     - `launch` starts a coroutine but doesn't return a result.
     - It returns a Job which can be used to track or cancel the coroutine.

2. `async`: **Coroutine with a Deferred Result**
    - **Purpose:** The `async` function is used when you want to start a coroutine that will return a result asynchronously. It is useful when you need to 
        compute something and return a result later.
    - **Return Type:** `Deferred<T>`
      - A `Deferred<T>` is a future-like object that represents a promise for a result that will be available later. You can call `await()` on the Deferred to get the result.
    - **Common Use Case:** Use `async` when you need to compute a result asynchronously and later retrieve it.
    
    Example of async:
   ```kotlin
        fun main() = runBlocking {
            val deferred: Deferred<Int> = async {
                delay(1000L)
                println("Task from coroutine")
                42
            }    
            println("Task from main thread")
            val result = deferred.await()
            println("Result from coroutine: $result")
        }    
    ```
   
    - **Explanation:**
      - The async block starts a coroutine that delay for 1 second, prints a message, and returns the result 42.
      - `await()` is used to wait for the coroutine's result.
    - **Key Points:**
      - `async` is used when you need a result.
      - It returns a `Deferred<T>`, and `await()` is called to get the result when it's ready.

### Differences Between `launch` and `async`

| Feature            | `launch`                      | `async`                              |
|--------------------|-------------------------------|--------------------------------------|
| Return Type        | `Job`                         | `Deferred<T>`                        |
| Result Handling    | Doesn't return a result       | Return a result using `await()`      |
| Use Case           | Fire-and-forgot tasks         | Tasks that need to return a value    |
| Exception Handling | Exception will cancel the Job | Exception will cancel the `Deferred` |

### Example: Using Both `launch` and `async` Together
You can use both `launch` and `async` in a single program depending on your needs:

```kotlin
    fun main() = runBlocking {
        val job = launch {
            println("Starting background task")
            delay(1000L)
            println("Background task completed")
        }
    
        val deferred = async {
            println("Start async task")
            delay(2000L)
            "Async result"
        }
    
        println("Waiting for background task to finish...")
        job.join() // wait for the launch task to complete.
    
        println("Waiting for async result...")
        val result = deferred.await()
        println("Received async result: $result")
}
```
- **Explanation:**
  - The `launch` coroutine is used for a background task that doesn't return anything, and we use `join()` to wait for its completion.
  - The `async` coroutine computes a result, and we use `await()` to retrieve the result once the computation is done.

### When to Use `launch` vs `async`
- Use `launch` when you just want to run some work in the background and don't need a result.
- Use `async` when you need to perform a calculation or return a result from a coroutine.

### Concurrency with `async` and `launch`:
When you use `async` to launch multiple coroutines, they run concurrently, and you can wait for their results independently.

```
    fun main() = runBlocking {
        val deferred1 = async { calculate(10) }
        val deferred2 = async { calculate(20) }
    
        val result1 = deferred1.await()
        val result2 = deferred2.await()
    
        println("Results: $result1, $result2")
 }
    suspend fun calculate(num: Int): Int {
        delay(1000L)
        return num * num
    }
```
 - Explanation:
   - Two `async` coroutines are launched to compute results concurrently.
   - Both results are awaited and printed together after the computations are done.

### Summary:

* launch: Fire-and-forget coroutine, returns Job, no result is expected.
* async: Coroutine that returns a result asynchronously, returns Deferred<T>, result is retrieved via await().
* These two coroutine builders (launch and async) form the foundation of coroutine-based concurrency in Kotlin. They allow you to write concurrent programs in a simple and expressive way.