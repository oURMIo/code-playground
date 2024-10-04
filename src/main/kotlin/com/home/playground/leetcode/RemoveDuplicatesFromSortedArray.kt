package com.home.playground.leetcode

/**
 * task - https://leetcode.com/problems/remove-duplicates-from-sorted-array/description
 */
private class RemoveDuplicatesFromSortedArray {
    private fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var index = 0
        for (i in 1..<nums.size) {
            if (nums[i] != nums[index]) {
                index++
                nums[index] = nums[i]
            }
        }
        return index + 1
    }

    private fun removeDuplicatesAI(nums: IntArray): Int {
        if (nums.isEmpty()) return 0  // Handle empty array case

        var uniqueIndex = 0  // Points to the last unique element found

        // Loop through the array starting from the second element
        for (i in 1 until nums.size) {
            if (nums[i] != nums[uniqueIndex]) {  // If the current element is different from the last unique element
                uniqueIndex++  // Move the unique index forward
                nums[uniqueIndex] = nums[i]  // Place the unique element in its new position
            }
        }

        return uniqueIndex + 1  // Return the length of the unique portion of the array
    }
}