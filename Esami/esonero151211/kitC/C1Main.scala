import C1._

object C1Main extends App {
    val x = 5
    ifElse (x<10) { print("if") } { print("else") }
    println(" [corretto: if]")

    ifElse (x>10) { print("if") } { print("else") }
    println(" [corretto: else]")
}
