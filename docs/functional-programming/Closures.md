# Closures in Kotlin
A **closure** a function or lambda expression that captures variables from surrounding scope (i.e. Variable defined outside the function)
and access and modify them even after function has finished executing.

### Characteristics of a Closures:
1. **Captures State:** A closure can "remember" and maintain access to the variables from the scope where they created.
2. **Modifies State:** Closures can modify the captures variables even after the enclosing function has exited.
3. **Lifespan:** The lifespan of capture variable extends beyond the function that created them. As long as closure exists, the variable remain alive.

### Example of Closure:
```kotlin
    fun main() {
        var counter = 0
    
        val incrementCounter: () -> Unit = {
            counter += 1
            println("Counter: $counter")
        }
    
        incrementCounter()
        incrementCounter()
    }
```
In this example:
- The `incrementCounter` lambda captures the counter from the surrounding scope. 
- Every time lambda is called, it modifies the value of counter even though counter was declared outside the lambda.

### How Closure Works?
- When a lambda expression is created, it can "close over" the variables that are in the scope at that time of its creation.
- Even after the function where the lambda was defined returns, the lambda still has access to those variables and can use them.
- The variables that are captured by a closures are stored in memory, which is why their state persist.

### Closure example with Higher order function:
```kotlin
    fun makeMultiplier(factor: Int): (Int) -> Int {
        return {number -> number * factor}
    }

    fun main () {
        val multiplyBy2 = makeMultiplier(2)
        val multiplyBy3 = makeMultiplier(3)
        
        println(multiplyBy2)
        println(multiplyBy3)
    }
```
In this example:
- The function `makeMultipler` returns a lambda that multiplies the given number by factor.
- The variable factor is "closed over" by the returned lambda and remains accessible whenever lambda is called.
- Even after the `makeMultipler` has finished execution, the return lambda retains access to factor.

### Real World use of Closure
Closures are useful in situations where:
- Stateful function: You want to maintain some internal state within a function.
- Callbacks: Closures are commonly used for event handlers or asynchronous operations where some context (variables) needs to be remembered across the multiple calls.
- Functional Programming: Closures enables higher order functions to be more extensive by capturing and maintaining the access to local variables.

### Key concepts related to closure:
1. Lexical Scoping: Closures works because of Lexical scoping, which means that the function can remember the scope where it was created and access variables from that scope.
2. Immutability and Closures: In Kotlin, Closures works with both immutable and mutable variables. However, when working with functional programing, it's generally prefer to immutability, as it leads to fewer side effects.
3. Closure and Performance: Be aware that capturing variable can sometimes have performance implication. Since capture variables are stored in memory, it might prevent objects from being Garbage collected if they are referenced by long-lived closures.

## Summary Of Closures: 
- Definition: A closure is a function or lambda that captures and retain access to variable from surrounding scope.
- Capturing State: Closures allows functions to remember the value of variables even after the function executed.
- Modifying state: Closures can modify the captured variables.
- Lexical Scoping: Closures rely on the lexical scoping for capturing the variables.
- Use Cases: Closures are frequently used for maintaining internal state, callbacks and in functional programming scenarios.


