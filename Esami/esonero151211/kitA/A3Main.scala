object A3Main extends App {
    val t:Tree = T(T(E(),5,T(E(),7,E())),10,T(E(),15,E()))

    val b1:(Int,Boolean) = t find 7        /*    10    */
    println(b1+" [corretto: (3,true)]")    /*   /  \   */
                                           /*  5   15  */
    val b2 = t find 6                      /*   \      */
    println(b2+" [corretto: (4,false)]")   /*    7     */

    val b3 = t find 15
    println(b3+" [corretto: (2,true)]")

    val b4 = t find 13
    println(b4+" [corretto: (3,false)]")

    val b5 = t find 10
    println(b5+" [corretto: (1,true)]")
}
