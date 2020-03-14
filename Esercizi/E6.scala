/* funzioni di ordine superiore - uguaglianza di funzioni in un intervallo
    Scrivere un metodo Scala equalInRange che, date due funzioni Int=>Int e due interi a e b, 
    verifica se le due funzioni sono uguali nell’intervallo [a,b].
*/

object E6 extends App {
    def equalInRange(f1:Int=>Int, f2:Int=>Int)(a:Int,b:Int):Boolean = {
        if(a>b) true else if (f1(a)!=f2(a)) false else equalInRange(f1,f2)(a+1,b)
    }

    println(equalInRange(identity, identity)(2,7))
    println(equalInRange(identity, _*2)(2,7))
    println(equalInRange(identity, _*2)(0,0))
}