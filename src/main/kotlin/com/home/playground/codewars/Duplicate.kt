package com.home.playground.codewars

private class Duplicate {
    fun duplicateCount(input: String): Int {
        var count = 0
        val list = mutableListOf<String>()
        input.forEach {
            var dub = 0
            input.forEach { symbol ->
                if (it.lowercase() == symbol.lowercase() && !list.contains(symbol.lowercase())) {
                    dub++
                }
            }
            if (dub >= 2) {
                list.add(it.lowercase())
                count++
            }
        }
        return count
    }
}

fun main() {
    val string = "dA" + "c".repeat(10) + "b".repeat(100) + "a".repeat(1000)
    println("Input:$string, count of duplicate:${Duplicate().duplicateCount(string)}")
}