sealed abstract class Tree() {
    def find(x:Int):(Int,Boolean) = this match {
        case E() => (1,false)
        case T(l,y,r) => 
            if (x==y) (1,true) else 
            if (x<y) {
                val (c,b) = l find x
                (c+1,b)
            }
            else {
                val (c,b) = r find x
                (c+1,b)
            }
    }
}

case class E() extends Tree()
case class T(l:Tree, x:Int, r:Tree) extends Tree()
