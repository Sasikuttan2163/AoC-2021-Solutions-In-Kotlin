import java.io.File

class Utils {
    fun readFile(fileName: String): ArrayList<String> {
        val x:ArrayList<String> = ArrayList<String>()
        val file = File("src/main/resources/$fileName")
        file.forEachLine {
            x.add(it)
        }
        return x;
    }
}