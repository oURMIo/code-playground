package com.home.playground.codgame

import java.util.Scanner

/**
 * H-7 X W-14
 *
 * All your actions on one line, separated by a `;`:
 * * MOVE amount fromX fromY toX toY. Automatic pathfinding.
 * * BUILD x y. Builds a recycler.
 * * SPAWN amount x y. Adds unit to an owned tile.
 * * WAIT. Does nothing.
 * * MESSAGE text. Displays text on your side of the HUD.
 */

data class Field(
    var x: Int,
    var y: Int,
    var isBlue: Boolean,
    var countUnit: Int
)

fun moveUnit(blueX: Int, blueY: Int, redX: Int, redY: Int): String {
    return "MOVE 1 $blueX $blueY $redX $redY;"
}

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val width = input.nextInt()
    val height = input.nextInt()

    var buildX = 0
    var buildY = 0
    var spawnX = 0
    var spawnY = 0

    var enemyX = 0
    var enemyY = 0
    var meX = 0
    var meY = 0

    val fieldsBlue = Array(40) { Field(0, 0, false, 0) }
    val fieldsRed = Array(40) { Field(0, 0, false, 0) }
    var countBlue: Int
    var countRed: Int

    // game loop
    while (true) {
        val myMatter = input.nextInt() // IT's how many gear y have
        val oppMatter = input.nextInt() // IT's how many gear Ename have
        val action = StringBuilder()
        countBlue = 0
        countRed = 0

        var canSpawnFlag = false
        var canBuildFlag = false
        for (y in 0 until height) {
            for (x in 0 until width) {
                val scrapAmount = input.nextInt()
                val owner = input.nextInt() // 1 = me, 0 = foe, -1 = neutral
                val units = input.nextInt()
                val recycler = input.nextInt()
                val canBuild = input.nextInt()
                val canSpawn = input.nextInt()
                val inRangeOfRecycler = input.nextInt()

                /* Find Enemy */
                if (owner == 0) {
                    fieldsRed[countRed] = Field(x, y, false, units)
                    countRed++
                }

                /* Find Me */
                if (owner == 1 && units > 0) {
                    fieldsBlue[countBlue] = Field(x, y, true, units)
                    countBlue++
                }

                if (canSpawn == 1) {
                    spawnX = x
                    spawnY = y
                    canSpawnFlag = true
                }
            }
        }

        if (canSpawnFlag) {
            action.append("SPAWN 1 $spawnX $spawnY;")
        }

        if (canBuildFlag) {
            action.append("BUILD $buildX $buildY;")
        }

        for (i in 0 until countBlue) {
            action.append(moveUnit(fieldsBlue[i].x, fieldsBlue[i].y, fieldsRed[i].x, fieldsRed[i].y))
        }
        println(action)
    }
}