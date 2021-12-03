package daytwo

import Utils

fun main(){
    val data = Utils().readFile("datatwo.txt")
    var depth=0
    var forward=0;
    data.forEach { line->
        run {
            var direction = line.substring(0, line.indexOf(" "))
            var magnitude = line.substring(line.indexOf(" ") + 1).toInt()
            if (direction == "up")
                depth -= magnitude
            else if (direction == "down")
                depth += magnitude
            else
                forward += magnitude
        }
    }
    print("Final position is: "+(forward*depth))

}