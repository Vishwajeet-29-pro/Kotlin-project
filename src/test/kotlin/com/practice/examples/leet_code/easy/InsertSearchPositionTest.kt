package com.practice.examples.leet_code.easy

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class InsertSearchPositionTest {
    private val insertSearchPosition: QuestionInsertSearchPosition = QuestionInsertSearchPosition()
    private var arr: IntArray = intArrayOf(1, 3, 5, 6)

    @Test
    fun `test insert search position algorithm` () {
        val target = 5
        val expected = 2
        val actual = insertSearchPosition.searchInsert(arr, target)
        assertEquals(expected, actual)
    }

    @Test
    fun `test insert search position for smaller number not present in array` () {
        val target = 2
        val expected = 1
        assertEquals(expected, insertSearchPosition.searchInsert(arr, target))
    }

    @Test
    fun `test insert search position for bigger number not present in array` () {
        val target = 7
        val expected = 4
        assertEquals(expected, insertSearchPosition.searchInsert(arr, target))
    }
}