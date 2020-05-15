sealed abstract class Tree {
	def treeTest:Boolean = this match {
		case E() => true
		case T(l, e, r) => l.max <= e && r.min >= e 
	}

	def max:Int = this match {
		case E() => Int.MinValue
		case T(l, e, r) => Math.max(e, r.max) 
	} 

	def min:Int = this match {
		case E() => Int.MaxValue
		case T(l, e, r) => Math.min(e, l.min) 
	} 
}

// albero non vuoto
case class T(l:Tree, e:Int, r:Tree) extends Tree 

// albero vuoto
case class E() extends Tree
