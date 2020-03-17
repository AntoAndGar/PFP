// scrivi la soluzione qui...
/* 
Scrivere un metodo Scala somma che, dato come parametro una funzione f:Int=>Int, 
restituisce una funzione che prende come parametri due interi a e b e restituisce la somma di f(x) 
per ogni x compreso tra a e b (estremi inclusi). Scrivere la soluzione nel file E5.scala 
in modo simile a quanto fatto negli esercizi precedenti e usare il programma di prova E5Main.scala fornito.
 */

 object E5 {
    def somma(f:Int=>Int) = {
        def funzioneDaRestituire(a: Int, b: Int):Int = {
            def he(a: Int, b: Int, n: Int): Int = if (b<a) n else he(a, b-1, n+f(b))
            he(a, b, 0)
        }
        funzioneDaRestituire _ 
    }
 }