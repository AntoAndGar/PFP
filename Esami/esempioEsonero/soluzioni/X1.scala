object X1 {
    def numEqual(f1:Int=>Int, f2:Int=>Int)(a:Int, b:Int):Int = {
        @scala.annotation.tailrec
        def aux(x:Int, c:Int):Int = 
            if (x>b) c else aux(x+1, if (f1(x)==f2(x)) c+1 else c)
        aux(a,0)
    }
}
