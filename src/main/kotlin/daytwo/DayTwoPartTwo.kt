package daytwo
import Utils

fun main(){
    val data = Utils().readFile("datatwo.txt")
    var aim=0
    var depth = 0
    var forward = 0
    data.forEach{line->run{
        val direction = line.substring(0, line.indexOf(" "))
        val magnitude = line.substring(line.indexOf(" ")+1).toInt()
        when (direction) {
            "up" -> aim-=magnitude
            "down" -> aim+=magnitude
            "forward" -> {
                forward+=magnitude
                depth+=aim*magnitude
            }
        }
    }}
    print("final value "+(depth*forward))
}