package com.home.playground.leetcode

/**
 * task - https://leetcode.com/problems/is-subsequence/description/
 */
private class IsSubsequenceClass {
    fun isSubsequence(s: String, t: String): Boolean {
        var index1 = 0
        var index2 = 0

        while (index1 < s.length && index2 < t.length) {
            if (s[index1] == t[index2]) {
                index1++
            }
            index2++
        }

        return index1 == s.length
    }

    fun isSubsequence2(s: String, t: String): Boolean {
        var indexS = 0
        val lengthS = s.length
        val lengthT = t.length

        if (lengthS > lengthT) return false

        for (indexT in 0 until lengthT) {
            if (indexS < lengthS && s[indexS] == t[indexT]) {
                indexS++
            }
            if (indexS == lengthS) return true
        }

        return indexS == lengthS
    }
}

fun main() {
    firstTest()
    secondTest()
    thirdTest()
    fourthTest()
    fiftiethTest()
}

private fun firstTest() {
    if (IsSubsequenceClass().isSubsequence(s = "abc", t = "ahbgdc")) {
        println("first passed")
    } else {
        println("first failed")
    }
}

private fun secondTest() {
    if (IsSubsequenceClass().isSubsequence(s = "axc", t = "ahbgdc")) {
        println("first failed")
    } else {
        println("first passed")
    }
}

private fun thirdTest() {
    if (IsSubsequenceClass().isSubsequence(s = "acb", t = "ahbgdc")) {
        println("first failed")
    } else {
        println("first passed")
    }
}

private fun fourthTest() {
    if (IsSubsequenceClass().isSubsequence(s = "bb", t = "ahbgdc")) {
        println("first failed")
    } else {
        println("first passed")
    }
}

private fun fiftiethTest() {
    if (IsSubsequenceClass().isSubsequence(s = "ab", t = "baab")) {
        println("first passed")
    } else {
        println("first failed")
    }
}