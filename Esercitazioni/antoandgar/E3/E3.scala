// scrivi la soluzione qui...
/*Si scriva un metodo Scala sommaQuadrati che, dati due interi x e y con x<=y, 
calcola la somma dei quadrati dei numeri da x a y, compresi. Scrivere la 
soluzione nel file E3.scala in modo simile a quanto fatto negli esercizi precedenti 
e usare il programma di prova E3Main.scala fornito.*/

object E3 {
    def sumQuad(x:Int, y:Int, f:Int): Int = if (y<x) f else sumQuad(x, y-1, f+(y*y))
    def sommaQuadrati(x:Int, y:Int): Int =  sumQuad(x, y, 0)
}

