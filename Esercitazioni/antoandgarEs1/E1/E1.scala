// trasformare il seguente medodo in modo che usi la ricorsione di coda

object E1 {
    @scala.annotation.tailrec
    def sumIter(f:Int, n:Int): Int = if (n<1) f else sumIter(f+n,n-1)
    def sum(n:Int): Int = sumIter(0, n)
    //def sum(n:Int):Int = if (n<1) 0 else n+sum(n-1)
}

