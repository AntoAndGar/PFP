import scala.language.implicitConversions

object MyReduce {
    implicit  def list2MyList[T](l: List[T]) = MyReduce(l)
}

case class MyReduce[T](l:List[T]) {

    def myReduce(f:(T,T)=>T):Option[T] = {
        def aux(m:List[T]):T = {
            require(!m.isEmpty)
            if(m.tail.isEmpty) m.head 
            else f(aux(m.tail), m.head)
        }
        
        if(l.isEmpty) None 
        else Some(aux(l))
    }
}