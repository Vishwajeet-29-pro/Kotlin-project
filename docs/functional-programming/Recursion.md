# Recursion in Kotlin

Recursion is a technique where function call itself in order to solve the problem. In Kotlin, recursion is treated similarly to other programming languages, but comes with kotlin specific features, like tail
recursion optimization, which is important for performance.

## What is Recursion?
In Recursion, a function keeps calling itself until it reaches to base case, which acts as a stopping condition. Every recursive function consist of two main parts:
1. Base Condition: The condition that stops the recursion.
2. Recursive function: The part where function calling itself to break down the problem into smaller sub problems.

Example: Simple Recursion (Factorial Calculation):
Let's start with the simple example of recursion - calculating a factorial of a number
```kotlin
fun factorial(n: Int): Int {
    return if (n == 1) {
        1 
    } else {
        n * factorial(n - 1)
    }
}

fun main() {
    println(factorial(5)) // output : 120
}
```
**Explanation:**
**Base Case**: When n equals 1, the function returns 1. This prevent further recursive calls.
**Recursive Case:** For n > 1, function call itself with n - 1, progressively breaking the problem into smaller steps.
In this example factorial(5) leads to `5 * factorial(4)`, then `4 * factorial(3)`, and so on, until the base case is reached.

## Tail Recursion in Kotlin
Kotlin provides a special feature called tail recursion, to optimize the recursive functions, preventing the stack overflow errors in deep recursion.
A function is considered as tail recursive when the last operation it performs is the recursive call. 

When using `tailrec` modifier, Kotlin can optimize the function to avoid creating new stack frames for each recursive call. Instead, it reuses the current
function's stack frame, allowing the recursion to be deep as needed without the risk of stack overflow.
**Example:**
Tail Recursion Factorial: 
```kotlin
    tailrec fun tailRecursiveFactorial(n: Int, acc: Int = 1): Int {
        return if (n == 1) {
            acc
        } else {
            tailRecursiveFactorial(n - 1, acc * n)
        }
    }

    fun main() {
        println(tailRecursiveFactorial(5)) // output 120
    }
```
**Explanation:**
**Tailrec Modifier:** This tells kotlin to optimize the recursion to prevent stack overflow.
**Accumulator (acc):** Instead of multiplying the result after returning from recursion (as in normal recursion), the current result is carried along with each recursive call.
**Tail Position:** The recursive call is the last action in the function, which is required for the tail recursion.

## Why use Tail Recursion?
In normal recursion, each function call creates a new frame in the call stack, which can lead to stack overflow when dealing with large input sizes. Tail recursion allows the compiler to optimize the 
recursion to avoid this problem by not adding new frames for each recursive call. 

**Example: Fibonacci Sequence (Simple Recursion)**
Let's look at the common example:
```kotlin
    fun fibonacci(n: Int): Int {
        return  when (n) {
            0 -> 0
            1 -> 1
            else -> fibonacci(n - 1) + fibonacci(n - 2)
        }
    }
    fun main() {
        println(fibonacci(6)) // output 8
    }
```
**Explanation:**
- The base cases are when n is 0 or 1, which return 0 and 1, respectively.
- The recursive case calls the fibonacci function for the two preceding numbers (n - 1 and n - 2).

**Example: Tail Recursive Fibonacci**
To avoid inefficiencies (since the above example recalculates some values multiple times), you can optimize it using tail recursion with an accumulator:
```kotlin
    tailrec fun fibonacciTailRec(n: Int, a: Int = 0, b: Int = 1): Int {
        return if (n == 0) a else fibonacciTailRec(n -1, b, a+b)
    }

    fun main() {
        println(fibonacciTailRec(6))
    }
```
**Explanation**:
The function now accumulates the result by passing the intermediate values a and b as parameters.
**Tail recursion** is used because the recursive call is the last operation.

## Recursive Vs Iterative Approach:
While recursion is elegant and often easy to read, it can sometimes lead to performance issues in languages that don’t optimize tail recursion. In these cases, iterative approaches can be more efficient because they don’t rely on the call stack. However, in Kotlin, tail recursion offers a nice balance between readability and efficiency.

**Key Points to Remember:**
* **Base Case**: Always ensure that your recursive function has a stopping condition (base case), or it will run infinitely.
* **Recursive Case:** Call the function with modified parameters to gradually reduce the problem size.
* **Tail Recursion:** When possible, use the tailrec keyword to optimize recursion and avoid stack overflow errors for deep recursion.
* **State Accumulation:** Use accumulators (additional parameters) to carry intermediate state in recursive calls, especially for tail recursion.

**Recursion vs Loops**
Recursion is often preferred in functional programming for its clarity and ability to express solutions elegantly. However, in performance-sensitive areas, loops might be more efficient. Tail recursion allows you to get the best of both worlds in Kotlin.



