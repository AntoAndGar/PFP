def sum (l:List[Int]):Int = 
    if (l==Nil) 0 else l.head + sum(l.tail)