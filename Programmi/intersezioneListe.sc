def inters(a:List[Int], b:List[Int]):List[Int] = {
    if (a == Nil || b == Nil) Nil
    else if (b.contains(a.head)) a.head :: inters(a.tail,b)
    else inters(a.tail, b)
}

def inters[T](l1:List[T], l2:List[T]):List[T] = (l1, l2) match {
    case (_, Nil) => Nil
    case (Nil, _) => Nil
    case (h1::t1, _) if (l2 contains h1) => h1 :: inters(t1, l2)
    case (_::t1, _)                      => inters(t1, l2) 
}