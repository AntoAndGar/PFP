import java.io._

object TryCatch extends App {
    val f = try {
        new FileReader("pippo.txt")
    }
    catch {
        case ex: FileNotFoundException => {
            println("Missing file exception")
        }
        case ex: IOException => 
            println("IO Exception")
    }
    println(f)
}