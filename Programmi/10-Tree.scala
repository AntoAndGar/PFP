sealed abstract class Tree 

case class T(sx:Tree, root:Int, dx:Tree) extends Tree

case class E() extends Tree

object TreeMain extends App {

    //scrivere un metodo che conta il numero di nodi dell'albero
    def numNodi(t:Tree):Int = t match {
        case E() => 0
        case T(sx, root, dx) => 1+numNodi(sx)+numNodi(dx)
    }

    val t = T(T(E(), 10, E()), 20, E())
    println(numNodi(t))
}