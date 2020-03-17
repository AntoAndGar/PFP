// Scrivere la soluzione qui...
/*
    Scrivere una funzione sommaFun(f1:Double=>Double, f2:Double=>Double):Double=>Double che 
    restituisce la funzione somma di f1 ed f2. Ad esempio: sommaFun(x=>x, x=>x+1)(2) == 5 
    (ottenuto come: 2+(2+1)), sommaFun(x=>2*x, x=>x+2)(3) == 11 (ottenuto come: (2*3)+(3+2))

    Per compilare da riga di comando usare: scalac E1Main.scala E1.scala. Si noti che sulla 
    riga di comando ci sono entrambi i file che compongono il programma. 
    Noterete la presenza di vari file .class generati dalla compilazione.

    Per eseguire il programma da riga di comando usare: scala E1Main. Si noti che, 
    come in Java, al comando scala viene passato il nome della classe.
*/

object E1 {
    def sommaFun(f1:Double=>Double, f2:Double=>Double):Double=>Double = {
        (x:Double) => f1(x) + f2(x)
    }
}