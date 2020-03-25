
//  classe per numeri razionali
//
//  Scrivere una classe Scala Rational che rappresenta numeri razionali della forma num/den, dove num e den sono interi. 
//  Scrivere la classe in modo che sia possibile eseguire il seguente codice Scala:
//  
//  object E25Main extends App {
//      val r1 = Rational(2, 7)
//      val r2 = Rational(8, 6)
//      val r3 = Rational(4, 14)
//      println(r1+r2)  // stampa 34/21
//      println(r1-r2)  // stampa -22/21
//      println(r1*r2)  // stampa 8/21
//      println(r1/r2)  // stampa 3/14
//      println(r1==r3) // stampa true
//      println(r1!=r3) // stampa false
//      println(r1!=r2) // stampa true
//      println(r1<r2)  // stampa true
//      println(r2<r1)  // stampa false
//  }
//  Suggerimento: calcolare il massimo comun divisore di numeratore e denominatore per riportare la frazione ai minimi 
//  termini (o irriducibile). Ad esempio, 4/14 dovrebbe essere memorizzato in un oggetto Rational come 2/7.

case class Rational(val num:Int,val den:Int) {

    def +(other:Rational) = {
        Rational(this.num*other.den + other.num*this.den, this.den*other.den)
    }
    
    def -(other:Rational) = {
        Rational(this.num*other.den - other.num*this.den, this.den*other.den)
    }

    def *(other:Rational) = {
        Rational(this.num * other.num, this.den * other.den)
    }

    def /(other:Rational) = {
        this*Rational(other.den,other.num)
    }

    def ==(other:Rational) = {
        this.num == other.num && this.den == other.den
    }

    def !=(other:Rational) = {
        !(this == other)
    }

    def <(other:Rational) = {
        (this.num * other.den) < (this.den * other.num)
    }
}

object Rational {
    def mcd(x:Int,y:Int): Int = if (y==0) x.abs else mcd(y, x%y)
    def apply(num:Int, den:Int) = new Rational(num / mcd(num,den), den / mcd(num,den))
}

object E25Main extends App {
    val r1 = Rational(2, 7)
    val r2 = Rational(8, 6)
    val r3 = Rational(4, 14)
    println(r1+r2)  // stampa 34/21
    println(r1-r2)  // stampa -22/21
    println(r1*r2)  // stampa 8/21
    println(r1/r2)  // stampa 3/14
    println(r1==r3) // stampa true
    println(r1!=r3) // stampa false
    println(r1!=r2) // stampa true
    println(r1<r2)  // stampa true
    println(r2<r1)  // stampa false
}