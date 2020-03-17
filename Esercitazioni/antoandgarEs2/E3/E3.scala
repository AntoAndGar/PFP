// Scrivere la soluzione qui...

/*
    Scrivere una funzione maxPrefisso(l:List[Int], x:Int):Int Scala che restituisce 
    il più grande numero n tale che la somma dei primi n numeri di l è minore o uguale 
    a x. Ad esempio, maxPrefisso(List(1,1,1,1,1),3) == 3, maxPrefisso(List(5,2,4,7),8)==2 
    e maxPrefisso(List(5,2,4,7),4)==0.

    Scrivere la soluzione nel file E3.scala e usare il programma di prova E3Main.scala.
*/

object E3 {
    def maxPrefisso(l:List[Int], x:Int):Int = {
        if (l.head > x) 0
        else 1+maxPrefisso(l.tail, x-l.head)
    }
}