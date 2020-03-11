import Complex._

object A1Main extends App {
    val c1:Complex = Complex(1,3)
    println(c1 + " [corretto: 1.0+i3.0]")

    val c2:Complex = 10
    println(c2 + " [corretto: 10.0+i0.0]")

    val c3:Complex = c1 + c2
    println(c3 + " [corretto: 11.0+i3.0]")

    val c4:Complex = c1 * c3
    println(c4 + " [corretto: 2.0+i36.0]")
}
