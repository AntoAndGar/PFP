def merge(a:List[Int], b:List[Int]):List[Int] = {
    if (a==Nil) b 
    else if (b==Nil) a
        else if (a.head < b.head) a.head :: merge(a.tail, b)
            else b.head :: merge(a, b.tail)
}

def mergeSort(l: List[Int]):List[Int] = {
    if (l.length < 2) l 
    else {
        val (a,b) = l.splitAt(l.length/2)
        val sx = mergeSort(a)
        val dx = mergeSort(b)
        merge(sx, dx)
    } 
}
