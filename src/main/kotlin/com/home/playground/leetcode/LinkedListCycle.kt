package com.home.playground.leetcode

private class LinkedListCycle {
    fun hasCycle(head: ListNode?): Boolean {
        if (head?.next == null) return false
        var slow = head
        var fast = head.next
        while (fast?.next != null) {
            slow = slow!!.next
            fast = fast.next!!.next
            if (slow == fast) {
                return true
            }
        }
        return false
    }

    fun hasCycle2(head: ListNode?): Boolean {
        if (head?.next == null) return false
        val set = mutableSetOf<ListNode>()
        var cur = head
        while (cur != null) {
            if (set.contains(cur)) {
                return true
            }
            set.add(cur)
            cur = cur.next
        }
        return false
    }
}

class ListNode(var value: Int) {
    var next: ListNode? = null
}

fun main() {
    test1()
    test2()
}

private fun test1() {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node2 // Creates a cycle

    val linkedListCycle = LinkedListCycle()
    if (linkedListCycle.hasCycle(node1)) {
        println("test1 passed")
    } else {
        println("test1 failed")
    }
}

private fun test2() {
    val linkedListCycle = LinkedListCycle()
    if (linkedListCycle.hasCycle(null)) {
        println("test2 failed")
    } else {
        println("test2 passed")
    }
}