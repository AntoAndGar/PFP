sealed abstract class Expr() {
    def &&(that:Expr) = And(this,that)
    def ||(that:Expr) = Or(this,that)
    def unary_! = Not(this)
    def apply(x:Boolean, y:Boolean):Boolean = this match {
        case X() => x
        case Y() => y
        case And(e1,e2) => e1(x,y) && e2(x,y)
        case Or(e1,e2) => e1(x,y) || e2(x,y)
        case Not(e) => !e(x,y)
    }
}
case class X() extends Expr()
case class Y() extends Expr()
case class And(e1:Expr, e2:Expr) extends Expr()
case class Or(e1:Expr, e2:Expr) extends Expr()
case class Not(e:Expr) extends Expr()
