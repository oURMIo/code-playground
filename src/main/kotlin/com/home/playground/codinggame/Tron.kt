package com.home.playground.codinggame

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
            val x0 = input.nextInt()
            val y0 = input.nextInt()
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

        val possibleMoves = DIRECTIONS.filter { (_, delta) ->
            val newX = myX + delta.first
            val newY = myY + delta.second
            newX in 0 until WIDTH && newY in 0 until HEIGHT && !ARENA[newX][newY]
        }

        println(possibleMoves.randomOrNull()?.first ?: "UP")
    }
}
