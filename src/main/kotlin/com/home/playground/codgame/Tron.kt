package com.home.playground.codgame

import java.util.Scanner

private enum class Move {
    RIGHT, LEFT, UP, DOWN, NO
}

private data class Player(
    val number: Int,
    var x: Int,
    var y: Int,
    var lastMove: Move,
) {
    fun setLocation(x: Int, y: Int) {
        this.x = x
        this.y = y
    }
}


fun main(args: Array<String>) {
    val input = Scanner(System.`in`)

    while (true) {
        val playerNumber = input.nextInt()
        val playerMeNumber = input.nextInt()
        val mePlayer = Player(number = playerMeNumber, x = 0, y = 0, lastMove = Move.NO)
        val enemyPlayer = Player(number = 1 - playerMeNumber, x = 0, y = 0, lastMove = Move.NO)
        for (i in 0 until playerNumber) {
            val startX = input.nextInt()
            val startY = input.nextInt()
            val nowX = input.nextInt()
            val nowY = input.nextInt()
            if (i == mePlayer.number) {
                mePlayer.setLocation(nowX, nowY)
            } else {
                enemyPlayer.setLocation(nowX, nowY)
            }
            arena[nowY][nowX] = false
        }
        System.err.println("mePlayer:${mePlayer}")
        System.err.println("enemyPlayer:${enemyPlayer}")

        var move = determineDirection(mePlayer.x, mePlayer.y, enemyPlayer.x, enemyPlayer.y, mePlayer.lastMove)
        if (move == Move.UP && mePlayer.lastMove == Move.DOWN ||
            move == Move.DOWN && mePlayer.lastMove == Move.UP ||
            move == Move.RIGHT && mePlayer.lastMove == Move.LEFT ||
            move == Move.LEFT && mePlayer.lastMove == Move.RIGHT
        ) {
            System.err.println("!!! HAVE ERROR")
            move = Move.LEFT
        }
        mePlayer.lastMove = move
        println(move)
    }
}

private fun determineDirection(meX: Int, meY: Int, enemyX: Int, enemyY: Int, lastMove: Move): Move {
    val verticalDiff = meY.compareTo(enemyY)
    val horizontalDiff = meX.compareTo(enemyX)
    System.err.println("/// lastMove:${lastMove}, verticalDiff:${verticalDiff}, horizontalDiff:${horizontalDiff}")
    return when (lastMove) {
        Move.RIGHT -> when {
            verticalDiff > 0 -> Move.UP
            verticalDiff < 0 -> Move.DOWN
            else -> Move.RIGHT
        }

        Move.LEFT -> when {
            verticalDiff > 0 -> Move.UP
            verticalDiff < 0 -> Move.DOWN
            else -> Move.LEFT
        }

        Move.UP -> when {
            horizontalDiff > 0 -> Move.LEFT
            horizontalDiff < 0 -> Move.RIGHT
            else -> Move.UP
        }

        Move.DOWN -> when {
            horizontalDiff > 0 -> Move.LEFT
            horizontalDiff < 0 -> Move.RIGHT
            else -> Move.DOWN
        }

        Move.NO -> when {
            verticalDiff > 0 -> Move.UP
            verticalDiff < 0 -> Move.DOWN
            horizontalDiff > 0 -> Move.LEFT
            horizontalDiff < 0 -> Move.RIGHT
            else -> Move.LEFT
        }
    }
}

private fun canMove(willX: Int, willY: Int): Boolean {
    return arena[willY][willX]
}

private const val WIDTH_SIZE: Int = 30
private const val HEIGHT_SIZE: Int = 20
private val arena = Array(HEIGHT_SIZE) { Array(WIDTH_SIZE) { true } }
