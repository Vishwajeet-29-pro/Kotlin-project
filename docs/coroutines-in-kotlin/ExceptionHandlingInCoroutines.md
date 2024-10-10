# Handling Exception in Coroutine:

Handling exception in coroutines is essential for managing errors and ensuring that your coroutine-based code is robust. Kotlin provides mechanisms to handle exceptions in coroutines in a way that is 
quite similar to how we handle exceptions in regular code but also offers specific tools designed for coroutines.

1. **Exception Propagation:**
    Exception in coroutines can propagate like in regular code, but there are differences depending on how the coroutine is launched. The exception behavior depends on the 
    coroutine builder used (`launch`, `async`, etc.).
    
    With `launch`: 
    In a coroutine launched using `launch`, any uncaught exceptions are propagated to the `CoroutineScope` and are handled by its `CoroutineExceptionHandler` if one is provided.
    If no handler is present, the application may crash.

    ```kotlin 
        import kotlinx.coroutines.*

        fun main() = runBlocking {
            val job = launch {
                // This will throw an exception and cancel the coroutine
                throw Exception("Error in launch coroutine")
            }

            job.join() // Wait for the job to finish
            println("Coroutine has finished")
        }
    ```
    Output:
    ``` Exception in thread "main" java.lang.Exception: Error in launch coroutine ```
    In this case, the exception is thrown, and since no exception handler is specified, it causes the program to crash.

    With `async`
    For coroutines started with `async`, exception are deferred until the result is awaited. If you don't `await()` the result, the exception will not be thrown immediately.
    ```kotlin
        import kotlinx.coroutines.*

        fun main() = runBlocking {
            val deferred = async {
            // This will throw an exception, but it won't crash the program until we call await()
            throw Exception("Error in async coroutine")
        }

        try {
            deferred.await() // This is where the exception is thrown
        } catch (e: Exception) {
            println("Caught exception: ${e.message}")
        }
    }
    ```
    Output: ``` Caught exception: Error in async coroutine ```

    In async, the exception is propagated only when calling `await()`.

2. `try-catch` Block
    You can handle exceptions in coroutines using a `try-catch` block just like in regular code. It works inside coroutines and suspending functions as well.
    ```kotlin 
        import kotlinx.coroutines.*

        fun main() = runBlocking {
            val job = launch {
               try {
                  throw Exception("Something went wrong")
               } catch (e: Exception) {
                  println("Caught exception: ${e.message}")
               }
            }

            job.join() // Wait for the coroutine to finish
            println("Coroutine completed")
        }
    ```
    Output:
    ```
        Caught exception: Something went wrong
        Coroutine completed
    ```
    This ensures that the exception is caught within the coroutine, and it doesn't crash the program.

3. `CoroutineExceptionHandler`
    The `CoroutineExceptionHandler` is a special handler used for catching uncaught exception in coroutines launched using `launch`. It is installed on the `CoroutineScope` or `Job`.
    
    ```kotlin 
        import kotlinx.coroutines.*

        fun main() = runBlocking {
            // Create a handler to catch uncaught exceptions
            val handler = CoroutineExceptionHandler { _, exception ->
                println("Caught exception: ${exception.message}")
            }

            val job = launch(handler) {
                throw Exception("Uncaught exception in launch")
            }

            job.join() // Wait for the job to finish
            println("Coroutine finished")
        }
    ```
    Output:
    ```
        Caught exception: Uncaught exception in launch
        Coroutine finished
    ```
    In this case, the exception handler catches the exception, and the coroutine is able to finish without crashing the program.

4. Structured Concurrency and Cancellation:
    In Kotlin coroutines, cancellation and exception handling are tied together through structured concurrency. When a parent coroutine is cancelled or fails, all its children coroutines are also cancelled.
    Example: Propagating exceptions in parent-child coroutines
    ```kotlin
        import kotlinx.coroutines.*

        fun main() = runBlocking {
            val parentJob = launch {
            val childJob = launch {
                delay(1000L)
                println("Child coroutine finished")
            }

            delay(500L)
            throw Exception("Parent coroutine failed")
            }

            parentJob.join() // Wait for the parent to finish
            println("Parent coroutine completed")
        }
    ```
    Output: 
    ``` Exception in thread "main" java.lang.Exception: Parent coroutine failed ```
    Here, when the parent coroutine fails, the child coroutine is cancelled as well. No matter how long the child coroutine runs, if the parents fails, the whole scope will be cancelled.

5. SupervisorJob and SupervisorScope:
    By default, if a coroutine fails, its parent scope and all sibling coroutines are cancelled. However, with `SupervisiorJob`, the failure of one coroutine doesn't cancel the others. It allows you to isolate failures.
    ```kotlin
        import kotlinx.coroutines.*

        fun main() = runBlocking {
            val supervisor = SupervisorJob()

               with(CoroutineScope(supervisor)) {
                  val job1 = launch {
                  println("Job 1 starts")
                  throw Exception("Job 1 failed")
               }

               val job2 = launch {
                   println("Job 2 starts")
                   delay(1000L)
                   println("Job 2 finished")
               }

               // Wait for both coroutines
               joinAll(job1, job2)
            }
        }
    ```
    Output:
    ```
        Job 1 starts
        Job 2 starts
        Job 2 finished
        Exception in thread "main" java.lang.Exception: Job 1 failed
    ```
    Here, even though `Job 1` fails, `Job 2` is allowed to complete because of the `SupervisorJob`.

6. Catching Exception in `async` Coroutine
    When using `async`, you can catch exception when you `await()` the result.
    ```kotlin
        import kotlinx.coroutines.*

        fun main() = runBlocking {
            val deferred = async {
                 throw Exception("Error in async coroutine")
            }

             try {
                 deferred.await() // Exception will be thrown here
             } catch (e: Exception) {
                 println("Caught exception: ${e.message}")
             }
        }
    ```
   In this case, the exception is propagated when calling `await()`.

