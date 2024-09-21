package com.practice.examples.leet_code.easy

class QuestionRomanToInteger {
    fun romanToInt(s: String): Int {

        val romanNumbers: MutableMap<Char, Int> = HashMap()
        romanNumbers['I'] = 1
        romanNumbers['V'] = 5
        romanNumbers['X'] = 10
        romanNumbers['L'] = 50
        romanNumbers['C'] = 100
        romanNumbers['D'] = 500
        romanNumbers['M'] = 1000

        var result = 0;
        for (i in s.indices) {
            val currentValue = romanNumbers[s[i]]

            if (currentValue != null) {
                if (i < s.length - 1 && currentValue < romanNumbers[s[i + 1]]!!) {
                    result -= currentValue
                } else result += currentValue
            }
        }
        return result
    }
}