// Scrivere la soluzione qui...
/*
    Una sequenza bitonica è formata da una sequenza non vuota strettamente crescente seguita 
    da una sequenza non vuota strettamente decrescente, ad esempio: List(1,2,5,6,9,4,3,2,0) 
    è bitonica, mentre List(1,2,3,2,3,2,1), List(1,2,3) e List() non lo sono.

    Scrivere una funzione checkBitonic(l:List[Int]):(List[Int],List[Int]) che, data una lista 
    l bitonica, restituisce (inc,dec) tale che inc è il prefisso crescente di l che include 
    l’elemento massimo e dec è il suffisso strettamente decrescente che segue (si ha che 
    inc ::: dec == l). Se invece l non è bitonica, la funzione restituisce (Nil,Nil).

    Scrivere la soluzione nel file E4.scala e usare il programma di prova E4Main.scala.
*/

object E4 {
    def checkBitonic(l:List[Int]):(List[Int],List[Int]) = {
        def isSorted(cmp: (Int,Int)=>Boolean)(l:List[Int]):Boolean = {
            if (l.size < 2) true
            else l.sliding(2,1).forall(x => cmp(x(0),x(1)))
        }
        if (l.isEmpty) (Nil, Nil)
        else {
            val t = l.splitAt(l.indexOf(l.max)+1)
            if (isSorted((a,b)=>a<b)(t._1) && isSorted((a,b)=>a>b)(t._2) && (t._1:::t._2) == l) t
            else (Nil,Nil)
        }
    }
}