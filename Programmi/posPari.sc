//estrarre elementi con indici pari:
def pospar(l: List[Int]): List[Int] = l.zipWithIndex.filter(x=>x._2 % 2 == 0).map(x=>x._1)