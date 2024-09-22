package com.practice.examples.leet_code.easy

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class InsertSearchPositionTest {
    private val insertSearchPosition: QuestionInsertSearchPosition = QuestionInsertSearchPosition()
    private var arr: IntArray = intArrayOf(1, 3, 5, 7)

    @Test
    fun `test insert search position algorithm` () {
        val target = 5
        val expected = 2
        val actual = insertSearchPosition.searchInsert(arr, target)
        assertEquals(expected, actual)
    }
}