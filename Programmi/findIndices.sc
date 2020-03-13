def findIndices[T](x:T, l:List[T]): List[Int] = {
    l.zipWithIndex.filter(_._1==x).map(_._2)
}