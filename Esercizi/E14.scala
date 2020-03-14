/* funzioni su liste - funzione mymap su liste, alla vaccinara
    Scrivere un metodo Scala ricorsivo mymap che, data una lista e una funzione, 
    si comporta come la map predefinita delle liste. Esempio di uso:

    val l = List(3,1,2,4,5)
    println(mymap(l, _+1)) // stampa 4,2,3,5,6
*/

object E14 extends App {
    def mymap[T](l:List[T], f:T=>T):List[T] = {
        if (l.isEmpty) Nil
        else f(l.head) :: mymap(l.tail, f)
    }

    val l = List(3,1,2,4,5)
    println(mymap(l, (_:Int)+1)) // stampa 4,2,3,5,6
}