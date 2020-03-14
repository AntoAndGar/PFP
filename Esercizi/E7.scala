/* funzioni su liste - lista occorrenze elemento in una lista
    Scrivere un metodo Scala findIndices che, data una lista generica l e un elemento x, 
    restituisce una lista che contiene gli indici i tali che l(i)==x. Se la lista non contiene x, 
    il metodo restituisce una lista vuota.
*/

object E7 extends App {
    def findIndices[T](l:List[T], x:T): List[Int] = {
        l.zipWithIndex.filter(_._1==x).map(_._2).toList
    }

    println(findIndices(List(2,5,8,2,6,3,8,2,5,2,7,8,2,4), 2))
}