/* funzioni su numeri - numeri di Fibonacci
    Scrivere un metodo Scala che calcola l’n-esimo numero di Fibonacci F(n),
    dove F(1)=1, F(2)=1, F(3)=2, F(4)=3, F(5)=5, ecc.
*/

object E4 extends App {
    def fib(n: Int): Int = 
        if (n <= 2) 1
        else fib(n-1)+fib(n-2)

    (1 to 10).map(x=>println(fib(x)))
}