import Profila.profila

object ProfilaMain extends App {
    val n = 30000
    val a = List.range(1,n)
    val b = List.range(-n,5)
    println("Intersezione lenta...")
    val (v1,t1) = profila {
        Slow.inter(a,b)
    }
    println("Intersezione veloce...")
    val (v2,t2) = profila {
        Fast.inter(a,b)
    }
    println("Tempo slow: "+t1*1E-9+" sec - Risultato: "+v1)
    println("Tempo fast: "+t2*1E-9+" sec - Risultato: "+v2)
}

object Slow {
    def inter[T](a:List[T], b:List[T]) = {
        val (min, max) = if (a.size < b.size) (a,b) else (b,a)
        def aux(l:List[T], res:List[T]):List[T] =
            l match {
                case Nil => res
                case h::t => if (min contains h) aux(t,h::res) else aux(t,res)
            }
        aux(max, Nil).reverse
    }
}

object Fast {
    def inter[T](a:List[T], b:List[T]) = {
        a.toSet.intersect(b.toSet)
    }
}