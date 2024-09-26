package com.practice.examples.leet_code.easy

class QuestionNextGreatestCharacter {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        var start = 0
        var end = letters.size - 1
        if (target >= letters[end]) {
            return letters[0]
        }
        while (start <= end) {
            val mid = start + (end - start) / 2
            if (letters[mid] > target) {
                end = mid - 1
            }
            else start = mid + 1
        }
        return letters[start]
    }
}