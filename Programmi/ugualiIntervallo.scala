//uguaglianza di funzioni in un intervallo

object ugualiIntervallo extends App {
    def ugualiIntervallo(f1:Int=>Int, f2:Int=>Int, a:Int, b:Int):Boolean = {
        if(a>b) true else if (f1(a)!=f2(a)) false else ugualiIntervallo(f1,f2,a+1,b)
    }

    val f = ugualiIntervallo(2*_,2*_, 0, 100)
    println(f)
    val f1 = ugualiIntervallo(2*_,3*_, 0, 0)
    println(f1)
    val f2 = ugualiIntervallo(2*_,3*_, 0, 1)
    println(f2)
}