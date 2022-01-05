package dayone

import myutilities.Utils

fun main() {
    val data = Utils.readFile("depths.txt").map { it.toInt() }

    var i = 0
    var count = 0
    while (i < data.size - 3) {
        if (data[i] < data[i + 3])
            count++
        i++
    }
    println(count)
}