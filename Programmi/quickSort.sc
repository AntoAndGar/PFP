def qsort(l:List[Int]):List[Int] = {
    if (l.length < 2) l 
    else {
        val pivot = l.head
        val minp = l.filter(_ < pivot)
        val magp = l.tail.filter(_ >= pivot)
        val sx = qsort(minp)
        val dx = qsort(magp)
        sx ::: (pivot :: dx)
    }   
}

def qsort2(l:List[Int]):List[Int] = {
    if (l.length < 2) l 
    else qsort2(l.filter(_ < l.head)) ::: 
        (l.head :: 
        qsort2(l.tail.filter(_ >= l.head)))
}

def qsortGen[T](cmp:(T,T)=>Boolean, l:List[T]):List[T] = {
    if (l.length < 2) l 
    else qsortGen(cmp, l.filter(cmp(_, l.head))) ::: l.head :: 
        qsortGen(cmp, l.tail.filter(!cmp(_, l.head)))
}

def qsortGen[T](cmp:(T,T)=>Boolean)(l:List[T]):List[T] = {
    if (l.length < 2) l 
    else qsortGen(cmp)(l.filter(cmp(_, l.head))) ::: l.head :: 
        qsortGen(cmp)(l.tail.filter(!cmp(_, l.head)))
}