package daytwo

import myutilities.Utils

fun main() {
    val data = Utils.readFile("datatwo.txt")
    var aim = 0
    var depth = 0
    var forward = 0

    data.forEach {
        val direction = it.substring(0, it.indexOf(" "))
        val magnitude = it.substring(it.indexOf(" ") + 1).toInt()

        when (direction) {
            "up" -> aim -= magnitude
            "down" -> aim += magnitude
            "forward" -> {
                forward += magnitude
                depth += aim * magnitude
            }
        }
    }
    print("final value " + (depth * forward))
}