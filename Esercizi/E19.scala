/*  funzioni su liste - data analytics
    Scrivere un metodo Scala query(studenti:List[(String,Int)], esami:List[(String,String)]):Int che, 
    data una lista studenti di coppie (studente, età) e una lista esami di coppie (studente, esame), 
    restituisce l’età degli studenti che hanno svolto il maggior numero di esami.

    Ad esempio, se:

    studenti = List(("Paola", 21), ("Luca", 22), ("Lucia", 21), ("Matteo",22))
    esami = List(("Paola","PFP"), ("Luca","SC"), ("Paola","DB"), ("Lucia","LTW"), ("Matteo","SO"), ("Lucia","PFP"))
    il risultato deve essere 21, infatti Paola e Lucia, che hanno 21 anni, hanno svolto complessivamente
    4 esami, mentre Luca e Matteo, che hanno 22 anni, ne hanno svolti 2.

    Suggerimento: usare metodi sulle liste (map, distinct, etc.)
*/

object E19 extends App {
    def query(studenti:List[(String,Int)], esami:List[(String,String)]):Int = {
        studenti.map(s=>esami.map(e=>if (s._1 == e._1) (s._2, e._2))).flatten.filter(_!=())
        .map(_ match { case (x:Int,y:String) => Tuple2(x,y)}).groupBy(_._1).toList
        .map(x=>(x._1,x._2.size)).maxBy(_._2)._1
    }

    val studenti = List(("Paola", 21), ("Luca", 22), ("Lucia", 21), ("Matteo",22))
    val esami = List(("Paola","PFP"), ("Luca","SC"), ("Paola","DB"), ("Lucia","LTW"), ("Matteo","SO"), ("Lucia","PFP"))
    println(query(studenti, esami))
}