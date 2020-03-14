/* funzioni su liste - rimozione duplicati
    Scrivere un metodo Scala generico removeDuplicates[T](l:List[T]):List[T] 
    che crea una nuova lista ottenuta da l rimuovendo gli elementi duplicati.
*/

object E10 extends App {
    def removeDuplicates2[T](l:List[T]):List[T] = {
        l.distinct
    }

    def removeDuplicates[T](l:List[T]):List[T] = {
        if (l.size < 2) l
        else if (l.tail.contains(l.head)) removeDuplicates(l.tail)
        else l.head :: removeDuplicates(l.tail) 
    }

    println(removeDuplicates(List(54,6,2,6,12,6,9,3,1,5,32,4,1,7,1,2,6,9)))
    println(removeDuplicates(List(1)))
    println(removeDuplicates2(List(54,6,2,6,12,6,9,3,1,5,32,4,1,7,1,2,6,9)))
}