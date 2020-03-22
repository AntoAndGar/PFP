/*  LSList (funzioni di ordine superiore su liste - sottosequenza più lunga)
    Scrivere un metodo Scala longestSublist[T](p:T=>Boolean)(l:List[T]) che, dato un predicato p e una lista l,
    restituisce la più lunga sottolista di elementi consecutivi di l che soddisfano il predicato p. Se la soluzione 
    non è unica, restituirne una qualsiasi. Ad esempio, longestSublist((_:Int)>0)(List(-4,5,3,6,0,3,4,-1)) deve 
    restituire List(5,3,6), che è la sottolista di elementi consecutivi positivi più lunga.

    Suggerimento: usare il metodo foldLeft, consultando la documentazione della classe List.
*/

object E20 extends App {
    def longestSublist[T](p:T=>Boolean)(l:List[T]): List[T] = {
        // val respProp = l.zipWithIndex.filter(c => p(c._1))
        // respProp.sliding(2,1).toList.partition(c=>c(1)._2._2 - c(0)._2._2 == 1)

        val (curr, max) = l.foldLeft((List[T](), List[T]()))(
            (acc,x) => {
                val (curr,max) = acc
                if (p(x))  (x::curr, max)
                else (List[T](), if (curr.size > max.size) curr else max)
            }
        )
        (if (curr.size > max.size) curr else max).reverse
    }

    println(longestSublist((_:Int)>0)(List(-4,5,3,6,0,3,4,-1)))
    println(longestSublist((_:Int)>0)(List(1,-4,5,3,6,-1,3,4,1,6)))
}