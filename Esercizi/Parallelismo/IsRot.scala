// uguaglianza a meno di rotazioni - operazioni su sequenze
// Scrivere un metodo Scala def isRot(m:Seq[T]):Option[Int] applicabile su un oggetto 
// l di tipo Seq che restituisce Some(n), se m è ottenibile ruotando l di n posizioni
// in avanti, e None altrimenti. Se vi sono più valori possibili di n, restituire il
// più piccolo.

// Usare il seguente main di prova:
// IsRotMain.scala:

import scala.language.implicitConversions

case class IsRot[T](val l:Seq[T]) {
    def isRot(m:Seq[T]):Option[Int] = {
        val i = (0 to l.size).map(i=>(i, l.splitAt(l.size-i).swap))
            .map(c=>(c._1,c._2._1 ++ c._2._2)).filter(_._2==m)
        if(i.isEmpty) None
        else Option(i.head._1)
    }
}

object IsRot {
     implicit def seqToIsRot[T](l:Seq[T]) = IsRot(l)
}