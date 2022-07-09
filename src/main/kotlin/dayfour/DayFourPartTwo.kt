package dayfour

import myutilities.Utils
import java.util.*
import kotlin.collections.ArrayList

fun main(){
    val data = Utils.readFile("dayfour.txt")
    val order = data[0].split(",").map { it.toInt() }.toList()

    val matrix = Array(5) { IntArray(5) }
    val matrices = ArrayList<Array<IntArray>>()
    var index = 0

    for (i in 1 until data.size) {
        val line = data[i]
        if(line == "") continue
        val arr = line.chunked(3).stream().mapToInt { it.trim().toInt() }.toArray()
        matrix[index++] = arr
        if(index == 5) {
            index = 0
            matrices.add(matrix.clone())
        }
    }

    val checkList = ArrayList<Int>()
    var markedMatrixIndex = 0
    var wonBoard = BooleanArray(matrices.size) { false }
    first@ for(i in order.indices) {
        val current = order[i]
        checkList.add(current)
        if(i < 5) continue
        for(j in matrices.indices) {
            if(wonBoard[j]) {
                continue
            }
            if(isMarked(matrices[j], checkList)) {
                wonBoard[j] = true
            }
            if(wonBoard.none { !it }) {
                markedMatrixIndex = j
                break@first
            }
        }
    }

    var sum = 0
    for(i in 0 until 5) {
        for( j in 0 until 5){
            val value = matrices[markedMatrixIndex][i][j]
            if(!checkList.contains(value)) {
                sum += value
            }
        }
    }

    println(sum * checkList[checkList.size - 1])
}