# Sequence in Kotlin 

## What is Sequence in Kotlin?
In Kotlin, sequence are a type of collection that allows the lazy evaluation of operations. When working with large dataset
or performing multiple transformations, sequence can be more efficient that lists, because operations on list are eager, meaning
they are executed immediately, while operations on sequence are lazy, meaning they are evaluated only when required (at the 
terminal operations)

Sequence are partially useful when you need to perform chain of operations (such as filtering, mapping, etc.) on large
collection with creating intermediate collections. 

#### Eager vs Lazy Evaluation 
- Eager Evaluation(Lists): When you used standard collection operations (e.g. map, filter), each transformation creating new collection
    and processes elements immediately. This can be inefficient for the large datasets.
- Lazy Evaluation(Sequence): A sequence delay computation and only processes elements only when absolutely necessary. This avoids creating
    multiple intermediate collections.

#### Creating Sequence
There are two main ways to create a sequence
1. Using the `sequenceOf()` function. This takes elements as input and convert them into sequence. 
2. Using the `asSequnce()` function. This function converts the existing collection into sequence.
~~We already implemented these function in practical examples, where we created sequences and performed operations.~~

#### Sequence Operations:
- Intermediate Operations: These operations returns sequence and they are lazy. 
  Examples include:
    - `map`
    - `filter`
    - `flatMap`
    - `take`, `drop`
  These are not execute immediately but instead returns the sequence for further chaining.
- Terminal Operations: These operations are eager and trigger the evaluation of the sequence. 
  Example includes:
    - `toList`
    - `sum`
    - `find`
    - `first`, `last`
These operations process the sequence and return a result, ending the evaluation.

### When to Use Sequences:
- Large Datasets: If you're working with large datasets and performing multiple transformation, sequence can save memory and
    improve the performance by avoiding the creation of intermediate collections. 
- Expensive operations: When the operations like (filtering and mapping) are computationally expensive, sequences can help evaluating
    only what's necessary.

### Conclusions:
1. **List operations are eager**, meaning they are executed immediately, which can result in intermediate collections.
2. **Sequence operations are lazy**, meaning they are evaluated only when necessary and do not create intermediate collections.

**Use Sequence to work with large datasets or complex chain of operations to improve performance and reduce memory usage.**