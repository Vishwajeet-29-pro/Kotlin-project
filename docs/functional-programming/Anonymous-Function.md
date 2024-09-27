# Anonymous Functions in Kotlin
An anonymous function in Kotlin is a function that doesn't have name and is usually passed as argument to the higher order functions or stored in variable. They 
are similar to lambda expressions, but there are some key difference in their structure and usage. Anonymous function gives you the ability to explicitly define the return
types and support local returns, unlike lambdas.

### Syntax of Anonymous function:
An anonymous function is defined using `fun` keyword with giving name to it.
```
   fun (parameter: Type): ReturnType {
        // function body
    }
```
### Example:
```kotlin
    val multiply = fun(a: Int, b: Int): Int {
        return a * b
    }

    fun main() {
        println(multiply(10, 20))
    }
```
In this example:
- The fun(a: Int, b: Int): Int { ... } is an anonymous function.
- It's assigned to the multiply variable and can be used just like a regular function.

## Key Characteristics of Anonymous function:
1. **No Name:** Unlike regular function, anonymous function don't have a name.
2. **Explicit Return Type:** You can explicitly define a return type, which you can use in some cases.
3. **Support `return` :** You can use `return` inside anonymous function, and it behaves like it does in regular functions. This is in contrast to lambdas, where return refers to the outer function is used inside the lambdas.
4. **InLine Block:** They are commonly used as a inline blocks within higher order functions.
5. **Local Return:** You can return from an anonymous function without affecting the outer function, which isn't possible with lambdas.

## Anonymous functions vs Lambdas.
| Feature                 | Anonymous Function                                               | Lambda Function/expression                              |
|-------------------------|------------------------------------------------------------------|---------------------------------------------------------|
| Syntax                  | Uses fun keyword and function body                               | Shorter syntax without fun keyword or explicit return   |
| Return Type Declaration | Can explicitly define return types                               | Return type is inferred, and last expression is return. |
| Return Behaviour        | Supports return for local return                                 | `return` returns from the outer function (non local)    |
| Use Case                | Used when more complex logic is needed or return type is crucial | Used when function body is concise and simple           |

### Lambda Vs Anonymous function:
```kotlin
    // Lambda expression
    val sumLambda = {a: Int, b: Int -> a + b}
    println(sumLambda(10, 20))

    // Anonymous function:
    val sumAnonFun = fun(a: Int, b: Int): Int {
        return a + b
    }
    println(sumAnonFun(10, 20))
```

### Return in Anonymous function and Lambda:
1. **Anonymous Function:** A `return` inside an anonymous function will return from the anonymous function itself.
2. **Lambda Expression:** A `return` in a lambda is non-local; it returns from the outside function.

```kotlin
    fun outerFunction(): Int {
    val anonFunc = fun(a: Int): Int {
        if (a == 0) return 0
        return a * 2
    }
    return anonFunc(5)  // returns 10
    }
    
    fun outerFunctionWithLambda(): Int {
        val lambdaFunc = { a: Int ->
//            if (a == 0) return 0  // returns from outerFunctionWithLambda, not from the lambda
            a * 2
        }
        return lambdaFunc(5)
    }
    
    println(outerFunction())            // Output: 10
    println(outerFunctionWithLambda())  // Output: 10
```


