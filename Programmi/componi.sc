def componi(a:Int=>Int, b:Int=>Int): Int=>Int = {
    def comp(x:Int) = a(b(x))
    comp _
}