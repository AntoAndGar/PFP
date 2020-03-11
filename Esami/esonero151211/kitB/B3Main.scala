object B3Main extends App {
    val t:Tree = T(T(E(),5,T(E(),7,E())),10,T(E(),15,T(E(),17,E())))

    val p1:(Int,Int) = t.min               /*    10     */
    println(p1+" [corretto: (2,5)]")       /*   /  \    */
                                           /*  5   15   */
    val p2:(Int,Int) = E().min             /*   \    \  */
    println(p2+" [corretto: (0,0)]")       /*    7   17 */

    val p3:(Int,Int) = T(E(),5,E()).min
    println(p3+" [corretto: (1,5)]")
}
