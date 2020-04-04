import scala.language.implicitConversions

object MyRed {
    implicit def list2MyRed[T](l:List[T]) = MyRed(l)
}

case class MyRed[T](l:List[T]) {

    def myReduce(f:(T,T)=>T):Option[T] = {
        def aux(m:List[T]):T = {
            if(m.tail.isEmpty) m.head
            else f(aux(m.tail), m.head)
        }

        if(l.isEmpty) None
        else Some(aux(l))
    }
}
