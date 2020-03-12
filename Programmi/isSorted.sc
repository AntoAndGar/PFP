def isSorted(l:List[Int]):Boolean = {
    if (l.length < 2) true
    else if (l.head > l.tail.head) false
    else isSorted(l.tail)
}

//Stefano
def isSorted2(l:List[Int]):Boolean = {
    l.length < 2 || (l.head<l.tail.head && isSorted(l.tail)) 
}

def isSorted3(l:List[Int]):Boolean = {
    if (l.length < 2) true
    else if (l(0) > l(1)) false
    else isSorted(l.tail)
}

def isSorted4(l:List[Int]):Boolean = {
    l.length < 2 || (l(0)<l(1) && isSorted(l.tail)) 
}

def isSorted5(l:List[Int]):Boolean = {
    l.sliding(2,1).forall(x => x(0) <= x(1))
}