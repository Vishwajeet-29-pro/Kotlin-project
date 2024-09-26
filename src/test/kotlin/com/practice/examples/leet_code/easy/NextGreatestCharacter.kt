package com.practice.examples.leet_code.easy

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NextGreatestCharacter {

    private final val greatestCharacter: QuestionNextGreatestCharacter = QuestionNextGreatestCharacter()

    @Test
    fun `test next greatest character` () {
        val charArray = charArrayOf('c', 'f', 'g')

        assertEquals('c', greatestCharacter.nextGreatestLetter(charArray, 'a'))
        assertEquals('f', greatestCharacter.nextGreatestLetter(charArray, 'd'))
    }
}