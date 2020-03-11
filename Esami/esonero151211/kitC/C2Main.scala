object C2Main extends App {
    val l1:List[String] = C2.makeList(i=>if (i<1) "TEST" else "test")(3)
    println(l1+" [corretto: List(TEST, test, test)]")

    val altern01: Int=>List[Int] = C2.makeList(i=>if (i%2==0) 0 else 1)

    val l2 = altern01(5)
    println(l2+" [corretto: List(0, 1, 0, 1, 0)]")
}
