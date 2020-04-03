// Si scriva un metodo Scala def piùFrequente[T](l:Seq[T]):Option[(T,Int)] che, 
// data una sequenza di elementi generici, restituisce un Option che contiene 
// una coppia (x,n), dove x è l’elemento più frequente ed n il suo numero di 
// occorrenze nella sequenza, e None se la sequenza di input è vuota.

// Deve essere possibile eseguire il seguente programma di prova:

// object E31Main extends App {
//     val s1 = Seq(1,2,4,2,1,1,5,2,4,2,5)
//     val t1 = E31.piùFrequente(s1) getOrElse "errore"
//     println(t1 + " (corretto: (2,4))")

//     val s2 = Seq()
//     val t2 = E31.piùFrequente(s2) getOrElse "errore"
//     println(t2 + " (corretto: errore)")

//     val s3 = Vector("uno", "due", "uno")
//     val t3 = E31.piùFrequente(s3) getOrElse "errore"
//     println(t3 + " (corretto: (uno,2))")
// }
// Suggerimento: usare i metodi groupBy e maxBy.

object E31Main extends App {
    val s1 = Seq(1,2,4,2,1,1,5,2,4,2,5)
    val t1 = E31.piùFrequente(s1) getOrElse "errore"
    println(t1 + " (corretto: (2,4))")

    val s2 = Seq()
    val t2 = E31.piùFrequente(s2) getOrElse "errore"
    println(t2 + " (corretto: errore)")

    val s3 = Vector("uno", "due", "uno")
    val t3 = E31.piùFrequente(s3) getOrElse "errore"
    println(t3 + " (corretto: (uno,2))")
}

object E31 {
    def piùFrequente[T](l:Seq[T]):Option[(T,Int)] = {
        if(l.isEmpty) None
        else {
            val t = l.groupBy(identity).maxBy(_._2.size)//.reduce((a,b)=>if(a._2.size > b._2.size) a else b)
           Some((t._1,t._2.size))
        }
    }
}