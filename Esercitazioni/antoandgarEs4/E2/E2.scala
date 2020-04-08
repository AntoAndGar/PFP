// Scrivi la soluzione qui...
// Scrivere un metodo isMappedFrom, applicabile a un Vector v che verifica se un altro 
// Vector m è ottenibile da v applicando la funzione f a ciascun elemento di v:

import scala.language.implicitConversions

object E2 {
    implicit def vector2MyVect[T](v:Vector[T]) = MyVect(v)    
} 

case class MyVect[T](v:Vector[T]) {
    import E2._
    
    def isMappedFrom[S](m:Vector[S], f:T=>S):Boolean = {
        v.map(f(_)) == m
    }
}