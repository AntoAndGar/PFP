// Scrivere la soluzione qui...
/*
    Scrivere una funzione corrisp[A,B](a:List[A], b:List[B], f:A=>B):Boolean che 
    restituisce true se e solo se per ogni indice i comune a entrambe le liste 
    vale b(i)=f(a(i)). Se una lista è più lunga dell’altra, gli elementi in 
    eccedenza devono essere ignorati.

    Scrivere la soluzione nel file E2.scala e usare il programma di prova E2Main.scala.
*/

object E2 {
    def corrisp[A,B](a:List[A], b:List[B], f:A=>B):Boolean = {
        (a,b) match {
            case (Nil, _) => true
            case (_, Nil) => true
            case (ha::_, hb::_) if (hb != f(ha)) => false
            case (_::ta, _::tb) => corrisp(ta,tb,f)
        }
    }
}