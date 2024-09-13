package com.practice.examples.collections

// Grouping and Partitioning

fun main() {
    // Grouping
    // groupBy()
    // Group elements by specified key, returning a map in which each key is corresponds to a list of elements
    val animals = listOf("Tiger", "Lion", "Elephant", "Cat", "Mouse")
    val groupByLength = animals.groupBy { it.length }
    println(groupByLength)

    // Partition
    // Splits the collection into two lists based on a predicate: the first list contain the elements that the predicate,
    // and the second list contains that do not match.
    val numbers = listOf(1,2,3,4,5)
    val (even, odd)  = numbers.partition { it % 2 == 0 }
    println(even)
    println(odd)

    // Aggregate Operation
    // reduce():
    // Accumulate the values starting from the first element and applying the operation from left to right. It uses the
    // first element as the starting point

    val sum = numbers.reduce { acc, number -> acc + number }
    println(sum)

    // fold()
    // Similar to reduce, but allows the specifying initial value.
    val sumWithInitialValue = numbers.fold(10) { acc, i -> acc + i }
    println(sumWithInitialValue)


    // foldRight() and reduceRight()
    // Performs the same operations as fold() and reduce(), but starts from the rightmost element and proceeds to the left.
}