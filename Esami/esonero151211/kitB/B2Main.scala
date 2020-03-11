import B2._

object B2Main extends App {
    val s1:String = "Leia" --> 2
    println(s1+""" [corretto="LLeeiiaa"]""")

    val s2:String = "Yoda" --> 3
    println(s2+""" [corretto="YYYooodddaaa"]""")

    val s3:String = "Anakin" --> 1
    println(s3+""" [corretto="Anakin"]""")
}
