sealed abstract class Tree()
case class E() extends Tree() {
    override def toString = "-"
}
case class T(l:Tree, x:Int, r:Tree) extends Tree() {
    override def toString = "["+l+","+x+","+r+"]"
}
