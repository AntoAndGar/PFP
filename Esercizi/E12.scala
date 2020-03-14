/* uso di map e reduce - stringa più lunga in lista
    Scrivere un metodo Scala max che, data una lista di stringhe, 
    restituisce la lunghezza della stringa più lunga.

    Suggerimento: usare map e reduce
*/

object E12 extends App {
    def max(l: List[String]): Int = {
        l.map(_.length()).reduce((a,b)=> a max b)
    }

    println(max(List("uno","due","tre","quattro","cinque","sei","sette")))
}