package daythree

import myutilities.Utils

fun main(){
    val data = Utils.readFile("daythree.txt")

    val o2 = o2Rating(data)
    val co2 = co2Rating(data)

    println(o2 * co2)
}

fun o2Rating(data: List<String>): Int {
    var i = 0
    var o2 = data
    val length = o2[0].length

    while(i < length && o2.size > 1){
        val c0 = o2.stream().filter {
            it[i] == '0'
        }.count()
        val c1 = o2.size - c0
        val com = if(c1 > c0) '1' else if(c1 == c0) '1' else '0'
        o2 = o2.filter {
            it[i] == com
        }.toList()
        i++
    }

    return o2[0].toInt(2)
}

fun co2Rating(data: List<String>): Int {
    var i = 0
    var co2 = data
    val length = co2[0].length

    while(i < length && co2.size > 1){
        val c0 = co2.stream().filter {
            it[i] == '0'
        }.count()
        val c1 = co2.size - c0
        val com = if(c1 > c0) '0' else if(c1 == c0) '0' else '1'
        co2 = co2.filter {
            it[i] == com
        }.toList()
        i++
    }

    return co2[0].toInt(2)
}