/* funzioni su liste - verifica ordinamento
    Scrivere un metodo Scala isSorted che, data una lista di interi, 
    verifica se è ordinata in modo non decrescente. Suggerimento: usare il metodo sliding. 
    Elaborare sia una versione ricorsiva che non ricorsiva basata sui metodi funzionali sulle liste.
*/

object E8 extends App {
    def isSorted(l:List[Int]):Boolean = {
        if (l.size < 2) true
        else if (l.head > l.tail.head) false
        else isSorted(l.tail) 
    }

    def isSorted2(l:List[Int]):Boolean = {
        l.sliding(2,1).forall(c=>c(0)<=c(1))
    }

    println(isSorted(List(1, 2, 3, 4, 5, 6)))
}