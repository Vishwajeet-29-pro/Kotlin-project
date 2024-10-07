# Scopes in Kotlin

1. **GlobalScope**
   - GlobalScope is the top-level scope in Kotlin, meaning coroutines launched here are tied to the application's lifecycle.
   - They live until the entire application is running. This can lead to memory leaks if not managed properly.
   - GlobalScope is used for launching coroutines that need to run for the entire lifetime of the application and should be avoided for most tasks as it's easy to lose track of them.

    **Example:**
    ```Kotlin
        fun main() {
            delay(1000L)
            println("Hello from GlobalScope!")
        }    
        // Keeps JVM alive for the coroutine to finish
        Thread.sleep(2000L)
    ```
   Here, the `GlobalScope.launch` starts a coroutine that prints after 1 second. Since coroutines in GlobalScope are not tied to any specific job or lifecycle, the main thread waits using `Thread.sleep` to
    keep the program alive long enough for the coroutine to finish.

2. **CoroutineScope:**
    - CoroutineScope allows for better control over coroutines by managing their lifecycle. It lets you cancel all coroutines started within a particular scope if the scope itself gets canceled.
    - Coroutines within aa `CoroutineScope` are tied to a lifecycle (such as the lifecycle of an Activity in Android) or a task in your application.
    - You can define your own `CoroutineScope` using different types of `CoroutineContext` such as `Disatchers.Main`, `Dispatcher.ID`, etc.
    
    **Example:**
    ```Kotlin
        fun main() = runBlocking {
            val scope = CoroutineScope(Dispatachers.Default)
            Scope.launch {
                delay(1000L)
                println("Hello CoroutineScope!")    
            }    
            // This will keep the scope alive long enough for the coroutine to finish.
            delay(2000L)
        }
    ```
    Here, a custom `CoroutineScope` is created. The coroutine inside the scope uses `Dispatchers.Default`, meaning it runs on a background thread. The `runBlocking` keeps the program alive until the coroutine finishes.

   ### Key Differences:
   1. GlobalScope:
       - Coroutines live as long as the application runs.
       - Used rarely because it's difficult to control the lifecycle, especially in mobile or server applications.
   2. CoroutineScope:
      - You can define when the coroutines within the scope should cancel.
      - Better for lifecycle management, especially in structured concurrency (e.g. Android apps or background tasks in servers).
   
   ### Common Use Case for CoroutineScope:
    In android, for instance, you might tie a coroutine scope to an activity or a ViewModel, so that all coroutines are canceled when the activity or ViewModel is destroyed.

    ```kotlin
    
    class MyActivity : AppCompatActivity() {
       private val activityScope = CoroutineScope(Dispatchers.Main)

       override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)

          activityScope.launch {
            delay(1000L)
            println("Coroutine launched in Activity scope!")
          }
       }

        override fun onDestroy() {
           super.onDestroy()
           activityScope.cancel() // Cancel all coroutines when activity is destroyed
        }
    }
    ```
#### Best Practices:
- GlobalScope should be used sparingly, if at all. It's better to create coroutines scope that can be easily managed and canceled.
- CoroutineScope should be preferred, as it gives control over the lifecycle of coroutines and avoids potential memory leaks.

#### Summary:
- GlobalScope: Use for coroutines that need to survive the entire application lifecycle. Avoid for most cases due to lack of control.
- CoroutineScope: Use for structured concurrency, where the coroutines' lifecycle is bound to a certain context (e.g., a task, activity, or ViewModel)/