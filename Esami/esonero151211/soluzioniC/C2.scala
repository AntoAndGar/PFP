object C2 {
    def makeList[T](f:Int=>T)(n:Int) = List.range(0,n) map(f(_))
}
