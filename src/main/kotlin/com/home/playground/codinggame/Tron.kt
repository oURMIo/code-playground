package com.home.playground.codinggame

import java.util.LinkedList
import java.util.Queue
import java.util.Scanner

private const val WIDTH: Int = 30
private const val HEIGHT: Int = 20

private val ARENA = Array(WIDTH) { BooleanArray(HEIGHT) }
private val DIRECTIONS = listOf(
    "UP" to Pair(0, -1),
    "DOWN" to Pair(0, 1),
    "LEFT" to Pair(-1, 0),
    "RIGHT" to Pair(1, 0)
)


fun main() {
    val input = Scanner(System.`in`)

    while (true) {
        val n = input.nextInt()
        val p = input.nextInt()
        var myX = 0
        var myY = 0

        repeat(n) { i ->
            val x0 = input.nextInt() // starting X coordinate of lightcycle (or -1)
            val y0 = input.nextInt() // starting Y coordinate of lightcycle (or -1)
            val x1 = input.nextInt()
            val y1 = input.nextInt()

            if (x1 != -1 && y1 != -1) {
                ARENA[x1][y1] = true
                if (i == p) {
                    myX = x1
                    myY = y1
                }
            }
        }

        val move = getBestMove(myX, myY) ?: "UP"
        println(move)
    }
}

private fun getBestMove(myX: Int, myY: Int): String? {
    return DIRECTIONS.mapNotNull { (dir, delta) ->
        val newX = myX + delta.first
        val newY = myY + delta.second
        if (newX in 0 until WIDTH && newY in 0 until HEIGHT && !ARENA[newX][newY]) {
            val reachableCells = bfs(newX, newY)
            dir to reachableCells
        } else null
    }
        .maxByOrNull { it.second }?.first
}

private fun bfs(startX: Int, startY: Int): Int {
    val visited = Array(WIDTH) { BooleanArray(HEIGHT) }
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(startX to startY)
    visited[startX][startY] = true
    var count = 0

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        count++

        for ((_, delta) in DIRECTIONS) {
            val newX = x + delta.first
            val newY = y + delta.second
            if (newX in 0 until WIDTH && newY in 0 until HEIGHT && !ARENA[newX][newY] && !visited[newX][newY]) {
                visited[newX][newY] = true
                queue.add(newX to newY)
            }
        }
    }
    return count
}
