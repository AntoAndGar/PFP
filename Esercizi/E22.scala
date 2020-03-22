/*  funzioni su liste - data analytics
    Scrivere un metodo Scala query(studenti:List[(String,Int)], esami:List[(String,String)], e:Int):String che, 
    data una lista studenti di coppie (studente, età), una lista esami di coppie (studente, esame) e un’età e,
    restituisce il nome dell’esame svolto dal maggior numero di studenti di età non superiore a e.

    Ad esempio, se:

    studenti = List(("Paola", 19), ("Luca", 23), ("Lucia", 21), ("Matteo",22), ("Francesca",23))
    esami = List(("Paola","PFP"), ("Luca","SC"), ("Paola","DB"), ("Lucia","SC"), ("Matteo","LTW"), 
            ("Lucia","PFP"), ("Francesca","SC"))
    e = 22
    il risultato deve essere "PFP". Infatti Paola, Lucia e Matteo, che hanno non più di 22 anni, hanno svolto 
    complessivamente: PFP 2 volte, DB 1 volta, LTW 1 volta, e SC 1 volta.
*/

object E22 extends App {
    def query(studenti:List[(String,Int)], esami:List[(String,String)], e:Int):String = {
        studenti.filter(_._2<=e)
                .map(s => esami.map(e => if (s._1 == e._1) Tuple3(s._1, s._2, e._2)).filter(_!=()))
                .flatten
                .map(_ match {case (a,b,c) => (a,b,c)})
                .groupBy(_._3).map(x=>(x._1,x._2.size))
                .maxBy(_._2)._1.toString()
    }

    val studenti = List(("Paola", 19), ("Luca", 23), ("Lucia", 21), ("Matteo",22), ("Francesca",23))
    val esami = List(("Paola","PFP"), ("Luca","SC"), ("Paola","DB"), ("Lucia","SC"), ("Matteo","LTW"), 
            ("Lucia","PFP"), ("Francesca","SC"))
    val e = 22

    println(query(studenti,esami,e))
}