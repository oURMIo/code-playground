package com.home.playground.leetcode

/**
 * task - https://leetcode.com/problems/insert-interval/description
 */
private class InsertInterval {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        var i = 0

        while (i < intervals.size && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i])
            i++
        }

        while (i < intervals.size && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = minOf(newInterval[0], intervals[i][0])
            newInterval[1] = maxOf(newInterval[1], intervals[i][1])
            i++
        }
        result.add(newInterval)

        while (i < intervals.size) {
            result.add(intervals[i])
            i++
        }

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
    val input1 = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(6, 9)
    )
    val input2 = intArrayOf(2, 5)
    val output = arrayOf(
        intArrayOf(1, 5),
        intArrayOf(6, 9)
    )
    val result = InsertInterval().insert(input1, input2)
    result.forEach {
        val string = "array:"
        print(string)
        it.forEach { array ->
            print("$array, ")
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
    val input1 = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(3, 5),
        intArrayOf(6, 7),
        intArrayOf(8, 10),
        intArrayOf(12, 16)
    )
    val input2 = intArrayOf(4, 8)
    val output = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(3, 10),
        intArrayOf(12, 16)
    )
    val result = InsertInterval().insert(input1, input2)
    result.forEach {
        val string = "array:"
        print(string)
        it.forEach { array ->
            print("$array, ")
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
    val input1 = arrayOf(
        intArrayOf(1, 5),
        intArrayOf(6, 8),
    )
    val input2 = intArrayOf(5, 6)
    val output = arrayOf(
        intArrayOf(1, 8),
    )
    val result = InsertInterval().insert(input1, input2)
    result.forEach {
        val string = "array:"
        print(string)
        it.forEach { array ->
            print("$array, ")
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
    val input1 = arrayOf(
        intArrayOf(1, 5),
        intArrayOf(6, 8),
    )
    val input2 = intArrayOf(0, 9)
    val output = arrayOf(
        intArrayOf(0, 9),
    )
    val result = InsertInterval().insert(input1, input2)
    result.forEach {
        val string = "array:"
        print(string)
        it.forEach { array ->
            print("$array, ")
        }
        println()
    }

    if (result.contentDeepEquals(output)) {
        println("1 passed")
    } else {
        println("1 failed")
    }
}