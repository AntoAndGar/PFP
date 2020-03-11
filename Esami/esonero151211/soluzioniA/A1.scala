// (a+ib)+(c+id) = (a+c)+i(b+d)
// (a+ib)(c+id) = (ac-bd)+i(bc+ad)

import scala.language.implicitConversions

object Complex {
    implicit def intToComplex(r:Int) = Complex(r,0)
}

case class Complex(r:Double, i:Double) {
    override def toString = r+"+i"+i
    def +(that:Complex) = Complex(this.r+that.r, this.i+that.i)
    def *(that:Complex) = Complex(this.r*that.r-this.i*that.i, this.i*that.r+this.r*that.i)
}
