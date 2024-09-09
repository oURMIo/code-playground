package com.home.playground.leetcode

import java.util.Stack

/**
 * task - https://leetcode.com/problems/maximum-depth-of-binary-tree/description
 */
class MaximumDepthOfBinaryTree {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val right = maxDepth(root.right)
        val left = maxDepth(root.left)
        return maxOf(right, left) + 1
    }

    fun maxDepthAI(root: TreeNode?): Int {
        if (root == null) return 0

        var maxDepth = 0
        val stack = Stack<Pair<TreeNode, Int>>()
        stack.push(Pair(root, 1))

        while (stack.isNotEmpty()) {
            val (node, currentDepth) = stack.pop()
            if (node != null) {
                maxDepth = maxOf(maxDepth, currentDepth)
                node.left?.let { stack.push(Pair(it, currentDepth + 1)) }
                node.right?.let { stack.push(Pair(it, currentDepth + 1)) }
            }
        }

        return maxDepth
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}