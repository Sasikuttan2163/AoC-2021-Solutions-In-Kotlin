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

    first@ for(i in order.indices) {
        val current = order[i]
        checkList.add(current)
        if(i < 5) continue
        for(j in matrices.indices) {
            if(isMarked(matrices[j], checkList)) {
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

fun isMarked(matrix: Array<IntArray>, search: ArrayList<Int>): Boolean {
    return hasMarkedRow(matrix, search) || hasMarkedColumn(matrix,search)
}

fun hasMarkedRow(matrix: Array<IntArray>, search: ArrayList<Int>): Boolean {
    for(row in matrix) {
        if(search.containsAll(row.toList())) {
            return true
        }
    }
    return false
}

fun hasMarkedColumn(matrix: Array<IntArray>, search: ArrayList<Int>): Boolean {
    for(i in 0 until 5) {
        val column = ArrayList<Int>()
        for(j in 0 until 5) {
            column.add(matrix[j][i])
        }
        if(search.containsAll(column)) {
            return true
        }
    }
    return false
}