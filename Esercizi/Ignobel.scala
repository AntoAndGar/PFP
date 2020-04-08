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
    def noobSort[T](v: Vector[T])(implicit cmp: T=>Ordered[T]):Vector[T] = {
        v.permutations.filter(_ == v.sorted).toVector(0)
    } 
}

object E3Main extends App {

    var punti = 0

    val v1:Vector[Int] = E3.noobSort(Vector(3,6,9,2,1))
    val c1 = Vector(1,2,3,6,9)
    println("Test 1: "+v1+" (corretto: "+c1+")")
    if (v1 == c1) punti += 1

    val v2 = E3.noobSort(Vector())
    val c2 = Vector()
    println("Test 2: "+v2+" (corretto: "+c2+")")
    if (v2 == c2) punti += 1

    val v3:Vector[String] = E3.noobSort(Vector("uno","due","tre"))
    val c3 = Vector("due","tre","uno")
    println("Test 3: "+v3+" (corretto: "+c3+")")
    if (v3 == c3) punti += 1

    println("Risultato: " + punti + "/3")
}