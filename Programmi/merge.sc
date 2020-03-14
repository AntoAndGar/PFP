def merge(a:List[Int], b:List[Int]):List[Int] = (a,b) match {
    case (Nil, Nil) => Nil
    case (l, Nil) => l
    case (Nil, l) => l
    case (ha::ta, hb::tb) if (ha<hb) => ha :: merge(ta, b)
    case (ha::ta, hb::tb)            => hb :: merge(a, tb)
}