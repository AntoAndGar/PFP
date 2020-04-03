object PiuFreqMain extends App {
    val s1 = Seq(1,2,4,2,1,1,5,2,4,2,5)
    val t1 = PiuFreq.piuFrequente(s1) getOrElse "errore"
    println("" + t1 + " (corretto: (2,4))")

    val s2 = Seq()
    val t2 = PiuFreq.piuFrequente(s2) getOrElse "errore"
    println("" + t2 + " (corretto: errore)")

    val s3 = Vector("uno", "due", "uno")
    val t3 = PiuFreq.piuFrequente(s3) getOrElse "errore"
    println("" + t3 + " (corretto: (uno,2))")
}