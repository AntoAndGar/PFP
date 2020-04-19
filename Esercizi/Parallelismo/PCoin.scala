// numero di resti possibili - parallelismo su liste
// Il metodo fornito def countChange(amount:Int, coins:List[Int]):Int calcola ricorsivamente il numero di modi in 
// cui è possibile dare il resto per un ammontare amount usando il portafogli di monete coins. Si richiede di 
// scrivere una versione parallela def countChangePar(amount:Int, coins:List[Int], maxThreads:Int):Int che prende
// come parametro aggiuntivo il numero massimo di thread che possono essere utilizzati per risolvere il problema.

// PCoin.scala:

// object PCoin {
//     // versione sequenziale (inefficiente, nel caso peggiore richiede 2^n chiamate ricorsive, con n=coins.size) 
//     def countChange(amount:Int, coins:List[Int]):Int =
//         if (amount == 0) 1
//         else if (coins.isEmpty || amount < 0) 0
//         else countChange(amount - coins.head, coins.tail) + countChange(amount, coins.tail)

//     // versione parallela, da completare
//     def countChangePar(amount:Int, coins:List[Int], 
//        maxThreads:Int = Runtime.getRuntime().availableProcessors()):Int = ???
// }
// Si noti che Runtime.getRuntime().availableProcessors() fornisce il numero di core (logici) disponibili ed è 
// usato come valore di default per il numero massimo di thread creati per risolvere il problema.

// Suggerimento: usare il costrutto fornito Par.par per valutare in parallelo due espressioni.

// Usare il seguente programma di prova e i relativi moduli richiesti:

// PCoinMain.scala:

// object PCoinMain extends App {
//     val coins = List(10,100,1,2,5,20,10,50,1,200,100,5,20,10,10,5,1,20,50,1,5,200,2,50,20,1,1,2,5,200,100)
//     val a1 = 899
//     println("Versione sequenziale...")
//     val (v1, t1)   = Prof.profila { PCoin.countChange    (a1, coins) }
//     println("Versione parallela...")
//     val (vp1, tp1) = Prof.profila { PCoin.countChangePar (a1, coins) }
//     println("Test: " + vp1 + " (corretto: " + v1 + " - tempo seq: "+t1*1E-9+" sec - tempo par: "+tp1*1E-9+" sec)")
// }
// Par.scala

// object Par {
//     def par[A,B](a: =>A)(b: =>B):(A,B) = {
//         var resA:Option[A] = None
//         val r = new Runnable {
//             def run() = resA = Some(a)
//         }
//         val t = new Thread(r)
//         t.start()
//         val resB = b
//         t.join()
//         (resA.get, resB)
//     }
// }
// Prof.scala

// object Prof {
//     def profila[T](body: =>T):(T,Long) = {
//         val start = System.nanoTime
//         val v = body                        // il body passato come parametro per nome viene valutato qui
//         val t = System.nanoTime - start
//         (v,t)
//     }
// }

object PCoin {
    // versione sequenziale (inefficiente, nel caso peggiore richiede 2^n chiamate ricorsive, con n=coins.size) 
    def countChange(amount:Int, coins:List[Int]):Int =
        if (amount == 0) 1
        else if (coins.isEmpty || amount < 0) 0
        else countChange(amount - coins.head, coins.tail) + countChange(amount, coins.tail)

    //versione parallela, da completare
    def countChangePar(amount:Int, coins:List[Int], maxThreads:Int = Runtime.getRuntime().availableProcessors()):Int = {
        if (amount == 0) 1
        else if (coins.isEmpty || amount < 0) 0
        else {
            val (a,b) = Par.par (countChange(amount - coins.head, coins.tail))(countChange(amount, coins.tail))
            a+b
        }
    }
    
}