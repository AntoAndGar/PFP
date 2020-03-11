import X2._

object X2Main extends App {
    val s1:String = "Leia" ||| "Luke"
    println(s1+""" [corretto="LLeuikae"]""")

    val s2:String = "Obi-Wan" ||| "Kenobi"
    println(s2+""" [corretto="OKbein-oWbain"]""")

    val s3:String = "Anakin" ||| "Skywalker"
    println(s3+""" [corretto="ASnkaykwianlker"]""")
}
