// operazioni su alberi binari - classi
//
// Scrivere un metodo Scala sum che, dato un albero binario con elementi interi, 
// restituisca la somma degli elementi dell’albero. Completare il seguente frammento di codice:
// sealed abstract class BinTree {
//     def sum = 0 // completare...
// }
// // albero non vuoto
// case class T(l:BinTree, e:Int, r:BinTree) extends BinTree 
// // albero vuoto
// case class E() extends BinTree
// Deve essere possibile eseguire il seguente programma di prova:
// object E29Main extends App {
//     val t1 = T(E(), 10, E())
//     val t2 = T(E(), 5, E())
//     val t3 = T(t1, 7, t2)
//     val t4 = T(t3, 2, E())
//     println(t1.sum + " (corretto: 10)")
//     println(t2.sum + " (corretto: 5)")
//     println(t3.sum + " (corretto: 22)")
//     println(t4.sum + " (corretto: 24)")
// }

sealed abstract class BinTree {
    def sum:Int = this match {
        case E() => 0
        case T(l, e, r) => l.sum + e + r.sum 
    }
}

// albero non vuoto
case class T(l:BinTree, e:Int, r:BinTree) extends BinTree 

// albero vuoto
case class E() extends BinTree

object E29Main extends App {
    val t1 = T(E(), 10, E())
    val t2 = T(E(), 5, E())
    val t3 = T(t1, 7, t2)
    val t4 = T(t3, 2, E())
    println(t1.sum + " (corretto: 10)")
    println(t2.sum + " (corretto: 5)")
    println(t3.sum + " (corretto: 22)")
    println(t4.sum + " (corretto: 24)")
}
