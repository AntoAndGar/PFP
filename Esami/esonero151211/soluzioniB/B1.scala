import scala.language.implicitConversions

object Punto {
    implicit def intToPunto(i:Int) = Punto(i,i)
}

case class Punto(x:Double, y:Double) {
    override def toString = "("+x+","+y+")"
    def +(that:Punto) = Punto(this.x+that.x, this.y+that.y)
    def <->(that:Punto) = 
        Math.sqrt((this.x-that.x)*(this.x-that.x)+
                  (this.y-that.y)*(this.y-that.y))
}
