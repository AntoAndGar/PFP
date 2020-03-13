object longestPrefix extends App {
def longestPrefix[T](f:T=>Boolean, l:List[T]): List[T] = {
    if (l.isEmpty || !f(l.head)) Nil
    else l.head :: longestPrefix(f, l.tail)
}

val l = List(2,4,3,1,6,-2,1,-3,9)
longestPrefix((x:Int)=>x>0, l)
longestPrefix((_:Int)>0, l)
}