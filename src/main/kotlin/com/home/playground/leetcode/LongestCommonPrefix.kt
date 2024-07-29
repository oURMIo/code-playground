package com.home.playground.leetcode

private class LongestCommonPrefix {
    fun commonPrefix(strs: Array<String>): String {
        var prefix = strs[0]

        for (i in 1 until strs.size) while (strs[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length - 1)
            if (prefix.isEmpty()) return ""
        }

        return prefix
    }
}

fun main() {
    var str = arrayOf("flower", "flow", "flight")
    if (LongestCommonPrefix().commonPrefix(str) == "fl") {
        println("passed")
    } else {
        println("failed")
    }
    str = arrayOf("dog", "racecar", "car")
    if (LongestCommonPrefix().commonPrefix(str) == "") {
        println("passed")
    } else {
        println("failed")
    }
}