object A2 {
    def makeStr(c:Int=>Char)(n:Int) = 
        0 until n map(c(_)+"") reduce (_+_)
}
