def somma(a:Int): Int=>Int = {
    def sommaA(b:Int) = a+b //questa è una chiusura
    sommaA _
}

//val sommaTre= somma(3)
//sommaTre(10)