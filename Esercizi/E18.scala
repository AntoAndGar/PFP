/*  funzioni su liste - filtro su liste per indice

    Scrivere un metodo Scala filterByIndex (ricorsivo o meno) che, data una lista generica 
    e un predicato su indici, restituisce la sottolista ottenuta prendendo solo gli elementi 
    il cui indice soddisfa il predicato dato.

    Esempio di uso:

    filterByIndex(List("zero", "uno", "due", "tre"), i=>i%2==0) // prende solo gli elementi di indice pari
*/

object E18 extends App {
    def filterByIndex[T](l: List[T], p:Int=>Boolean): List[T] = {
        l.zipWithIndex.filter(x=>p(x._2)).map(_._1)
    }

    println(filterByIndex(List("zero", "uno", "due", "tre"), i=>i%2==0))
}