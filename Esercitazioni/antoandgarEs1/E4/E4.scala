// scrivi la soluzione qui...
/*
Scrivere una funzione Scala che, date due funzioni f1:Int=>Int e f2:Int=>Int e un intero n,
verifica che f1 e f2 calcolino lo stesso valore su ogni input compreso tra 0 e n (inclusi). 
La funzione deve restituire un Boolean. Scrivere la soluzione nel file E4.scala in modo simile 
a quanto fatto negli esercizi precedenti e usare il programma di prova E4Main.scala fornito.
*/

object E4 {
    def ugualiIn(f1:Int=>Int, f2:Int=>Int, n:Int):Boolean = if (n<0) true else if (f1(n) != f2(n)) false else ugualiIn(f1, f2, n-1)
}