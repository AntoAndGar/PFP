sealed abstract class Tree() {
    def min = aux(0)
    private def aux(m:Int):(Int,Int) = this match {
        case E() => (0,m)
        case T(l,y,_) => {
            val (c,d) = l aux y
            (c+1,d)
        }
    }
}

case class E() extends Tree()
case class T(l:Tree, x:Int, r:Tree) extends Tree()
