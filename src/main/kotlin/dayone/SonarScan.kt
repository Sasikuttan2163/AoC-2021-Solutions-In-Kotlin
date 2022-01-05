import myutilities.Utils

fun main() {
    val dataInt = Utils.readFile("depths.txt").map { it.toInt() }
    var prev = 0
    var curr = 0
    var count = 0
    var i = 1

    prev = dataInt[0]
    while (i < dataInt.size) {
        curr = dataInt[i]
        if (curr > prev)
            count++
        prev = curr
        i++
    }
    print(count)
}

