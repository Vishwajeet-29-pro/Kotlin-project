# Lambda Expression
Lambda expressions are key feature in Kotlin that allows you to create anonymous functions that can be treated as values.
They are often used as a arguments to higher order functions and help create concise and expressive code.

## Syntax of Lambda expression:
```
    {parameter -> body}
```
- parameter: The input parameter for the lambda (optional if there is only one parameter)
- Arrow (->): Separates parameter from body.
- Body: The code that executes when the lambda is invoked.

### Basic Example:

```kotlin
    val square: (Int) -> Int = { x -> x * x }
    fun main () {
        println("The square of 2 is :  ${square(2)}")
    }
```
### Lambda With Multiple parameters:
you can also define lambdas with multiple parameters
```kotlin
    val add: (Int, Int) -> Int = {x, y -> x + y}

    fun main() {
        val result = add(2, 5)
        println("The addition of two numbers is: $result")
    }
```

## Type Inference:
Kotlin can often infer the type of the parameters, so you can omit them if the context makes it clear.
```kotlin
    val multiply: (Int, Int) -> Int = {x, y -> x * y}
```
you can also use it without explicitly stating types:
```kotlin
    val multiply = {x: Int, y: Int -> x * y }
```
## Using Lambdas with Higher order functions.
Lambdas are frequently used with higher order functions. For instance, you can use them with map, filter and reduce functions.

## Returning values from Lambdas:
Lambdas can return the value. The expression in the body is treated as the return value.
```kotlin
    val max = {x: Int, y:Int -> if (x > y) x else y}

    fun main() {
        println("The max value between 10 and 20 is: ${max(10, 20)}")
    }
```
## MultiLine Lambda Expressions:
If your lambda body contains multiple statements, you can close them in curly braces. You need to use return keyword explicitly
if you want to return the value.
```kotlin
    val sumAndPrint: (Int, Int) -> Unit = {x, y -> 
        val sum = x + y
        println(sum)
    }
    fun main() {
        sumAndPrint(10, 1)
    }
```
## Using `it` Keyword
When lambda has single parameter and it's type can be inferred, you can use the implicit name `it`.

```kotlin
    val names = listOf("Alice", "Bob", "Charlie")
val upperCaseName = names.map { it.uppercase() }

fun main() {
    println("The names of list in uppercase: $upperCaseName")
}
```
## Capturing Variables:
Lambdas can access variables from surrounding scope. This feature is called Closure.
```kotlin
    fun main() {
        var total = 0
        val addToTotal: (Int) -> Unit = {total += it}
    
        addToTotal(5)
        addToTotal(3)
    
        println("Total is: $total")
    }
```
## Summary of Lambda Expressions in Kotlin
- Definition: A lambda expression is an anonymous function that can be treated as a value.
- Syntax: { parameters -> body }.
- Type Inference: Types can often be inferred, allowing for concise declarations.
- Use with Higher-Order Functions: Lambdas are frequently used with higher-order functions like map, filter, and forEach.
- Implicit it Keyword: You can use it for single parameters.
- Closure: Lambdas can access variables from the enclosing scope.

Lambdas are a fundamental concept in Kotlin that enhance the language's expressiveness and enable a functional programming style, making your code cleaner and more concise.
