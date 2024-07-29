package com.home.playground.codewars

private object StockList {
    fun stockSummary(lstOfArt: Array<String>, lstOfCat: Array<String>): String {
        val caterMap = mutableMapOf<String, Int>()
        var caterLast = ""
        var emptyFlag = true
        lstOfCat.forEach { cater ->
            var counter: Int = 0
            lstOfArt.forEach { element ->
                if (element[0].toString() == cater) {
                    val numberPart = element.substringAfter(" ").toInt()
                    counter += numberPart
                }
            }
            caterLast = cater
            if (counter != 0) {
                emptyFlag = false
            }
            caterMap[cater] = counter
        }

        if (emptyFlag) {
            return ""
        }

        val stringBuilder = StringBuilder()

        caterMap.forEach { (k, v) ->
            stringBuilder.append("(${k} : ${v})")
            if (k != caterLast) {
                stringBuilder.append(" - ")
            }
        }

        return stringBuilder.toString()
    }

    fun stockSummaryByChat(lstOfArt: Array<String>, lstOfCat: Array<String>): String {
        val caterMap = lstOfArt
            .filter { it[0].toString() in lstOfCat }
            .groupBy { it[0].toString() }
            .mapValues { (_, v) -> v.sumBy { it.substringAfter(" ").toInt() } }

        return caterMap.entries.joinToString(" - ") { "(${it.key} : ${it.value})" }
    }
}

fun main() {
    var b = arrayOf("BBAR 150", "CDXE 515", "BKWR 250", "BTSQ 890", "DRTY 600")
    var c = arrayOf("A", "B", "C", "D")
    var res = "(A : 0) - (B : 1290) - (C : 515) - (D : 600)"

    println(StockList.stockSummary(b, c))
}