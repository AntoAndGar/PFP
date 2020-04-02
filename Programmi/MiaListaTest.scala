import MiaLista._

object MiaListaTest extends App {
    val l = List("zero", "uno", "due", "tre", "quattro")
    val m = List(0,1,2)
    val q = l.mioZip(m)
    println(q)
    val t = l.mioFilter(_.length<=3)
    println(t)
}