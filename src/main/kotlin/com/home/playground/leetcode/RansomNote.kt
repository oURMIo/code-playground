package com.home.playground.leetcode

/**
 * task - https://leetcode.com/problems/ransom-note/description
 */
private class RansomNote {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val magazineMap = mutableMapOf<Char, Int>()
        magazine.forEach {
            magazineMap[it] = magazineMap.getOrDefault(it, 0) + 1
        }

        ransomNote.forEach {
            val count = magazineMap.getOrDefault(it, 0)
            if (count == 0) return false
            magazineMap[it] = count - 1
        }
        return true
    }

    fun canConstructAI(ransomNote: String, magazine: String): Boolean {
        val charCounts = IntArray(26)
        magazine.forEach { char ->
            charCounts[char - 'a']++
        }
        ransomNote.forEach { char ->
            if (charCounts[char - 'a'] == 0) return false
            charCounts[char - 'a']--
        }

        return true
    }
}

fun main() {
    test1()
    test2()
}

private fun test1() {
    if (RansomNote().canConstruct("aa", "ab")) {
        println("1 failed")
    } else {
        println("1 passed")
    }
}

private fun test2() {
    if (RansomNote().canConstruct("aa", "aab")) {
        println("2 passed")
    } else {
        println("2 failed")
    }
}

/**
 * code on C++
 * #include <string>
 * #include <vector>
 *
 * class Solution {
 * public:
 *     bool canConstruct(const std::string& ransomNote, const std::string& magazine) {
 *         std::vector<int> charCounts(26, 0);
 *         for (char c : magazine) {
 *             charCounts[c - 'a']++;
 *         }
 *         for (char c : ransomNote) {
 *             if (charCounts[c - 'a'] == 0) {
 *                 return false;
 *             }
 *             charCounts[c - 'a']--;
 *         }
 *         return true;
 *     }
 * };
 */