// Scrivere un metodo Scala def inter[T](a:List[T], b:List[T]):List[T] che calcola 
// l’intersezione delle liste a e b in tempo O(na+nb), dove na e nb sono le lunghezze 
// delle rispettive liste.

// Suggerimento: usare il metodo toSet per convertire liste in Set. I set forniscono 
// il test di appartenenza alla collezione (contains) in tempo O(1) (in media) usando 
// di default un HashSet.

// Si riporta un main di prova e una versione inefficiente che usa tempo O(na*nb). 
// Compilare il codice insieme al modulo Prof.scala che fornisce il costrutto profila 
// per la misurazione dei tempi.

// E32Main.scala:

// import Prof.profila

// object E32Main extends App {
//     val n = 100000
//     val a = List.range(1,n)
//     val b = List.range(-n,5)
//     println("Intersezione lenta...")
//     val (v1,t1) = profila {
//         E32Slow.inter(a,b)
//     }
//     println("Intersezione veloce...")
//     val (v2,t2) = profila {
//         E32.inter(a,b)
//     }
//     println("Tempo slow: "+t1*1E-9+" sec - Risultato: "+v1)
//     println("Tempo fast: "+t2*1E-9+" sec - Risultato: "+v2)
// }

// object E32Slow {
//     def inter[T](a:List[T], b:List[T]) = {
//         val (min, max) = if (a.size < b.size) (a,b) else (b,a)
//         def aux(l:List[T], res:List[T]):List[T] =
//             l match {
//                 case Nil => res
//                 case h::t => if (min contains h) aux(t,h::res) else aux(t,res)
//             }
//         aux(max, Nil).reverse
//     }
// }
// Prof.scala:

// object Prof {
//     def profila[T](body: =>T):(T,Long) = {
//         val start = System.nanoTime
//         val v = body
//         val t = System.nanoTime - start
//         (v,t)
//     }
// }

import Prof.profila

object E32Main extends App {
    val n = 100000
    val a = List.range(1,n)
    val b = List.range(-n,5)
    println("Intersezione lenta...")
    val (v1,t1) = profila {
        E32Slow.inter(a,b)
    }
    println("Intersezione veloce...")
    val (v2,t2) = profila {
        E32.inter(a,b)
    }
    println("Tempo slow: "+t1*1E-9+" sec - Risultato: "+v1)
    println("Tempo fast: "+t2*1E-9+" sec - Risultato: "+v2)
}

object E32Slow {
    def inter[T](a:List[T], b:List[T]) = {
        val (min, max) = if (a.size < b.size) (a,b) else (b,a)
        def aux(l:List[T], res:List[T]):List[T] =
            l match {
                case Nil => res
                case h::t => if (min contains h) aux(t,h::res) else aux(t,res)
            }
        aux(max, Nil).reverse
    }
}

object E32 {
    def inter[T](a:List[T], b:List[T]):List[T] = {
        a.toSet.intersect(b.toSet).toList
    }
}