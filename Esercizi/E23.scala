/*  estensione del linguaggio con nuovi costrutti
    Il nome Scala è un acronimo di SCAlable LAnguage, che riflette il design del linguaggio orientato all’estensibilità. 
    In Scala è possibile introdurre nuovi costrutti sfruttando il meccanismo del passaggio dei parametri per nome e la 
    flessibilità nell’invocazione dei metodi senza dover mettere argomenti tra parentesi.

    Questo esercizio richiede di definire un costrutto funzionale Scala profila { E } che valuta l’espressione E e 
    restituisce una coppia (v,t) dove v è il valore ottenuto dalla valutazione di E e t è il tempo in nanosecondi 
    richiesto dalla valutazione di E. Usare il seguente programma di prova:

    import E23._

    object E23Main extends App {
        val (v,t) = profila {
            println("Valutazione espressione...")
            (1 to 1000000).map(_.toLong).sum
        }

        println("Valore prodotto: "+v+" (corretto: 500000500000)")
        println("Tempo richiesto: "+t*1E-9+" secondi")
    }
    Suggerimento: per misurare il tempo, usare System.nanoTime.
*/

object E23 {
    def profila[A](E:A):(A, Long) = {
        val ti = System.nanoTime()
        val v = E
        val tf = System.nanoTime()
        (v, ti-tf)
    }
}