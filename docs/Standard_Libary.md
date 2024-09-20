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




