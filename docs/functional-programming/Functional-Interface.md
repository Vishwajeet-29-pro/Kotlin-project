# Functional Interface (SAM Conversions) in Kotlin

In Kotlin, Functional interface (also known as SAM interfaces) are interfaces that contains exactly one abstract method. The term SAM stands for **Single Abstract Method** 
This is similar to Java's functional interface, which can be implemented by using Lambda expressions. Kotlin provide the feature called SAM conversion that allows you to use lambda
expression to implement these interfaces seamlessly. 

## Key Concepts:
1. **Functional Interface:** A Functional interface is a interface has only one abstract method. It's meant to represent the single action or function.
2. **SAM (Single Abstraction Method):** 
   - Single Abstract Method interface is any interface with just one abstract method. 
   - SAM interfaces can be easily implemented using lambda expressions.
   - They are called functional interfaces
3. **SAM Conversions:**
   - SAM conversion in Kotlin allows you to use the lambda expression to provide an implementation for a functional interface.
   - This is particularly useful when working with Java libraries or frameworks that rely on the functional interfaces like `Runnable`, `Callable`, or listener interfaces
4. **Annotation: `@FunctionalInterface`:**
   - In Kotlin, marking an interface as Functional is optional.
   - In Java, you use the `@FunctionalInterface` annotation to indicate that the interface is intended to be a functional interface.
   - Kotlin does not require this annotation, but still treats Single Abstract Method interfaces as functional.

### Example of Functional Interface in Kotlin:
```kotlin
   fun interface MyFunctionalInterface {
       fun great(name: String)
   }
```
In this example, the interface is Functional interface because it has only one abstract method called great.

## SAM Conversions: Using Lambdas to Implement Functional Interfaces
In Kotlin, you can use the lambda expression instead of providing the full implementation of the functional interface. 
**Java Style Approach:**
```kotlin
   val greater = object : MyFunctionalInterface {
       override fun great(name: String) {
           println("Hello $name!")
       }
   }
    greater.great("Vishwajeet")
```
**Kotlin Style Approach:**
```
   val greeter: MyFunctionalInterface = { name -> println("Hello, $name!") }
   greeter.greet("Vishwajeet") // Output: Hello, Vishwajeet!
```
In this case, Kotlin automatically converts the lambda expression into an implementation of functional interface.

### Working with Java Functional Interfaces: 
SAM conversions are very helpful when working with java code from kotlin, especially with functional interfaces like `Runnable`,
`callable`. Since Java 8 introduce lambda expressions, Kotlin can seamlessly interact with the Java Lambdas through SAM conversions.
**Example with Java's Runnable:**
```kotlin
   val runnable: Runnable = Runnable { println("Running a task") }
    runnable.run() // Output: Running a task
```
**or using Kotlin's shorthand:**
```kotlin
   val runnable = Runnable { println("Running a task") } // just remove the object type.
   runnable.run() // Output: Running a task
```
Here, Kotlin automatically converts the lambda expression into an implementation of the Runnable interface.

## Kotlin's `fun interface`:
Kotlin introduces the fun keyword to mark functional interfaces explicitly. This makes it more clear that an interface is intended to be used as a functional interface
(Although, technically, this is optional).
**Example:**
```kotlin
    fun interface Calculator {
        fun calculate(a: Int, b: Int): Int
    }

    val add: Calculator =  Calculator {a, b -> a + b } 
    val result = add.calculate(5, 3)
    println(result)  // Output: 8

```
- Here, the Calculator interface is marked with fun to indicate it's a functional interface.
- We then use a lambda { a, b -> a + b } to implement the single abstract method calculate.

# Characteristics of Functional Interface
- Exactly one Abstract method.
- Can be implemented using lambda expression or anonymous objects.
- Can have multiple default and static methods (Java 8 + feature)
- Are automatically compatible with lambda expression due to SAM conversions.

Functional Interface vs Regular Interface:

| Functional Interface	                              | Regular Interface                                            |
|----------------------------------------------------|--------------------------------------------------------------|
| Only one abstract method.                          | 	Can have multiple abstract methods.                         |
| Used to represent single actions (like functions). | 	Represents behavior that a class can implement.             |
| Can be implemented with a lambda.	                 | Requires a concrete class to implement all abstract methods. |
| Examples: Runnable, Callable, Comparator.          | 	Examples: Serializable, Cloneable.                          |


