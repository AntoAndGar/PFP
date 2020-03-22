/*  funzioni su liste di oggetti - data analytics
    Completare il seguente frammento di programma Scala:

    case class Studente(nome:String, età:Int, esami:List[String])
    val q = List(
                    Studente("Marco",   23, List("PFP","SC")), 
                    Studente("Laura",   19, List("SC", "FI1", "PFP")), 
                    Studente("Stefano", 23, List("SC", "FI1")), 
                    Studente("Marco",   25, List("SC", "FI1", "FI2")), 
                    Studente("Paola",   22, List("SC", "PFP"))
                )

    val query1 = // estrarre tutti gli studenti con età compresa tra 20 e 24 anni (inclusi) che hanno sostenuto l'esame di "PFP"
    // stampare i dati degli studenti in query1

    val query2 = // estrarre tutti gli studenti con età strettamente inferiore a 24 anni che hanno sostenuto almeno due esami
    // stampare i dati degli studenti in query2
    Provare diverse soluzioni usando:

    for comprehension (for ... yield)
    metodi delle liste
*/
object E24 extends App {
    case class Studente(nome:String, età:Int, esami:List[String])

    val q = List(
                    Studente("Marco",   23, List("PFP","SC")), 
                    Studente("Laura",   19, List("SC", "FI1", "PFP")), 
                    Studente("Stefano", 23, List("SC", "FI1")), 
                    Studente("Marco",   25, List("SC", "FI1", "FI2")), 
                    Studente("Paola",   22, List("SC", "PFP"))
                )
    
    // metodi delle liste
    // estrarre tutti gli studenti con età compresa tra 20 e 24 anni (inclusi) che hanno sostenuto l'esame di "PFP"
    val query1 = q.filter(s => s.età >= 20 && s.età <= 24 && s.esami.contains("PFP"))
    // stampare i dati degli studenti in query1
    println(query1)

    // estrarre tutti gli studenti con età strettamente inferiore a 24 anni che hanno sostenuto almeno due esami
    val query2 = q.filter(s => s.età < 24 && s.esami.size >= 2)
    // stampare i dati degli studenti in query2
    println(query2)


    //for comprehension (for ... yield)
    // estrarre tutti gli studenti con età compresa tra 20 e 24 anni (inclusi) che hanno sostenuto l'esame di "PFP"
    val query11 = for { 
        s <- q 
        if (s.età >= 20 && s.età <= 24)
        e <- s.esami 
        if (e == "PFP")  
    } yield s
    // stampare i dati degli studenti in query1
    println(query11)

    // estrarre tutti gli studenti con età strettamente inferiore a 24 anni che hanno sostenuto almeno due esami
    val query22 = for {
        s <- q
        if (s.età < 24 && s.esami.size >= 2)  //come si può fare senza usare il size?
    } yield s
    // stampare i dati degli studenti in query2
    println(query22)
}