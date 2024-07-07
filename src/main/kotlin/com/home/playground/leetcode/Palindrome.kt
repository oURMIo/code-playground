package com.home.playground.leetcode

class Palindrome {
    /**
     * 207 ms
     * 36.87 MB
     * */
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) {
            return false
        } else {
            for (i in 0..<x.toString().length / 2) {
                if (x.toString().toCharArray()[i] !=
                    x.toString().toCharArray()[x.toString().length - 1 - i]
                ) {
                    return false
                }
            }
            return true
        }
    }
}

fun main() {
    val palindrome = Palindrome()

    println(palindrome.isPalindrome(11111))
    println(palindrome.isPalindrome(21112))
    println(palindrome.isPalindrome(23112))

}
