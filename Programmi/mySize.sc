def mySize(l:List[Int]):Int = {
    if(l.isEmpty) 0 else 1+mySize(l.tail)
}

def mySizeGen[T](l:List[T]):Int = {
       if(l.isEmpty) 0 else 1+mySizeGen(l.tail)
}