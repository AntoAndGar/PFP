/*  anagrammi
    Scrivere un metodo isAnagramOf(a:String, b:String):Boolean che verifica se a è un anagramma di b, 
    cioè a può essere ottenuto come permutazione delle lettere di b. Il test deve essere case sensitive.

    Suggerimento: usare il metodo sorted applicato alle stringhe.

    Scrivere la soluzione nel file E4.scala e usare il programma di prova E4Main.scala.
*/

object E4 {
    def isAnagramOf(a:String, b:String) = { // completa metodo
        a.sorted == b.sorted
    }
}
