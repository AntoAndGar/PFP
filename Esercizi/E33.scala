// Scrivere un metodo Scala primes che genera uno stream infinito con la successione 
// dei numeri primi: 2, 3, 5, 7, 11, ecc..

// Suggerimento: scomporre il problema in sottoproblemi usando metodi ausiliari.

// Usare il seguente main di prova:

// E33Main.scala:

// object E33Main extends App {
//     val s:LazyList[Int] = E33.primes
//     println("Primi 5 numeri primi: "  + s.take(5) .toList)
//     println("Primi 10 numeri primi: " + s.take(10).toList)
//     println("Primi 20 numeri primi: " + s.take(20).toList)
// }

object E33Main extends App {
    val s:LazyList[Int] = E33.primes
    println("Primi 5 numeri primi: "  + s.take(5) .toList)
    println("Primi 10 numeri primi: " + s.take(10).toList)
    println("Primi 20 numeri primi: " + s.take(20).toList)
}

object E33 {
    def primes:LazyList[Int] = {
        def primeStream(stream: LazyList[Int]): LazyList[Int] ={
            stream.head #:: primeStream(stream.tail.filter(_ % stream.head != 0))
        } 
    2 #:: primeStream(LazyList.from(3,2))
    }
}