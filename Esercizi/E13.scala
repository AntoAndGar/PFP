/*  funzioni su liste - funzione equal su liste, alla vaccinara
    Scrivere un metodo Scala ricorsivo equal che verifica se due liste 
    di interi sono uguali (uguaglianza profonda).

    Suggerimento: usare head, tail e isEmpty
*/

object E13 extends App {
    def equal(a:List[Int], b:List[Int]): Boolean = {
        if (a.isEmpty && b.isEmpty) true
        else if (a.size != b.size) false
        else if (a.head != b.head) false
        else equal(a.tail, b.tail)
    }

    println(equal(List(1,2,3,4,5), List(1,2,3,4,5)))
    println(equal(List(1,2,3,4,5), List(1,2,3,4,5,6)))
    println(equal(List(1,2,3,4,5), List(1,2,3,4,6)))
}