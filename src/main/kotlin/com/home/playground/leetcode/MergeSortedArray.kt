package com.home.playground.leetcode

/**
 * task - https://leetcode.com/problems/merge-sorted-array/description/
 * */
class MergeSortedArray {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var m = m
        var n = n
        var last = m + n - 1
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[last] = nums1[m - 1]
                m--
            } else {
                nums1[last] = nums2[n - 1]
                n--
            }
            last--
        }

        while (n > 0) {
            nums1[last] = nums2[n - 1]
            n--
            last--
        }
    }
}

fun main() {
    val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
    val nums2 = intArrayOf(2, 5, 6)
    val m = 3
    val n = 3
    MergeSortedArray().merge(nums1, m, nums2, n)

    val trueResult = intArrayOf(1, 2, 2, 3, 5, 6)
    for (i in trueResult.indices) {
        if (nums1[i] != trueResult[i]) {
            println("failed")
        }
    }
}