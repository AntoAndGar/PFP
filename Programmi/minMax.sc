def minMax(l:List[Int]): (Int,Int) = (l.min, l.max)

def minMax2(l:List[Int]): (Int,Int) = {
    if (l.length < 2) (l.head,l.head)
    else {
        val (a,b) = minMax2(l.tail)
        (l.head min a, l.head max b)
    }
}