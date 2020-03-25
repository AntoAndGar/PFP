/*  un semplice modello 2D
    Scrivere un metodo getModel che, dato un intero n, restituisce una lista di n cerchi di cui l’i-esimo cerchio, 
    per i=1..n, ha x=y=r=0.5*i/n, dove (x,y) sono le coordinate del centro e r è il raggio. L’origine degli assi è 
    nell’angolo inferiore sinistro e il disegno è confinato in uno spazio quadrato di coordinate comprese tra 0.0 
    e 1.0. Usare la classe case class Circle(x:Double, y:Double, r:Double) extends Shape definita in Frame2D.scala, 
    dove x e y sono le coordinate del centro ed r il raggio.

    Scrivere la soluzione nel file E2.scala e compilarla insieme al modulo grafico Frame2D.scala e al programma di prova E2Main.scala.
*/

object E2 {
    def getModel(n:Int):List[Shape] = { // scrivi corpo della funzione
        (1 to n).map(i => Circle(0.5*i/n,0.5*i/n,0.5*i/n)).toList
    }
}
