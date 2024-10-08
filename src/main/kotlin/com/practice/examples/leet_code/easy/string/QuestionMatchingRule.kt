package com.practice.examples.leet_code.easy.string

class QuestionMatchingRule {
    fun countMatches(items: List<List<String>>, ruleKey: String, ruleValue: String): Int {

        var counter = 0
        var index = 0

        if (ruleKey == "color") index = 1
        if (ruleKey == "name") index = 2

        for (i in items) {
            if (i[index] == ruleValue) {
                counter++
            }
        }
        return counter
    }
}