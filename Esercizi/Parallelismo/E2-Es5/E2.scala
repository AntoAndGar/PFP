// Scrivere una versione parallela `fibPar` del metodo `fib` definito nel file `Fib.scala` usando
// fork-join in Scala mediante il costrutto `par`.

// Scrivere la soluzione qui...
import Par._
import Fib._

object E2 {
    def fibPar(a:Int, b:Int)(n:Int):Long = {
        if (n < 2) a
        else if (n == 2) b
        else { 
            val (x,y) = par {
                fibPar(a,b)(n-1)
            }
            {
                fibPar(a,b)(n-2)
            }
            x+y 
        }
    }
}
