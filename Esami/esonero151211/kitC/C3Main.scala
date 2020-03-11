object C3Main extends App {

    val e  = E()
    val t1 = T(T(T(e,9,e),6,e),1,T(e,5,e))
    val t2 = T(T(T(e,9,e),6,e),1,T(e,5,e))
    val t3 = T(e,10,e)

    val b1:Boolean = t1 == t2
    println(b1+" [corretto: true]")

    val b2:Boolean = e == E()
    println(b2+" [corretto: true]")

    val b3:Boolean = t1 == t3
    println(b3+" [corretto: false]")

    val b4:Boolean = t3 == T(e,10,e)
    println(b4+" [corretto: true]")

    val b5:Boolean = e == t3
    println(b5+" [corretto: false]")
}
