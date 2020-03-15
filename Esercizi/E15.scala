/*  funzioni su liste - minimo e massimo di una lista

    Scrivere un metodo Scala ricorsivo minMax che, data una lista non vuota di interi, 
    restituisce una coppia (min,max), dove min e max sono il minimo e il massimo elemento della lista,
    rispettivamente. Nota: data una coppia t=(a,b), t._1 è il primo elemento, t._2 è il secondo elemento.

    Scrivere inoltre una variante non ricorsiva basata sui metodi standard della classe List visti a lezione.
*/

object E15 extends App {
    def minMax(l:List[Int]):(Int, Int) = {
        if (l.size < 2) (l.head, l.head)
        else {
            val (a,b) = minMax(l.tail)
            (l.head min a, l.head max b)
        }
    }

    def minMax2(l:List[Int]):(Int, Int) = (l.min, l.max)
}