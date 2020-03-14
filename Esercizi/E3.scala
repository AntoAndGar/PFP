/* funzioni su numeri - test di primalità
Scrivere un metodo Scala che verifica se un numero è primo.
*/

object E3 extends App {
    def isPrime(n: Int) = {
        def divisible(m: Int): Boolean = 
            if (m == 1) true
            else if (n % m == 0) false
            else divisible(m-1)
        divisible(Math.sqrt(n).toInt)
    }

    println("13 " + isPrime(13))
    println("19 " + isPrime(19))
    println("20 " + isPrime(20))
    println("720 " + isPrime(720))
    println("123 " + isPrime(123))
}