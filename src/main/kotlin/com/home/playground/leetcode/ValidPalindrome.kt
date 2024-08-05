package com.home.playground.leetcode

/**
 * task - https://leetcode.com/problems/valid-palindrome/description
 */
private class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        val newS = s.lowercase().replace(Regex("[^a-z0-9]"), "")
        for (i in newS.indices) {
            if (newS[i] != newS[newS.length - 1 - i]) {
                return false
            }
        }
        return true
    }
}

private class ValidPalindrome2 {
    fun isPalindrome(s: String): Boolean {
        val cleanedPhrase = s.filter { it.isLetterOrDigit() }.lowercase()
        return cleanedPhrase == cleanedPhrase.reversed()
    }
}

// The best
private class ValidPalindrome3 {
    fun isPalindrome(s: String): Boolean {
        val cleanedPhrase = s.filter { it.isLetterOrDigit() }.lowercase()

        for (i in 0 until cleanedPhrase.length / 2) {
            if (cleanedPhrase[i] != cleanedPhrase[cleanedPhrase.length - 1 - i]) {
                return false
            }
        }
        return true
    }
}

fun main() {
    testValidPalindrome()
    testValidPalindrome2()
    testValidPalindrome3()
}

private fun testValidPalindrome() {
    val validPalindrome = ValidPalindrome()

    if (validPalindrome.isPalindrome("A man, a plan, a canal: Panama")) {
        println("first passed")
    } else {
        println("first failed")
    }

    if (validPalindrome.isPalindrome("0a")) {
        println("first failed")
    } else {
        println("first passed")
    }

    if (validPalindrome.isPalindrome(".a")) {
        println("first passed")
    } else {
        println("first failed")
    }
}

private fun testValidPalindrome2() {
    val validPalindrome = ValidPalindrome2()

    if (validPalindrome.isPalindrome("A man, a plan, a canal: Panama")) {
        println("first passed")
    } else {
        println("first failed")
    }

    if (validPalindrome.isPalindrome("0a")) {
        println("first failed")
    } else {
        println("first passed")
    }

    if (validPalindrome.isPalindrome(".a")) {
        println("first passed")
    } else {
        println("first failed")
    }
}

private fun testValidPalindrome3() {
    val validPalindrome = ValidPalindrome3()

    if (validPalindrome.isPalindrome("A man, a plan, a canal: Panama")) {
        println("first passed")
    } else {
        println("first failed")
    }

    if (validPalindrome.isPalindrome("0a")) {
        println("first failed")
    } else {
        println("first passed")
    }

    if (validPalindrome.isPalindrome(".a")) {
        println("first passed")
    } else {
        println("first failed")
    }
}