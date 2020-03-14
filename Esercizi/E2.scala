/* funzioni parzialmente applicate
Modificare il metodo applicaDueVolte dell’esercizio 1 usando 
la tecnica della currificazione in modo che sia parzialmente applicabile.
*/

object E2 extends App {
    def applicaDueVolte(f: Int=>Int)(x: Int): Int = f(f(x))

    val incrementaDueVolte = E2.applicaDueVolte(x=>x+1) _
    val y = incrementaDueVolte(10)
    println(y)
}