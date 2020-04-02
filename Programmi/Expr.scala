sealed abstract class Expr {
    def eval:Int = this match {
        case Const(c:Int) => c
        case Add(a:Expr, b:Expr) => a.eval + b.eval
        case Mul(a:Expr, b:Expr) => a.eval * b.eval
    }
}

case class Const(c:Int) extends Expr
case class Add(a:Expr, b:Expr) extends Expr
case class Mul(a:Expr, b:Expr) extends Expr

object Expr extends App {
    val x = Add(Mul(Const(10),Const(20)),Const(30)).eval
    println(x)
}