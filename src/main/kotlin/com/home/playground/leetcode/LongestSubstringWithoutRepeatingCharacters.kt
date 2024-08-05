package com.home.playground.leetcode

/**
 * task - https://leetcode.com/problems/longest-substring-without-repeating-characters/description
 */
private class LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(s: String): Int {
        val map = mutableMapOf<Char, Int>()
        var maxSize = 0
        var starter = 0

        for (i in s.indices) {
            if (map.containsKey(s[i])) {
                if (starter < map[s[i]]!! + 1) {
                    starter = map[s[i]]!! + 1
                }
            }
            map[s[i]] = i
            if (maxSize < i - starter + 1) {
                maxSize = i - starter + 1
            }
        }
        return maxSize
    }
}

fun main() {
    test1()
    test2()
    test3()
}

private fun test1() {
    if (LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb") == 3) {
        println("1 passed")
    } else {
        println("1 failed, Expected:3")
    }
}

private fun test2() {
    if (LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew") == 3) {
        println("2 passed")
    } else {
        println("2 failed, Expected:3")
    }
}

private fun test3() {
    if (LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("dvdf") == 3) {
        println("3 passed")
    } else {
        println("3 failed, Expected:3")
    }
}
