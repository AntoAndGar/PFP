/* calcolo della radice quadrata approssimata

    Un semplice algoritmo iterativo basato sul metodo di Newton per calcolare la radice quadrata 
    di un numero x consiste nel partire da una stima iniziale y (es. y=1) e raffinarla 
    successivamente calcolando la media tra y e x/y. Il procedimento termina quando il quadrato 
    della stima è sufficientemente vicino a x(es. inferiore a 0.01). Completare la seguente 
    definizione Scala usando un approccio ricorsivo:

    def sqrt(x:Double) = {
        // completare...
    }
    println("Radice quadrata di 2 ~ "+sqrt(2))

    Suggerimento: scomporre sempre un problema in funzioni più semplici. 
    Questo non peggiora in pratica le prestazioni poiché il compilatore effettua 
    inlining automaticamente, ma migliora molto la leggibilità, l’analisi di 
    correttezza e la manutenibilità del codice. Definire funzioni annidate 
    (es. per il calcolo del valore assoluto, ecc.).
*/

object E17 extends App {
    def sqrt(x:Double) = {
        def mean(a:Double, b:Double):Double = (a+b)/2
        def abs(a:Double):Double = if (a < 0) -a else a
        def pow2(a:Double):Double = a*a
        def sqrtAux(x:Double, y:Double):Double = {
            if (pow2(mean(y,x/y))-x < 0.001) y
            else sqrtAux(x, mean(y,x/y))
        }
        sqrtAux(abs(x), 1)
    }

    println("Radice quadrata di 2 ~ "+sqrt(2))
    println("Radice quadrata di 3 ~ "+sqrt(3))
    println("Radice quadrata di 4 ~ "+sqrt(4))
    println("Radice quadrata di 5 ~ "+sqrt(5))
    println("Radice quadrata di -2 ~ "+sqrt(-2))
    println("Radice quadrata di -3 ~ "+sqrt(-3))
}