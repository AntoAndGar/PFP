def listLen[T](l:List[T]):Int = l match {
    case Nil => 0
    case h::t => 1+listLen(t) //h==l.head e t==l.tail
}