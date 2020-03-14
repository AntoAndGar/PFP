/* funzioni di ordine superiore
Scrivere un metodo Scala applicaDueVolte che, 
dati come parametri una funzione f:Int=>Int 
e un intero x, calcola f(f(x))
*/

object E1 extends App {
    def applicaDueVolte(f:Int=>Int, x:Int): Int = f(f(x))

    val y = E1.applicaDueVolte(x=>x+1, 10)
    println(y)
}