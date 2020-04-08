// Scrivi la soluzione qui...
// Scrivere un metodo scalarProd che, date due vettori rappresentati come sequenze di Double, 
// ne calcola il prodotto scalare. Se i vettori hanno lunghezze diverse, limitare il prodotto 
// scalare al range di indici validi comuni. 
// Ad esempio: scalarProd(Seq(3,4), Seq(2,9,1)) == 3*2 + 4*9 == 42.

// Suggerimento: usare ricorsione oppure i metodi delle collezioni (potrebbero essercene 
// di utili anche fra quelli non visti a lezione).

// Usare il main di prova incluso nel codice dell’esercitazione scaricato.

object E1 {
    def scalarProd(v1:Seq[Double], v2:Seq[Double]):Double = {
        v1.zip(v2).map(c=>c._1*c._2).sum
    }
}