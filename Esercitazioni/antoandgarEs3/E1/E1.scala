/*  verifica su un albero binario
    Si vuole verificare la proprietà di un albero binario che l’elemento contenuto in ogni suo nodo v 
    sia maggiore o uguale all’elemento nella radice del sottoalbero sinistro di v (se non vuoto) e minore 
    o uguale all’elemento nella radice del sottoalbero destro di v (se non vuoto). Scrivere un metodo 
    treeTest che, dato un albero binario con elementi interi, restituisce true se l’albero soddisfa 
    la proprietà, e false altrimenti.

    Scrivere la soluzione nel file E1.scala e usare il programma di prova E1Main.scala.

    Nota: Per estrarre informazioni sui sottoalberi si suggerisce di usare un match ... case annidato in quello esterno.
*/

sealed abstract class Tree {
    // Inserisci la soluzione qui...
    def treeTest:Boolean = this match {
        case E() => true
        case T(l, e, r) => { 
            val x = l match {
                case E() => true
                case T(l1, e1, r1) => e > e1 
            }
            val y = r match {
                case E() => true
                case T(l1, e1, r1) => e < e1 
            }
        l.treeTest && x && y && r.treeTest
        }  
    }
}

// albero non vuoto
case class T(l:Tree, e:Int, r:Tree) extends Tree 

// albero vuoto
case class E() extends Tree
