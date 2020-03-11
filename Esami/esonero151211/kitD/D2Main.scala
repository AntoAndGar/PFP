object D2Main extends App {
    
    val l1 = List("uno", "due", "tre")
    val l2 = List("1", "2", "3", "4")
    val l3 = List("1", "2")

    val l4:List[String] = D2.combineLists(l1, l2)
    println(l4+" [corretto: List(uno1, due2, tre3, 4)]")

    val l5 = D2.combineLists(l1, l3)
    println(l5+" [corretto: List(uno1, due2, tre)]")

    val l6 = D2.combineLists(l1, Nil)
    println(l6+" [corretto: List(uno, due, tre)]")
}
