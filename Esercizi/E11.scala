/* funzioni su liste - unione liste
    Scrivere un metodo Scala generico union[T](a:List[T], b:List[T]):List[T] che genera la 
    lista ottenuta come unione delle liste a e b. La lista prodotta non deve contenere duplicati.
*/

object E11 extends App {
    def union[T](a:List[T], b:List[T]):List[T] = {
        (a:::b).distinct
    }

    val l = List(54,6,2,6,12,6,9,3,1,5,32,4,1,7,1,2,6,9)
    println(union(l,l))
    println(union(l,List(1)))
    println(union(l,List(10)))
}