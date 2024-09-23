# Higher Order Functions
Higher Order Functions are the powerful feature in Kotlin and many other functional based programming language.
A Higher order function is a function that either:
- takes one or more functions as parameter
- Returns a function.
This features allows us to write more abstract, reusable and flexible code.

### Why Higher Order Functions ?
They allow you to:
- Pass behaviour(function) as an argument.
- Return behaviour(function) from other function.
- Write cleaner and more modular code by abstracting over actions or behaviour.

#### Basic Example of Higher Order Function

```kotlin
    // Higher order function takes another function as a parameter.
    fun higherOrderFunction(operation: (Int, Int) -> Int, a: Int, b: Int): Int {
      return operation(a, b)
    }
    // function to add two numbers
    fun addTwoNumbers(x: Int, y: Int): Int {
      return x + y
    }
    
    fun main() {
      // call higher order function, passing the add function as a parameter and other two numbers.
      val result = higherOrderFunction(::add, 5, 3)
      println("Result of addition is: $result")
    }
```
In this example:
- `higherOrderFunction` is the higher-order function because it takes the another function (operation) as parameter.
- `operation` is a function type parameter: `(Int, Int) -> Int`
- `add` is the regular function pass to `higherOrderFunction`.

### Lambda Expression as Function parameters.
In kotlin, instead of defining separate named function like `add`, you can pass the lambda expression directly.
```
    fun main() {
        // Passing a lambda directly as a function parameter
        val result = higherOrderFunction({ x, y -> x + y }, 5, 3)
        println("Result of lambda addition: $result")  // Output: Result of lambda addition: 8
    }
```
In this case, the lambda expression `{x,y -> x + y}` is an anonymous function passed directly to the higher order function.
The type of the lambda inferred by kotlin.

#### Simplified Syntax for Lambdas.
If the last parameter of the function is another function, you can move the lambda outside of parenthesis for more readability.
```kotlin
    fun main() {
        val result = higherOrderFunction(5,3) {x, y -> x + y}
        println("Result with simplified syntax: $result ")
    }
```
### Returning a Function from a Another Function
A higher order function can also return a function.
```kotlin
    fun operationChooser(operation: String): (Int, Int) -> Int {
        return when (operation) {
            "add" -> {x, y -> x + y}
            "subtract" -> {x, y -> x- y}
            else -> throw IllegalArgumentException("Unknown Operation")
        }
    }
    fun main() {
        val chooseOperation = operationChooser("add")
        val result = chooseOperation(10, 5)
        println("Result is: $result")
    }
```
Here, operation chooser returns the function based on string you passed.

### Higher Order Function with Collection Operations.
Kotlin standard library make extensive use of Higher order functions. You often see them in collection operations like `map`, `filter`, `reduce`, etc.
#### Example using map and filter:
```kotlin
    fun main() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
    
        val evenNumber = numbers.filter { it % 2 == 0 }
        val squareOfEvenNumbers = evenNumber.map { it * it }
    
        println("The even number list: $evenNumber")
        println("The square of even number list: $squareOfEvenNumbers")
    }
```
In this case,
- filter takes lambda functions that check if number is even.
- map takes lambda function convert each element to it's square.

### Summary of Higher-Order Functions in Kotlin:
- Higher-Order Function: A function that takes another function as a parameter or returns a function. 
- Function Types: (ParameterType) -> ReturnType. 
- Lambda Expressions: Anonymous functions that can be passed as arguments or returned. 
- Real-world Use Cases: Extensively used in collection operations like map, filter, reduce, etc.