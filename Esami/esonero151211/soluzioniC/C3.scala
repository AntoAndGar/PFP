sealed abstract class Tree() {
    override def equals(that:Any):Boolean = (this, that) match {
        case (E(),E()) => true
        case (T(l1,x1,r1), T(l2,x2,r2)) => l1==l2 && x1==x2 && r1==r2
        case _ => false
    }
}

case class E() extends Tree()
case class T(l:Tree, x:Int, r:Tree) extends Tree()
