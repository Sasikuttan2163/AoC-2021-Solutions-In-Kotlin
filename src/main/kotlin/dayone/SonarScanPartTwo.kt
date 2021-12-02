package dayone

import Utils

fun main(){
    val data:ArrayList<Int> = ArrayList<Int>()
    Utils().readFile("depths.txt").forEach{
        data.add(it.toInt())
    }
    var i=0;
    var count=0;
    while(i<data.size-3){
        if(data[i] < data[i+3])
            count++
        i++;
    }
    println(count)
}