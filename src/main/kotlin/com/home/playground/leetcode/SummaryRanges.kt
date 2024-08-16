package com.home.playground.leetcode

/**
 * task - https://leetcode.com/problems/summary-ranges/description
 */
private class SummaryRanges {
    fun summaryRanges(nums: IntArray): List<String> {
        if (nums.isEmpty()) return listOf()
        val list = mutableListOf<String>()
        var start = nums[0]
        for (i in 1..<nums.size) {
            if (nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    list.add(start.toString())
                } else {
                    list.add("$start->${nums[i - 1]}")
                }
                start = nums[i]
            }
        }

        if (start == nums.last()) {
            list.add("$start")
        } else {
            list.add("$start->${nums.last()}")
        }

        return list
    }

    fun summaryRangesAI(nums: IntArray): List<String> {
        if (nums.isEmpty()) return emptyList()

        val ranges = ArrayList<String>(nums.size)
        var start = 0

        for (i in 1 until nums.size) {
            if (nums[i] != nums[i - 1] + 1) {
                ranges.addRange(nums, start, i - 1)
                start = i
            }
        }

        // Финализируем последний диапазон
        ranges.addRange(nums, start, nums.size - 1)

        return ranges
    }

    private fun ArrayList<String>.addRange(nums: IntArray, start: Int, end: Int) {
        if (start == end) {
            this.add(nums[start].toString())
        } else {
            this.add("${nums[start]}->${nums[end]}")
        }
    }

}

fun main() {
    test1()
    test2()
}

private fun test1() {
    val outList = SummaryRanges().summaryRanges(intArrayOf(0, 1, 2, 4, 5, 7))
    if (outList == listOf("0->2", "4->5", "7")) {
        println("1 passed")
    } else {
        println("2 failed")
    }
}

private fun test2() {
    val outList = SummaryRanges().summaryRanges(intArrayOf(0, 2, 3, 4, 6, 8, 9))
    if (outList == listOf("0", "2->4", "6", "8->9")) {
        println("1 passed")
    } else {
        println("2 failed")
    }
}
