import Punto._

object B1Main extends App {
    val p1:Punto = Punto(1,3)
    println(p1 + " [corretto: (1.0,3.0)]")

    val p2:Punto = 10
    println(p2 + " [corretto: (10.0,10.0)]")

    val p3:Punto = p1 + p2
    println(p3 + " [corretto: (11.0,13.0)]")

    val p4:Double = p1 <-> p3
    println(p4 + " [corretto: 14.142135623730951]")
}
