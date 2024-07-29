package com.home.playground.leetcode

private class ValidParentheses {
    fun isValid(s: String): Boolean {
        val stack = CharArray(s.length)
        var top = -1

        for (char in s) {
            when (char) {
                '(', '{', '[' -> {
                    stack[++top] = char
                }

                ')' -> {
                    if (top == -1 || stack[top--] != '(') return false
                }

                '}' -> {
                    if (top == -1 || stack[top--] != '{') return false
                }

                ']' -> {
                    if (top == -1 || stack[top--] != '[') return false
                }
            }
        }
        return top == -1
    }
}

fun main() {

    if (ValidParentheses().isValid("()")) {
        println("passed")
    } else {
        println("fails")
    }

    if (ValidParentheses().isValid("()[]{}")) {
        println("passed")
    } else {
        println("fails")
    }

    if (ValidParentheses().isValid("(]")) {
        println("fails")
    } else {
        println("passed")
    }

    if (ValidParentheses().isValid("{[]}")) {
        println("passed")
    } else {
        println("fails")
    }

    if (ValidParentheses().isValid("([)]")) {
        println("fails")
    } else {
        println("passed")
    }
}