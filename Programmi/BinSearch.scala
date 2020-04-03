object BinSearch {
    def search[T](v:Vector[T], x:T)(implicit cmp:T=>Int):Boolean = {
        def aux(a:Int, b:Int):Boolean = {
            if(a>=b) false
            else {
                val mid = (a+b)/2
                if (v(mid) == x) true
                else if (x <= v(mid)) aux(a, mid)
                else aux(mid+1, b)
            }
        }
        aux(0, v.length)
    }
}