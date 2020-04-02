import scala.language.implicitConversions

object MiaLista {
    implicit def list2MiaLista[T](l: List[T]) = MiaLista(l)
}

case class MiaLista[T](l: List[T]) {
    import MiaLista._

    def mioZip[S](m: List[S]): List[(T,S)] = {
        if(l.isEmpty || m.isEmpty) Nil
        else (l.head, m.head) :: l.tail.mioZip(m.tail)
    }

    def mioFilter(p: T=>Boolean): List[T] = {
        if(l.isEmpty) Nil
        else if(p(l.head)) l.head :: l.tail.mioFilter(p)
        else l.tail.mioFilter(p)
    }
}