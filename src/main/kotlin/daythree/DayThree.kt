package daythree

import myutilities.Utils

fun main(){
    val data = Utils.readFile("daythree.txt")
    var mostCommon = ""
    for(i in 0 until data[0].length){
        var c0 = 0L
        c0 = data.stream().filter {
            it[i] == '0'
        }.count()
        mostCommon += (if (c0 > data.size / 2) "0" else "1").toString()
    }
    var leastCommon = ""
    mostCommon.forEach {
        leastCommon += if(it == '0') '1' else '0'
    }
    val gamma = mostCommon.toInt(2)
    val epsilon = leastCommon.toInt(2)
    println(gamma * epsilon)
}