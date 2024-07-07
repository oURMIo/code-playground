package com.home.playground.leetcode

class RomanInteger {
    fun romanToInt(s: String): Int {
        var number = 0
        val arrayS = s.toCharArray()
        var skipFlag = false
        for (index in s.indices) {
            if (skipFlag) {
                skipFlag = false
                continue
            }
            when (arrayS[index]) {
                'I' -> {
                    try {
                        if (arrayS[index + 1] == 'V') {
                            number += 4
                            skipFlag = true
                        } else if (arrayS[index + 1] == 'X') {
                            number += 9
                            skipFlag = true
                        } else {
                            number += 1
                        }
                    } catch (_: RuntimeException) {
                        number += 1
                    }
                }

                'V' -> {
                    number += 5
                }

                'X' -> {
                    try {
                        if (arrayS[index + 1] == 'L') {
                            number += 40
                            skipFlag = true
                        } else if (arrayS[index + 1] == 'C') {
                            number += 90
                            skipFlag = true
                        } else {
                            number += 10
                        }
                    } catch (_: RuntimeException) {
                        number += 10
                    }
                }

                'L' -> {
                    number += 50
                }

                'C' -> {
                    try {
                        if (arrayS[index + 1] == 'D') {
                            number += 400
                            skipFlag = true
                        } else if (arrayS[index + 1] == 'M') {
                            number += 900
                            skipFlag = true
                        } else {
                            number += 100
                        }
                    } catch (_: RuntimeException) {
                        number += 100
                    }
                }

                'D' -> {
                    number += 500
                }

                'M' -> {
                    number += 1000
                }
            }
        }
        return number
    }
}

class RomanInteger2 {
    fun romanToInt(s: String): Int {
        var number = 0
        val arrayS = s.toCharArray()
        var skipFlag = false
        for (index in s.indices) {
            if (skipFlag) {
                skipFlag = false
                continue
            }
            when (arrayS[index]) {
                'I' -> {
                    try {
                        if (arrayS[index + 1] == 'V') {
                            number += 4
                            skipFlag = true
                        } else if (arrayS[index + 1] == 'X') {
                            number += 9
                            skipFlag = true
                        } else {
                            number += 1
                        }
                    } catch (_: RuntimeException) {
                        number += 1
                    }
                }

                'V' -> number += 5
                'X' -> {
                    try {
                        if (arrayS[index + 1] == 'L') {
                            number += 40
                            skipFlag = true
                        } else if (arrayS[index + 1] == 'C') {
                            number += 90
                            skipFlag = true
                        } else {
                            number += 10
                        }
                    } catch (_: RuntimeException) {
                        number += 10
                    }
                }

                'L' -> number += 50
                'C' -> {
                    try {
                        if (arrayS[index + 1] == 'D') {
                            number += 400
                            skipFlag = true
                        } else if (arrayS[index + 1] == 'M') {
                            number += 900
                            skipFlag = true
                        } else {
                            number += 100
                        }
                    } catch (_: RuntimeException) {
                        number += 100
                    }
                }

                'D' -> number += 500

                'M' -> number += 1000
                else -> println("Got invalid symbol")
            }
        }
        return number
    }
}

fun main() {
    val number = "MCMXCIV"
    val romanInteger = RomanInteger()
    val numberInt = romanInteger.romanToInt(number)
    if (numberInt == 1994) {
        println("passed")
    } else {
        println("false")
    }
}