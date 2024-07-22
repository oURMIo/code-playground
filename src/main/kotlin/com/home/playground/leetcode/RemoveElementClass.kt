package com.home.playground.leetcode

/**
 * task - https://leetcode.com/problems/remove-element/description
 */
class RemoveElementClass {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var k = 0
        for (i in nums.indices) {
            if (nums[i] != `val`) {
                nums[k] = nums[i]
                k++
            }
        }
        return k
    }
}

fun main() {
    val nums = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
    val `val` = 2
    RemoveElementClass().removeElement(nums, `val`)
    val trueResult = intArrayOf(0, 1, 3, 0, 4)
    for (i in trueResult.indices) {
        if (nums[i] != trueResult[i]) {
            println("failed")
        }
    }
}