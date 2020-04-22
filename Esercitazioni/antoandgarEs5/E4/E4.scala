// Scrivere nel file E4.scala un metodo piuGiovane che, dato un Vector s di oggetti Studente(id, nome) 
// e un Vector e di oggetti Eta(id, eta), restituisce un Option[String] che vale None se s è vuoto e 
// Some(x), dove x è il nome dello studente più giovane, altrimenti. Si assuma che ogni id contenuto in s 
// sia anche contenuto in e. Gli id sono unici in ciascuna collezione e servono come chiave primaria in s e in e.

// Usare il main di prova nella directory di lavoro E4. Non modificare alcun file tranne E4.scala.

// Scrivi la soluzione qui...

object E4 {
    def piuGiovane(s: Vector[Studente],e: Vector[Eta]): Option[String] = {
        if (s.isEmpty) None
        else Some(s.find(_.id == e.minBy(_.eta).id).get.nome)
    }
}
