// scrivi la soluzione qui...
/*Si scriva un metodo Scala mcd che calcola il massimo comun divisore (MCD) di due numeri interi. Usare la seguente definizione ricorsiva:

MCD(x,y)=x, se y=0
MCD(x,y)=MCD(y, resto della divisione di x per y) altrimenti
Compilare ed eseguire come visto nell’Esercizio 1. Scrivere la soluzione nel file E2.scala in modo simile a quanto fatto negli esercizi precedenti e usare il programma di prova E2Main.scala fornito.
*/

object E2 {
    def mcd(x: Int, y:Int): Int = if (y==0) x else mcd(y, x%y)
}   