import D1._

object D1Main extends App {
    alterna (3) { print("uno") } { print("due ") }
    println(" [corretto: \"unodue unodue unodue \"]")

    alterna (0) { print("uno") } { print("due ") }
    println(" [corretto: \"\"]")
    
    val alternaTre:(=>Unit)=>(=>Unit)=>Unit = alterna(3)
    
    alternaTre { print("A") } { print("B") }
    println(" [corretto: \"ABABAB\"]")
}
