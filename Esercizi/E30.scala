// map su alberi binari - classi
//
// Scrivere un metodo Scala map su alberi binari con elementi interi che, 
// data una funzione f:Int=>Int, restituisca un nuovo albero ottenuto da 
// quello di partenza applicando la funzione f a ogni elemento presente 
// nei nodi dell’albero. Completare il seguente frammento di codice:
// sealed abstract class BinTree {
//     def map(f:Int=>Int):BinTree = E() // completare...
// }
// // albero non vuoto
// case class T(l:BinTree, e:Int, r:BinTree) extends BinTree 
// // albero vuoto
// case class E() extends BinTree
// Deve essere possibile eseguire il seguente programma di prova:
// object E30Main extends App {
//     val t1 = T(E(), 10, E())
//     val t2 = T(E(), 5, E())
//     val t3 = T(t1, 7, t2)
//     val t4 = T(t3, 2, E())
//     val t = t4.map(_*2)
//     println(t + " (corretto: T(T(T(E(),20,E()),14,T(E(),10,E())),4,E()))")
// }

sealed abstract class BinTree {
    def map(f:Int=>Int):BinTree = this match {
        case E() => E()
        case T(l, e, r) => T(l.map(f), f(e), r.map(f))
    }
}

// albero non vuoto
case class T(l:BinTree, e:Int, r:BinTree) extends BinTree 

// albero vuoto
case class E() extends BinTree

object E30Main extends App {
    val t1 = T(E(), 10, E())
    val t2 = T(E(), 5, E())
    val t3 = T(t1, 7, t2)
    val t4 = T(t3, 2, E())
    val t = t4.map(_*2)
    println(t + " (corretto: T(T(T(E(),20,E()),14,T(E(),10,E())),4,E()))")
}