package com.home.playground.leetcode

/**
 * task - https://leetcode.com/problems/valid-sudoku/description
 */
private class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        for (i in 0 until 9) {
            val row = mutableListOf<Char>()
            val col = mutableListOf<Char>()
            val cub = mutableListOf<Char>()

            for (j in 0 until 9) {
                if (board[i][j].isDigit()) {
                    row.add(board[i][j])
                }
                if (board[j][i].isDigit()) {
                    col.add(board[j][i])
                }
                val rowIndex = 3 * (i / 3) + j / 3
                val colIndex = 3 * (i % 3) + j % 3
                if (board[rowIndex][colIndex].isDigit()) {
                    cub.add(board[rowIndex][colIndex])
                }
            }

            if (row.size != row.toSet().size ||
                col.size != col.toSet().size ||
                cub.size != cub.toSet().size
            ) {
                return false
            }
        }
        return true
    }
}

fun main() {
    val validSudoku = ValidSudoku()

    var sudoku =
        arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )
    if (validSudoku.isValidSudoku(sudoku)) {
        println("first passed")
    } else {
        println("first failed")
    }

    sudoku =
        arrayOf(
            charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )
    if (validSudoku.isValidSudoku(sudoku)) {
        println("second failed")
    } else {
        println("second passed")
    }

    sudoku =
        arrayOf(
            charArrayOf('.', '.', '.', '.', '5', '.', '.', '1', '.'),
            charArrayOf('.', '4', '.', '3', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '.', '3', '.', '.', '1'),
            charArrayOf('8', '.', '.', '.', '.', '.', '.', '2', '.'),
            charArrayOf('.', '.', '2', '.', '7', '.', '.', '.', '.'),
            charArrayOf('.', '1', '5', '.', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '.', '2', '.', '.', '.'),
            charArrayOf('.', '2', '.', '9', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '4', '.', '.', '.', '.', '.', '.')
        )
    if (validSudoku.isValidSudoku(sudoku)) {
        println("third failed")
    } else {
        println("third passed")
    }
}