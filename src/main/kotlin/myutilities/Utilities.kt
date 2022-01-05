package myutilities

import java.nio.file.Files
import java.nio.file.Paths

object Utils {
    fun readFile(fileName: String): List<String> =
        Files.readAllLines(Paths.get(Utils::class.java.getResource(fileName).toURI()))
}