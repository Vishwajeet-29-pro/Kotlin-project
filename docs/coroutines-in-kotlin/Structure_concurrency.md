# Structured Concurrency in Kotlin
Structured concurrency is design principle in kotlin coroutines that ensures proper lifecycle management of coroutines. It helps in managing the scope of
coroutines so that they are tied to a specific lifecycle, and ensures that all launched coroutines finish properly before moving forward.
This way, we avoid leaks, unexpected behavior, or dangling coroutines.

## Why Structured Concurrency?
Without structured concurrency, it becomes difficult to track and control coroutines, leading to issues such as:
    - Memory leaks: Coroutines continue running even after the scope they belong to has ended.
    - Unintended behavior: Coroutines might produce result after their context is no longer valid.

Structured Concurrency helps ensure:
1. Lifecycle Boundaries: Coroutines are tied to a specific scope, like CoroutineScope, and are automatically canceled when the scope ends.
2. Parent-Child Relationship: A parent coroutines waits for all its child coroutines to finish before it completes.
3. Exception Propagation: Exceptions in child coroutines automatically propagate to parent coroutines, which helps in proper error handling.

## Key Concept
1. `CoroutineScope`:
   - A `CoroutineScope` defines the lifecycle of coroutines launched within it. 
   - When a scope is canceled, all its child coroutines are automatically canceled. 
   - Common scopes are GlobalScope, MainScope, or custom scopes created using `coroutineScope()`.

2. Job Hierarchy:
   - Parent coroutines launch child coroutines using launch or async. These coroutines are associated with the parent, and the parent coroutines will wait
     fo all its children to complete before finishing.

3. Cancellation:
    - If the parent coroutine is canceled, all its child coroutines are automatically canceled as well.
    - This ensures that no coroutines outlives its intended scope.

Example of Structured Concurrency:
```kotlin
import kotlinx.coroutines.*

fun main() = runBlocking {
    // This is the parent coroutine scope
    println("Main program starts: ${Thread.currentThread().name}")

    // Launch a coroutine inside runBlocking scope (which will act as parent scope)
    val job = launch {
        println("Fake work starts: ${Thread.currentThread().name}")
        delay(1000) // Simulate long-running work
        println("Fake work finished: ${Thread.currentThread().name}")
    }

    // The parent coroutine will wait for the job to finish
    job.join()
    println("Main program ends: ${Thread.currentThread().name}")
}
```
In this example, runBlocking acts as the parent scope. The launch coroutine is tied to this scope, and runBlocking will not complete until the launch coroutine finishes its execution.

### Propagation of Exception:
In structured concurrency, if an exception occurs in a child coroutines, it is propagated to the parent coroutine and handled. The parent coroutines will fail if any of its children fail, ensuring that exception are not ignored.
```kotlin
import kotlinx.coroutines.*

fun main() = runBlocking {
    try {
        launch {
            println("Child coroutine starts")
            throw Exception("An error occurred")
        }
    } catch (e: Exception) {
        println("Caught exception: ${e.message}")
    }

    println("Parent coroutine continues")
}
```

### Benefits of Structured Concurrency:
1. Preventing Memory Leaks: Child coroutines are always tied to a parent, and are automatically cleaned up when the parent completes.
2. Exception Safety: Exceptions in coroutines are automatically propagated, ensuring proper handling.
3. Better Readability: The lifecycle of coroutines is tied to the scope, making the code more predictable and manageable.





