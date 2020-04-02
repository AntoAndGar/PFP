sealed abstract class Func {
    def apply(x:Int):Int = this match {
        case X() => x
        case Const(c:Int) => c
        case Add(a:Func, b:Func) => a(x) + b(x)
        case Mul(a:Func, b:Func) => a(x) * b(x)
    }

    override def toString():String = this match {
        case X() => "x"
        case Const(c:Int) => c.toString()
        case Add(a:Func, b:Func) => "(" + a + " + " + b+ ")"
        case Mul(a:Func, b:Func) => "(" + a + " * " + b + ")"
    }

    def deriv: Func = this match {
        case X() => Const(1)
        case Const(c) => Const(0)
        case Add(a, b) => Add(a.deriv, b.deriv)
        case Mul(a, b) => Add(Mul(a.deriv,b), Mul(a, b.deriv))
    }
}

case class X() extends Func
case class Const(c:Int) extends Func
case class Add(a:Func, b:Func) extends Func
case class Mul(a:Func, b:Func) extends Func

object Func extends App {
    val x = Add(X(),Add(Mul(Const(10),Const(20)),Const(30)))
    println(x)
    println("x(10) = " + x(10))
    println(x.deriv)
    println("x.deriv(10) = " + x.deriv(10))
}