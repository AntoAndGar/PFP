/* funzioni su liste - elementi consecutivi
    Scrivere un metodo Scala consecutivi che, data una lista generica di n elementi, 
    restituisce la lista di n-1 coppie che contiene tutti gli elementi consecutivi della lista di ingresso.
    Ad esempio, se in ingresso viene dato List(3,6,5,7), il metodo deve produrre List((3,6),(6,5),(5,7)). 
    Se la lista di ingresso contiene meno di due elementi, la funzione deve produrre la lista vuota.
*/

object E9 extends App {
    def consecutivi[T](l: List[T]):List[(T,T)] = {
        if (l.size<2) Nil
        else l.sliding(2,1).map(x=>(x(0),x(1))).toList
    }

    println(consecutivi(List(3,6,5,7)))
    println(consecutivi(List(1)))
}