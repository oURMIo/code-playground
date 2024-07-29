package com.home.playground.leetcode

private class MergeTwoSortedLists {
    fun mergeTwoLists(list1: MutableList<Int>, list2: MutableList<Int>): MutableList<Int> {
        val result = mutableListOf<Int>()
        val storage = mutableListOf<Int>()
        val minListSize = if (list1.size > list2.size) {
            list2.size
        } else {
            list1.size
        }

        for (i in 0..<minListSize) {
            if (storage.isNotEmpty() && result.isNotEmpty()) {
                if (list1[i] > storage.first() || list2[i] > storage.first()) {
                    result.add(storage.first())
                }
            }

            if (list1[i] == list2[i]) {
                result.add(list1[i])
                result.add(list2[i])
            } else if (list1[i] > list2[i]) {
                result.add(list2[i])
                storage.add(list1[i])
            } else {
                result.add(list1[i])
                storage.add(list2[i])
            }
        }
        println("storage:$storage")
        return result
    }
}

fun main() {
    val list1 = mutableListOf(1, 2, 4)
    val list2 = mutableListOf(1, 3, 4)
    println("Merge two lists is:${MergeTwoSortedLists().mergeTwoLists(list1, list2)}")
}