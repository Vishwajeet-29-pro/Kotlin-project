package com.practice.examples.leet_code.easy

import java.util.Stack

class QuestionValidParenthesis {
    fun isValid(s: String): Boolean {
        val stack: Stack<Char> = Stack()

        for (i in s.indices) {
            val ch = s[i]

            if (ch == '(' || ch == '{' || ch == '[') stack.push(ch)
            else {
                if (stack.isEmpty()) return false
                if ((ch == ')' && stack.pop() != '(') ||
                    (ch == '}' && stack.pop() != '{') ||
                    (ch == ']' && stack.pop() != '[')
                ) {
                    return false
                }
            }
        }
        return stack.isEmpty()
    }
}