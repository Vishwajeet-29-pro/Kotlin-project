# Kotlin Standard Library 

## What is an Extension function in Kotlin?
In Kotlin, extension functions allows you to add the new functionality to existing classes without modifying their source code.
This feature is especially useful when you need to add functionality to classes that you don't own or can't change (like classes from the kotlin 
Standard library, java library, or third party libraries)
An extension function is essentially a regular function that is added to an existing class using a special syntax.

#### How to define an extension function?
To define an extension function, you simply declare a new function with receiver type, which is type you are extending. This allows you to call
the function as if it were a member of that class.

Syntax: 
```
fun className.functionName(): ReturnType {
    // function body
    }
```
here 
- `className` is the type you are extending (receiver type)
- `functionName` is the name of your function
- You can access the receiver object using the keyword `this` inside the function.

Example:
```
fun String.reverseWords(): String {
    return this.split(" ").reversed().joinToString(" ")
}
fun main() {
    val sentence = "Kotlin is awesome"
    println(sentence.reverseWords()) // output: awesome is kotlin
}
```
In the above example
- The class String is extended with new function `reverseWords()`
- The function splits the string by spaces, reverse the list of words, and joins them back into a single string.

#### Extension Function in Kotlin Standard Library
The kotlin standard library makes extensive use of Extension function. Many functions you use on common types (like String, List, etc.)
are actually extension functions.
For example:
- `last()` is an example of the extension function for list:
```
    val number = listOf(1, 3, 5, 7)
    val lastNumber = number.last()
    println(lastNumber) // output is 7
```
- `isEmptyOrNull()` is an extension function for string?:
```gherkin
    val str: String? = null
    println(str.isEmptyOrNull()) // output: true
```

#### Properties as Extension Function
Kotlin also allows you to create extension properties, which let you define custom properties for a class.
**Example**
```gherkin
    val String.wordCount = Int 
      get() = this.split(" ").size

    fun main() {
      val str = "This is kotlin"
      println(str.wordCount)
      // output = 3
// here word count is extension property that calculates the number of words in a string.
```
#### Limitation of Extension Function:
- No access to private members: Extension function cannot access private or protected members of the class they are extending. They can only access public methods or properties.
- They don't actually modify actual class: Extension function don't actually change the class itself, they only provide illusion of adding new methods.
- Static Dispatch: Extension functions are resolved statically at compile time, not dynamically at runtime. This mean that the type of variable (and not the actual object) determines which
    extension function gets called.

##### Example of static Dispatch:
```gherkin
    open class Animal
    class Dog: Animal()

    fun Animal.speak() = "Animal Sound"
    fun Dog.speak() = "Bark"

    fun main() {
      val myAnimal: Animal = Dog()
      println(myAnimal.speak()) // output: Animal sound
```
In this example, even though the myAnimal is Dog object, the extension function for Animal gets called because variable type is Animal.
This demonstrates the static nature of extension function.

#### Use Cases for Extension Functions
- Adding utility functions to existing classes (e.g. String, List, etc.)
- Extending the third party libraries with additional functionality without modifying the source code.
- Writing cleaner and more readable code by extending existing types with custom behavior.






## What is Scope Functions
Scope functions are the part of standard library and provide a concise way to operate on objects within a limited scope. Scope function allows you to
define temporary scopes for objects, which can help in avoiding reputation and improving code readability.
Kotlin has five main scope functions:
- let
- apply
- run
- also
- with

#### Key Difference Between Scope Functions
The main differences between scope functions lie in:
1. **Object Reference:** Whether they are reference context object using it or this.
2. **Return Value:** Whether they return the context object itself or the result of the lambda.

Here is a breakdown of each scope function:

1. `let`
    - Purpose: Used to perform operations on a nullable object or chain operations.
    - Object References: it (the object is passed as an argument to the lambda)
    - Return Value: Returns the result of the lambda expression.

   **Use Case:** You want to execute some code on an object and returns a different value, often used for null-check or transformations.
    ```gherkin
    val str: String? = "Hello, Kotlin"
    val result = str.let {
      println(it) // prints the "Hello, Kotlin"
      it.length // return the length of the string
    }
    println(result) // 13
    ```

2. `apply`
    - Purpose: USed for object configuration, It is useful when you want to initialize or configure an object and then return the object itself.
    - Object Reference: `this` (the object is referenced inside the lambda using `this`).
    - Return Value: Returns the object itself.
    **Use Case:** You want to initialize or configure an object and return that object itself. 
    ```gherkin
        val person = Person().apply {
            name = "John"
            age = 30
        }
        println(person) // Returns the modified object: Person(name=John, age=30)
    ```
   
3. `run`
    - Purpose: Used to execute a block of code on an object and return the result.
    - Object Reference: `this`.
    - Return Value: Returns the result of the lambda expression.
    **Use Case:** You want to perform some computations on an object and return a value based on those computations.
    ```gherkin
      val person = Person(name = "Alice", age = 25)
      val greeting = person.run {
          "Hello, my name is $name and I am $age years old."
      }
      println(greeting)
    ```
4. `also`
    - Purpose: Similar to let, but returns the object itself. It is often used for side effects, such as logging or debugging.
    - Object Reference: `it`.
    - Return Value: Returns the object itself.
   **Use Case:** You want to do something with an object (like logging or debugging) and returns the object itself afterward.
    ```gherkin
      val numbers = mutableListOf(1, 2, 3)
      numbers.also {
        println("List before adding: $it")
      }.add(4)
      println(numbers) // output [1, 2, 3, 4]
    ```

5. `with`
    - Purpose: Used to operate on an object in a non-null context and return the result.
    - Object Reference: `this`.
    - Return Value: Returns the result of the lambda expression.
   **Use Case:** You want to perform multiple operations on an object and return a result without needing to reference the object each time.
```gherkin
    val person = Person(name = "Bob", age = 32)
    val description = with(person) {
      "Name: $name, Age: $age"
    }
    println(description)
```

| Scope Function | Object Reference | Return Value  | Typical Use case                                       |
|----------------|------------------|---------------|--------------------------------------------------------|
| `let`          | `it`             | Lambda Result | Null checks, transformation, chaining                  |
| `apply`        | `this`           | Object Itself | Object initialization/ configuration                   |
| `run`          | `this`           | Lambda Result | Performing operations that result in a value           |   
| `also`         | `it`             | Object Itself | Side effects like logging, then returning the object   |
| `with`         | `this`           | Lambda Result | Operation on a non-null object and returning a result. |
