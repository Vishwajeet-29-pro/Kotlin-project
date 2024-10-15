# 1. Data Classes
A data class in Kotlin is a class specifically designed to hold data. The compiler automatically provides several functions for data classes
such as `equals()`, `hashCode()`, `toString()`, `copy()`, and `componentN()` functions, making them very useful for value-based entities.

**Syntax:**
```kotlin
    data class Person(val name: String, val age: Int)
```

**Key features of data classes:**
1. Primary constructor: A data class must have at least one parameter in its primary constructor.
2. Auto-generated functions:
    - `toString()`: Provides a string representation of the object.
    - `equals()`: Checks if two data class instances are equal by comparing their properties.
    - `hashCode()`: Generates a bash code based on the properties.
    - `copy()`: Allows creating a copy of an object with or without modification.
    - `componentN()`: Functions to destructure the object. 

**Example:**
```kotlin

    data class User(val name: String, val age: Int)

    fun main() {
        val user1 = User("Alice", 25)
        val user2 = user1.copy(age = 30)
        
        println(user1) // output: User(name=Alice, age=25)
        println(user2) // output: User(name=Alice, age=30)
        
        // Destructuring declarations
        val (name, age) = user1
        println("Name: $name, Age: $age") // output: Name: Alice, Age: 25
    }
```  
In the example above, `copy()` crates a copy of the user1 object, changing only the `age` property, while other properties remain the same.

# 2. Object Keyword
The `object` keyword in Kotlin is used for defining Singletons, Companion Objects, and Anonymous Objects.

## 2.1 Singletons
Singletons are classes that only have a single instance. The `object` keyword allows you to create singleton objects in Kotlin.

Example:
```kotlin

    object DatabaseConnection {
        val url: String = "jdbc:mysql://localhost:3306/mydb"
        fun connect() {
            println("Connected to database: $url")
        }
    }

    fun main() {
        DatabaseConnection.connect()
    }
```
## 2.2 Companion Objects
A companion object is used to create static-like members within a class. This allows the class to have static methods and properties.
Example:
```kotlin

    class MyClass {
        companion object {
            const val CONSTANT_VALUE = 42
            fun staticMethod() {
                println("This is a static-like method.")
            }
        }
    }
    
    fun main() {
        println(MyClass.CONSTANT_VALUE) // Accessing static-like property
        MyClass.staticMethod() // Accessing static-like method.
    }
```
- The companion object allows access to `CONSTANT_VALUE` and `staticMethod()` as if they were static members of `MyClass`.
- Companion objects can also implement interface.

# 2.3 Anonymous Objects
The `object` keyword can be used to create an anonymous objects, which are often used in place interfaces or abstract classes.

Example:
```kotlin
    fun main() {
        val obj = object {
            val x = 10
            val y = 20
        }
        println("x = ${obj.x}, y = ${obj.y}")
    }
```
In this case, obj is an anonymous object that has properties x and y.

### Summary
- Data classes are a convenient way to create classes specifically for holding data, with several auto-generated functions.
- The object keyword provides a way to create Singletons, Companion Objects (which mimic static members in Java), and Anonymous Objects for one-off use cases.
