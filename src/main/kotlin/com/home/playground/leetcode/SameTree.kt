package com.home.playground.leetcode

/**
 * task - https://leetcode.com/problems/same-tree/description
 */
class SameTree {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        if (p == null || q == null) return false

        val left = isSameTree(p.left, q.left)
        val right = isSameTree(p.right, q.right)
        return left && right && p.`val` == q.`val`
    }

    fun isSameTreeAi(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        if (p == null || q == null) return false
        if (p.`val` != q.`val`) return false

        return isSameTreeAi(p.left, q.left) && isSameTreeAi(p.right, q.right)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}

fun main() {
    test1()
}

private fun test1() {
    val tree1 = SameTree.TreeNode(1)
    tree1.left = SameTree.TreeNode(2)
    tree1.right = SameTree.TreeNode(3)

    val tree2 = SameTree.TreeNode(1)
    tree2.left = SameTree.TreeNode(2)
    tree2.right = SameTree.TreeNode(3)

    if (SameTree().isSameTree(tree1, tree2)) {
        println("1 passed")
    } else {
        println("1 failed")
    }
}