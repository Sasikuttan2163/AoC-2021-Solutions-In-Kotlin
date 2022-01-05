package daytwo

import myutilities.Utils

fun main() {
    val data = Utils.readFile("datatwo.txt")
    var depth = 0
    var forward = 0

    data.forEach {
        val direction = it.substring(0, it.indexOf(" "))
        val magnitude = it.substring(it.indexOf(" ") + 1).toInt()

        when (direction) {
            "up" -> depth -= magnitude
            "down" -> depth += magnitude
            else -> forward += magnitude
        }
    }
    print("Final position is: " + (forward * depth))

}