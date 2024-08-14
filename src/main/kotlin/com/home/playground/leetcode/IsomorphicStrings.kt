package com.home.playground.leetcode

/**
 * task - https://leetcode.com/problems/isomorphic-strings/description
 */
private class IsomorphicStrings {
    fun isIsomorphic(s: String, t: String): Boolean {
        val map = mutableMapOf<Char, Char>()
        for (i in s.indices) {
            if (map.containsKey(s[i])) {
                if (map[s[i]] != t[i]) return false
            } else {
                if (map.containsValue(t[i])) return false
                map[s[i]] = t[i]
            }
        }
        return true
    }

    fun isIsomorphicAI(s: String, t: String): Boolean {
        // Check if lengths are different
        if (s.length != t.length) return false

        // Maps to track the character mappings
        val mapSToT = mutableMapOf<Char, Char>()
        val mapTToS = mutableMapOf<Char, Char>()

        for (i in s.indices) {
            val charS = s[i]
            val charT = t[i]

            // Check mapping from s to t
            if (mapSToT.containsKey(charS)) {
                if (mapSToT[charS] != charT) return false
            } else {
                mapSToT[charS] = charT
            }

            // Check mapping from t to s
            if (mapTToS.containsKey(charT)) {
                if (mapTToS[charT] != charS) return false
            } else {
                mapTToS[charT] = charS
            }
        }

        return true
    }
}

fun main() {
    test1()
    test2()
}

private fun test1() {
    if (IsomorphicStrings().isIsomorphic("egg", "add")) {
        println("1 passed")
    } else {
        println("2 failed")
    }
}

private fun test2() {
    if (IsomorphicStrings().isIsomorphic("badc", "baba")) {
        println("2 failed")
    } else {
        println("1 passed")
    }
}