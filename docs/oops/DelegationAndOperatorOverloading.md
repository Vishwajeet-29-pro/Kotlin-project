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

