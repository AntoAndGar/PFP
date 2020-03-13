def myFlatten[T](l:List[List[T]]):List[T] = {
    l.reduce(_:::_)
}