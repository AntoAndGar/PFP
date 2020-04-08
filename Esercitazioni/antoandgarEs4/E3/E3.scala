// Scrivi la soluzione qui...
// Se esistesse un premio Ignobel per l’informatica, questo si piazzerebbe bene. Scrivere un 
// metodo noobSort che, dato un Vector v di n elementi di tipo generico, restituisce la 
// versione ordinata di v. Per risolvere il problema, generare tutte le permutazioni degli 
// indici da 0 a n-1 e per ciascuna permutazione generare il vettore permutato, verificare 
// se è ordinato ed eventualmente restituirlo.

// Suggerimento: per generare le permutazioni degli indici, usare (0 to n-1).permutations. 
// In alternativa si può permutare direttamente il vettore di input e trovare quella 
// permutazione per cui è ordinato. Si consulti la documentazione delle API Scala per 
// cercare metodi utili.

// Usare il main di prova incluso nel codice dell’esercitazione scaricato.
import scala.language.implicitConversions

object E3 {
    def noobSort[T <% Ordered[T]](v: Vector[T]):Vector[T] = {
        v.permutations.filter(v=>v.sliding(2,1).forall(l=>l(0)<l(1))).toVector(0)
    } 
}