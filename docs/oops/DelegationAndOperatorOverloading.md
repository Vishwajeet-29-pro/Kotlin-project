# 1. Delegation in Kotlin
Delegation is a design pattern where an object hands off (delegates) some of its tasks to another helper object.
Kotlin has built-in support for delegation, making it easier to use this pattern.

There are two types of delegation in Kotlin:
- **Class Delegation** (Using `by` keyword)
- **Property Delegation** (Custom behavior for property access)

### A. Class Delegation
Class delegation allows one class to delegate the implementation of an interface to another class using the `by` keyword.
This is useful when you want to reuse behavior from another class without inheritance.

### Example:
```kotlin

interface Printer {
    fun printMessage(message: String)
}

class ConsolePrinter: Printer {
    override fun printMessage(message: String) {
        println("Printing message: $message")
    }
}

class PrinterManger(printer: Printer) : Printer By printer 

fun main() {
    val consolePrinter = ConsolePrinter()
    val manger = PrinterManger(consolePrinter)
    manger.printMessage("Hello Kotlin")
}
```
In this example, `PrinterManager` delegates the implementation of Printer to ConsolePrinter using `by` keyword. As a result `PrinterManager` does not need
 to implement `printMessage()`.

### B. Property Delegation:
Kotlin also allows property delegation where you can delegate property getter/setter logic to another object using built-in delegates or custom delegates.

Kotlin has built-in delegates like:
- `lazy`: Lazy initialization of a property.
- `observable`: Property that can react to changes
- `vetoable`: Property that allows vetoing changes

#### Example with `lazy`:
```kotlin
class DataLoader { 
    val data by lazy {
        println("Loading data...")
        "Data Loaded"
    }
}

fun main() {
    val loader = DataLoader()
    println("Before accessing data")
    println(loader.data) // Triggers the lazy initialization
    println(loader.data) // Already loaded, so no re-initialization
}
```
In this example, the property `data` is initialized lazily only when it's accessed for the first time.

# 2. Operator Overloading in Kotlin
Kotlin allows you to provide custom implementation for a predefined set of operators on your types. This is done by defining a function
with a specific name for the corresponding operator. Operator overloading makes your custom classes easier to work with by allowing them to use 
common operators like `+`, `-`, `*`, `==`, etc

Key points:
- Only a predefined set of operators can be overloaded.
- The function must be marked with the `operator` keyword.

### Example: Overloading `+` operator for a custom class
```kotlin
data class Point(val x: Int, val y:Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}

fun main() {
    val point1 = Point(10, 20)
    val point2 = Point(5, 10)
    val result = point1 + point2
    println(result)
}
```
In this example, we overloaded the `+` operator for the Point class to add the x and y values of two points.

#### Common Operators that can be Overloaded:
- Arithmetic Operator: `+`,`-`,`*`,`/`,`%`
- Comparison Operators: ==, !=, >, <, >=, <=
- Assignment Operators: +=, -=, *=, /=
- Unary Operators: +, -, ++, --
- Indexing: []
- Invoke Operator: ()

## Example: Overloading `invoke()` operator
You can overload the `invoke()` operator to make your objects callable like functions:
```kotlin
class CallableObject {
    operator fun invoke(value: String) {
        println("You called me with: $value")
    }
}

fun main() {
    val callable = CallableObject()
    callable("Hello Kotlin!")
}
```

In this example, CallableObject overloads the `invoke` operator, allowing an instance of this clas to be called like a function.

### Summary of Delegation and Operator Overloading
Delegation:
- Class Delegation: Delegates the implementation of an interface to another class using the by keyword. Useful for reusing behavior without inheritance.
- Property Delegation: Delegates getter/setter behavior to another object or logic. Includes built-in delegates like lazy, observable, etc.

Operator Overloading:
- Kotlin allows overloading certain operators (+, -, [], ==, (), etc.) for custom types.
- Overloading makes classes more intuitive to use by leveraging standard operators.
