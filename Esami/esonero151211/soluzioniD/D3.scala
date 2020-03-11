object D3 {
    def makeTree(levels:Int) = {
        def aux(levels:Int, i:Int):Tree =
            if (levels < 1) E()
            else T(aux(levels-1, 2*i), i, aux(levels-1, 2*i+1))
        aux(levels, 1)
    }
}

sealed abstract class Tree()

case class E() extends Tree() {
    override def toString = "-"
}

case class T(l:Tree, x:Int, r:Tree) extends Tree() {
    override def toString = "["+l+","+x+","+r+"]"
}
