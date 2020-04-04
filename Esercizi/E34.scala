// Scrivere un metodo Scala search che, dato un Vector[T] ordinato, 
// dove sul dominio T è definito un ordinamento totale mediante la 
// relazione <=, e un elemento e di tipo T, restituisce true se e 
// appartiene al vettore, e false altrimenti. Il tempo di esecuzione 
// deve essere O(log n), dove n è la lunghezza del vettore.

// Suggerimento: usare l’algoritmo di ricerca binaria.

// Usare il seguente main di prova:

// object E34Main extends App {
//     val v1 = Vector(1,3,5,6,8,9)
//     val v2 = Vector()

//     val r1:Boolean = E34.search(v1,8)
//     val c1 = true
//     println(r1 + " (corretto: " + c1 + ")")

//     val r2 = E34.search(v1,0)
//     val c2 = false
//     println(r2 + " (corretto: " + c2 + ")")

//     val r3 = E34.search(v1,100)
//     val c3 = false
//     println(r3 + " (corretto: " + c3 + ")")

//     val r4 = E34.search(v1,1)
//     val c4 = true
//     println(r4 + " (corretto: " + c4 + ")")

//     val r5 = E34.search(v2,1)
//     val c5 = false
//     println(r5 + " (corretto: " + c5 + ")")
// }

object E34Main extends App {
    val v1 = Vector(1,3,5,6,8,9)
    val v2 = Vector()

    val r1:Boolean = E34.search(v1,8)
    val c1 = true
    println("" + r1 + " (corretto: " + c1 + ")")

    val r2 = E34.search(v1,0)
    val c2 = false
    println("" + r2 + " (corretto: " + c2 + ")")

    val r3 = E34.search(v1,100)
    val c3 = false
    println("" + r3 + " (corretto: " + c3 + ")")

    val r4 = E34.search(v1,1)
    val c4 = true
    println("" + r4 + " (corretto: " + c4 + ")")

    val r5 = E34.search(v2,1)
    val c5 = false
    println("" + r5 + " (corretto: " + c5 + ")")
}

object E34 {
    def search[T](v:Vector[T], x:T)(implicit cmp: T=>Int):Boolean = {
        def aux(a:Int, b:Int):Boolean = {
            val m = (a+b)/2
            if (a>=b) false
            else if(x==v(m)) true
            else if(x<v(m)) aux(0,m)
            else aux(m+1,v.size)
        }
        aux(0,v.size)
    }
}