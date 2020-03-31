// cifrario di Cesare - metodi implicit

// Il cifrario di Cesare è un antico algoritmo di cifratura che consente nel sostituire ciascuna lettera con la 
// corrispondente lettera a una certa distanza prefissata k>=0 nell’alfabeto. Ad esempio, la cifratura a 
// distanza k = 1 di "zorro" è "apssp". Più precisamente, la funzione di codifica a distanza k del codice 
// ASCII c di un carattere minuscolo dell’alfabeto inglese (26 caratteri) è f(c, k) = 'a' + (c - 'a' + k) MOD 26.

// L’idea viene riportata già da Svetonio in Vite dei Cesari (56, I): “Extant et ad Ciceronem, item ad familiares, 
// id est sic structo litterarum ordine, ut nullum verbum effici posset: quae si qui investigare et persequi velit, 
// quartam elementorum, id est D pro A et perinde reliquas commutet”.

// Definire un metodo Scala def rot(k:Int):String applicabile su stringhe che applica il cifrario di Cesare a 
// distanza k, lasciando invariati i caratteri non alfabetici. Ad esempio, "zero uno due...".rot(1) deve 
// restituire "afsp vop evf...". Si consideri il seguente programma di prova:

// import E28._

// object E28Main extends App {
//     def p(s:String, r:String, k:Int) = 
//         println("\"" + s + "\" -> \"" + s.rot(k)  + "\" (corretto: \""+ r + "\")")
//     val (s1, r1, k1) = ("Zorro", "Apssp", 1)
//     val (s2, r2, k2) = ("Apssp", "Zorro", 26-1)
//     val (s3, r3, k3) = ("Hello World!", "Uryyb Jbeyq!", 13)
//     val (s4, r4, k4) = ("Uryyb Jbeyq!", "Hello World!", 26-13)
//     p(s1, r1, k1)
//     p(s2, r2, k2)
//     p(s3, r3, k3)
//     p(s4, r4, k4)
// }

// Suggerimento: usare il metodo map applicato alle stringhe, in cui è possibile “sostituire” un carattere con 
// un altro. Le operazioni aritmetiche su caratteri lavorano sui loro codici ASCII convertiti a Int. Per riportare 
// i codici ASCII così manipolati di nuovo a carattere si usi toChar.

import scala.language.implicitConversions

case class E28(val s:String) {
    def f(c:Char, k:Int) = {
        if (c.isLower) 'a' + (c - 'a' + k) % 26
        else 'A' + (c - 'A' + k) % 26
    }
    
    def rot(k:Int) = s.map(x=>if (x.isLetter) f(x, k).toChar else x)
}

object E28{
    implicit def strToCifr(s:String) = new E28(s)
}