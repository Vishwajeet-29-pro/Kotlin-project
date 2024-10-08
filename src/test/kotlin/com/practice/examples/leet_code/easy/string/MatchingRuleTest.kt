package com.practice.examples.leet_code.easy.string

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MatchingRuleTest {

    private val matchingRule = QuestionMatchingRule()

    @Test
    fun `test matching rule for ruleKey is color and ruleValue is silver` () {
        val list = listOf(listOf("phone", "blue", "pixel"), listOf("computer", "silver", "lenovo"), listOf("phone", "gold", "iphone"))
        val ruleKey = "color"
        val ruleValue = "silver"

        val actual = matchingRule.countMatches(list, ruleKey, ruleValue)
        assertEquals(1, actual)
    }
}