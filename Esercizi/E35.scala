// Scrivere un metodo Scala myReduce applicabile a liste generiche che replica il 
// funzionamento del metodo reduce, restituendo però un Option che vale None se la 
// lista e vuota, e Some(x) altrimenti, dove x è il risultato della riduzione. 
// L’implementazione deve essere ricorsiva e non deve usare il metodo predefinito 
// reduce o similari (fold ecc.), né costrutti della programmazione imperativa 
// (var, while, ecc.).

// Usare il seguente main di prova:

// MyRedMain.scala:

// import MyRed._

// object MyRedMain extends App {
//     val l = List.range(1,1000)

//     val v1 = l.myReduce(_+_)
//     println("Test 1: "+v1+" (corretto: " + Some(l.reduce(_+_)) + ")")

//     val v2 = List(1).myReduce(_+_)
//     println("Test 2: "+v2+" (corretto: " + Some(List(1).reduce(_+_)) + ")")

//     val v3 = List[Int]().myReduce(_+_)
//     println("Test 3 "+v3+" (corretto: " + None + ")")
// }

import MyRed._

object MyRedMain extends App {
    val l = List.range(1,1000)

    val v1 = l.myReduce(_+_)
    println("Test 1: "+v1+" (corretto: " + Some(l.reduce(_+_)) + ")")

    val v2 = List(1).myReduce(_+_)
    println("Test 2: "+v2+" (corretto: " + Some(List(1).reduce(_+_)) + ")")

    val v3 = List[Int]().myReduce(_+_)
    println("Test 3 "+v3+" (corretto: " + None + ")")
}