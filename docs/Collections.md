# Collections in Kotlin:
Kotlin's collection provide a powerful and flexible way to store, manage and manipulate the data.
The three primary collection types are List, Set, Map, each of which serves a distinct purpose. Kotlin also distinguishes
between mutable and immutable collections, allowing flexibility depending on whether you need to modify the collection.

~~As we already added details notes in actual implementation of these collections we can skip that notes~~
### Difference between List and Set
[ListImplementation.kt](../src/main/kotlin/com/practice/examples/collections/ListImplementation.kt)
[SetImplementation.kt](../src/main/kotlin/com/practice/examples/collections/SetImplementation.kt)
[MapImplementation.kt](../src/main/kotlin/com/practice/examples/collections/MapImplementation.kt)

| List                 | Set                       |
|----------------------|---------------------------|
| Allows Duplicate     | Does not allows duplicate |
| Elements are ordered | Element are unordered     |
| Access by index      | No index based access.    |

### Difference between List, Set and Map
| List                   | Set                      | Map                                             |
|------------------------|--------------------------|-------------------------------------------------|
| Ordered Collection     | Unordered Collection     | Collection with Key value                       |
| Allow duplicates       | Does not allow duplicate | Key should be unique and value can be duplicate |
| Access by index        | No access by index       | Access by key                                   |
| Example: List of names | Example: Unique Ids      | Example: Dictionary                             |

## Mutable vs Immutable Collection
Kotlin has both Mutable and Immutable versions of collections:
 - **Immutable Collections (`List`,`Set`,`Map`):** Cannot not be changed after creation. They are created with functions 
    like `listOf()`, `setOf()`, `mapOf()`.
 - **Mutable Collection (`MutableList`, `MutableSet`, `MutableMap`):** Can be changed (elements can be added, removed or replaced)
    They are created with functions like `mutableListOf()`, `mutableSetOf()`, `mutableMapOf()`.

Choosing between mutable and immutable collections is important when designing our Kotlin application, as immutable collections helps
to ensure the data integrity and thread safety, while mutable collection provides the flexibility for changes.

#### Summary 
- List: Ordered Collection, allow duplicates, accessed by index.
- Set: Unordered collection, no duplicates allow, no index access.
- Map: Key-value pair collection, unique keys, access by keys.

Each collection type has its place depending on your specific needs, and kotlin provides you an easy and concise syntax for
creating and working with them.