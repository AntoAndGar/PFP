// Scrivere una versione parallela isRotPar del metodo isRot dell’esercizio IsRot usando il 
// metodo par dell’esercizio PCoin. Si parta dalla soluzione proposta per l’esercizio IsRot.

// Usare il seguente programma di prova che richiede il modulo Prof.scala dell’esercizio PCoin:
// PIsRotMain.scala

import scala.language.implicitConversions

case class IsRot[T](val l:Seq[T]) {
    def isRot(m:Seq[T]):Option[Int] = {
        val res = for {
            i <- 0 unitl m.size
            (a,b) = m.splitAt(i)
            if (b ++ a == l)
        } yield i
        if (res.isEmpty) None 
        else Some(res.head)
    }
}

object IsRot {
     implicit def seqToIsRot[T](l:Seq[T]) = IsRot(l)
}