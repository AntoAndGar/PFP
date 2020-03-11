object X3Main extends App {
    val xor:Expr = (X() || Y()) && !(X() && Y())

    val b0:Boolean = xor(false,false)
    println(b0+" [correct: false]")

    val b1:Boolean = xor(true,false)
    println(b1+"  [correct: true]")

    val b2:Boolean = xor(false,true)
    println(b2+"  [correct: true]")

    val b3:Boolean = xor(true,true)
    println(b3+" [correct: false]")
}
