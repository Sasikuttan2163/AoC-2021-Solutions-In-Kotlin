import java.io.File
fun main(){
    val file = File("src/main/resources/depths.txt")
    val dataInt: ArrayList<Int> = ArrayList<Int>()
    Utils().readFile("depths.txt").forEach{it:String ->
        dataInt.add(it.toInt())
    }
    var prev:Int = 0;
    var curr:Int = 0;
    var count:Int = 0;
    var i=1;
    prev= dataInt[0]
    while(i<dataInt.size){
        curr=dataInt[i]
        if(curr>prev)
            count++
        prev=curr
        i++;
    }
    print(count)
}

