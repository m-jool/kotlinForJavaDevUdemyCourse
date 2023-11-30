import java.io.DataInputStream
import java.io.EOFException
import java.io.File
import java.io.FileInputStream

fun main(args: Array<String>) {

    File("testfile.txt").reader()
    // Equivalent to:
    // new InputStreamReader(new FileStreamReader(new File("testfile.txt)), "UTF-8")

    val lines = File("testfile.txt").reader().readLines()
    lines.forEach{println(it)}

    val reader = File("testfile.txt").reader()
    val linesAsString = reader.readText()
    println(linesAsString)
    reader.close()

    // .use{...} for example closes the reader whether an exception is thrown or not
    // .use{...} require calling with an object that implement auto-closable
    // we can use .bufferedReader instead of reader
    val moreLines = File("testfile.txt").reader().use { it.readText() }
    println(moreLines)
    // we also have a readText() extension function for the File class directly, and this one will close the file
    // PS: the "use" and its sister functions are similar to Java's try with resources, there is no direct try-with-resources in Kotlin

    File("testfile.txt").reader().forEachLine { println(it) }

    // useLines -> produces a sequence, so we need to terminate it (i.e something that does not return a sequence )
    File("testfile.txt").reader().useLines { it.forEach { println(it) } }

    // Binary Files
    val bi = DataInputStream(FileInputStream("testfile.bin"))
    var si: String

    try {
        while (true) {
            si = bi.readUTF()
            println(si)
        }
    } catch (e: EOFException){

    }

    // walking the file tree
    // the walk functions are return a sequence of files
    File(".").walkTopDown().forEach { println(it) }
    File(".").walkBottomUp().forEach { println(it) }

    println("-------------")
    File(".").walkTopDown()
        .filter { it.name.endsWith(".kt") }
        .forEach { println(it) }
}