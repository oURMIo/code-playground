package com.home.playground.leetcode

/**
 * task - https://leetcode.com/problems/merge-intervals/description
 */
private class MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        val result = mutableListOf<IntArray>()
        var inter = intervals[0]
        for (i in 1 until intervals.size) {
            val interval = intervals[i]
            if (interval[0] <= inter[1]) {
                inter[1] = maxOf(inter[1], interval[1])
            } else {
                result.add(inter)
                inter = interval
            }
        }
        result.add(inter)
        return result.toTypedArray()
    }
}

fun main() {
    test1()
    test2()
    test3()
    test4()
}

private fun test1() {
    val input = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(2, 6),
        intArrayOf(8, 10),
        intArrayOf(15, 18)
    )
    val output = arrayOf(
        intArrayOf(1, 6),
        intArrayOf(8, 10),
        intArrayOf(15, 18)
    )
    val result = MergeIntervals().merge(input)
    result.forEach {
        val string = "array:"
        print(string)
        it.forEach { array ->
            print("$array,")
        }
        println()
    }

    if (result.contentDeepEquals(output)) {
        println("1 passed")
    } else {
        println("1 failed")
    }
}

private fun test2() {
    val input = arrayOf(
        intArrayOf(1, 4),
        intArrayOf(0, 4),
    )
    val output = arrayOf(
        intArrayOf(0, 4)
    )
    val result = MergeIntervals().merge(input)
    result.forEach {
        val string = "array:"
        print(string)
        it.forEach { array ->
            print("$array,")
        }
        println()
    }

    if (result.contentDeepEquals(output)) {
        println("1 passed")
    } else {
        println("1 failed")
    }
}

private fun test3() {
    val input = arrayOf(
        intArrayOf(1, 4),
        intArrayOf(0, 1),
    )
    val output = arrayOf(
        intArrayOf(0, 4)
    )
    val result = MergeIntervals().merge(input)
    result.forEach {
        val string = "array:"
        print(string)
        it.forEach { array ->
            print("$array,")
        }
        println()
    }

    if (result.contentDeepEquals(output)) {
        println("1 passed")
    } else {
        println("1 failed")
    }
}

private fun test4() {
    val input = arrayOf(
        intArrayOf(1, 4),
        intArrayOf(0, 0),
    )
    val output = arrayOf(
        intArrayOf(0, 0),
        intArrayOf(1, 4)
    )
    val result = MergeIntervals().merge(input)
    result.forEach {
        val string = "array:"
        print(string)
        it.forEach { array ->
            print("$array,")
        }
        println()
    }

    if (result.contentDeepEquals(output)) {
        println("1 passed")
    } else {
        println("1 failed")
    }
}