# 1. Enum classes
An enum class (enumeration) is a special class that represents a fixed set of constants. Enums are typically used when you need to represent a collection of
related constants, such as directions, colors, or states.

**Syntax:**

```
    enum class Direction {
        NORTH, SOUTH, EAST, WEST
    }
```
### Key features of Enum classes:
1. **Constants:** Each constant in an enum class is an instance of the enum class itself.
2. **Properties and methods:** Enum constants can have properties, methods, and even a primary constructor.
3. **Default methods:** Kotlin enum classes have predefined methods like `name`, `ordinal`, and `value()`
   - `name`: Returns the name of the enum constant.
   - `ordinal`: Returns the index of the enum constant (starting from 0).
   - `values()`: Returns an array of all enum constants.

### Examples with properties and methods:

```
enum class Direction(val degree: Int) {
    NORTH(0), SOUTH(180), EAST(90), WEST(270);

    fun info(): String {
        return "Direction: $name, Degree: $degree"
    }
}

fun main() {
    val dir = Direction.NORTH
    println(dir.info())
    println(Direction.SOUTH.ordinal) // output: 1
}
```

In this example, the enum class Direction has a degrees property for each direction and a method `info()` that provides details about the direction.

#### When to use Enum classes:
- When you have a fixed set of constants.
- When you need to associate each constant with properties or methods (e.g., state management).

# 2. Sealed Classes
A sealed class is a special type of class that restricts the types that can subclass it. The main purpose of a sealed class is to represent a restricted
class hierarchy, where only a set of predefined subclasses are allowed.

Sealed classes are particularly useful in scenarios like state management or representing different types of results. (e.g., success or failure).

### Key features of Sealed classes:
1. Restricted subclassing: All subclasses of a sealed class must be declared in the same file as the sealed class.
2. Exhaustive when expression: Since all possible subclasses of a sealed class are known at compile time, you can safely use `when` expression without needing an `else` clause.

**Syntax:**
```
sealed class Response 

    class Success(val data: String) : Response()
    class Error(val message: String) : Response()
```

**Example:**
``` 
sealed class NetworkResult {
    data class Success(val data: String) : NetworkResult()
    data class Failure(val errorMessage: String) : NetworkResult()
}

fun handleResponse(result: NetworkResult) {
    when (result) {
        is NetworkResult.Success -> println("Data: ${result.data}")
        is NetworkResult.Failure -> println("Error: ${result.errorMessage}")
    }
}

fun main() {
    val success = NetworkResult.Success("Data loaded successfully")
    val failure = NetworkResult.Failure("Failed to load data")

    handleResponse(success)  // Output: Data: Data loaded successfully
    handleResponse(failure)  // Output: Error: Failed to load data
}

```
In this example, sealed class `NetworkResult` represents two possible outcomes: `Success` and `Failure`. The `when` expression handles both cases
without requiring an `else` clause, because all possible subclasses of `NetworkResult` are known at compile time.

### When to use Sealed classes:
- When you have a fixed set of subclasses and want to restrict their use.
- When working with result types like success, failure, loading, etc.
- When creating a discriminated union (i.e., a type that can represent different variants).

## Comparison between Enum and Sealed Classes:

| Enum Classes                                              | Sealed Classes                                        |
|-----------------------------------------------------------|-------------------------------------------------------|
| Used for a fixed set of constants.                        | Used for a fixed set of subclasses types.             |
| Each enum constant is an instance of the enum type.       | Subclasses can have their own properties and methods. |
| Enum constants are static and do not support inheritance. | Subclasses must be declared in the same file.         |
| Can't have multiple instances of the same constants.      | Subclasses allow different instances and states.      |
| Suitable for simple constants and states                  | Suitable for complex hierarchies and patterns.        |

## Summary:
- Enum classes: Represent a fixed set of constants (e.g., directions, colors, states). Can contain properties and methods, and are typically
    used for simple, predefined data.
- Sealed classes: Represent a fixed hierarchy of classes. They are powerful for modeling state, handling different types of responses, or result 
    handling with exhaustive when statements.

