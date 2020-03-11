object X1 {
    def numEqual(f1:Int=>Int, f2:Int=>Int)(a:Int, b:Int):Int = {
        def numEqualIter(f1:Int=>Int, f2:Int=>Int)(a:Int, b:Int)(n:Int):Int = {
            if (a > b) n
            else if (f1(a)==f2(a)) numEqualIter(f1,f2)(a+1,b)(n+1)
            else numEqualIter(f1,f2)(a+1,b)(n)
        }
        numEqualIter(f1,f2)(a,b)(0)
    }
} 