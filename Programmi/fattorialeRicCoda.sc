def fact(n: Int):Int = {
    @scala.annotation.tailrec
    def factCoda(n: Int, f:Int):Int = if (n<2) f else factCoda(n-1, n*f)
    factCoda(n, 1)
}