package com.home.playground.leetcode

/**
 * task - https://leetcode.com/problems/spiral-matrix/description
 */
private class SpiralMatrix {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val list = mutableListOf<Int>()
        var top = 0
        var bottom = matrix.size - 1
        var left = 0
        var right = matrix[0].size - 1

        while (top <= bottom && left <= right) {
            for (i in left..right) {
                list.add(matrix[top][i])
            }
            top++

            for (i in top..bottom) {
                list.add(matrix[i][right])
            }
            right--

            if (top <= bottom) {
                for (i in right downTo left) {
                    list.add(matrix[bottom][i])
                }
                bottom--
            }

            if (left <= right) {
                for (i in bottom downTo top) {
                    list.add(matrix[i][left])
                }
                left++
            }
        }
        return list
    }
}

fun main() {
    test1()
}

private fun test1() {
    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )
    val exclude = listOf(1, 2, 3, 6, 9, 8, 7, 4, 5)
    val output = SpiralMatrix().spiralOrder(matrix)
    if (exclude == output) {
        println("1 passed")
    } else {
        println("1 failed")
    }
}