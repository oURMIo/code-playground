package com.home.playground.leetcode

/**
 * task - https://leetcode.com/problems/minimum-size-subarray-sum/description/
 */
class MinimumSizeSubarraySum {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        if (nums.sum() < target) return 0

        var minSize = Int.MAX_VALUE
        for (i in nums.indices) {
            var currentSum = 0
            for (j in i until nums.size) {
                currentSum += nums[j]
                if (currentSum >= target) {
                    minSize = minOf(minSize, j - i + 1)
                    break
                }
            }
        }
        return minSize
    }

    fun minSubArrayLen2(target: Int, nums: IntArray): Int {
        var minLength = Int.MAX_VALUE
        var sum = 0
        var left = 0

        for (right in nums.indices) {
            sum += nums[right]

            while (sum >= target) {
                minLength = minOf(minLength, right - left + 1)
                sum -= nums[left]
                left++
            }
        }

        return if (minLength == Int.MAX_VALUE) 0 else minLength
    }
}


fun main() {
    firstTest()
    secondTest()
    thirdTest()
    fourthTest()
    fifthTest()
}

private fun firstTest() {
    if (MinimumSizeSubarraySum()
            .minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)) == 2
    ) {
        println("1 passed")
    } else {
        println("1 failed")
    }
}

private fun secondTest() {
    if (MinimumSizeSubarraySum()
            .minSubArrayLen(11, intArrayOf(1, 2, 3, 4, 5)) == 3
    ) {
        println("2 passed")
    } else {
        println("2 failed")
    }
}

private fun thirdTest() {
    if (MinimumSizeSubarraySum()
            .minSubArrayLen(15, intArrayOf(1, 2, 3, 4, 5)) == 5
    ) {
        println("3 passed")
    } else {
        println("3 failed")
    }
}

private fun fourthTest() {
    if (MinimumSizeSubarraySum()
            .minSubArrayLen(15, intArrayOf(5, 1, 3, 5, 10, 7, 4, 9, 2, 8)) == 2
    ) {
        println("4 passed")
    } else {
        println("4 failed")
    }
}

private fun fifthTest() {
    if (MinimumSizeSubarraySum()
            .minSubArrayLen(213, intArrayOf(12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12)) == 8
    ) {
        println("5 passed")
    } else {
        println("5 failed")
    }
}