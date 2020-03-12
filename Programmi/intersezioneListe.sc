def inters(a:List[Int], b:List[Int]):List[Int] = {
    if (a == Nil || b == Nil) Nil
    else if (b.contains(a.head)) a.head :: inters(a.tail,b)
    else inters(a.tail, b)
}