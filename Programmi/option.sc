// metodo find delle collezioni restituisce Option[T]

val res = List(1,3,5,2).find(_>3)
val res2 = List(1,3,5,2).find(_>5)

val k = res match {
    case Some(x) => x 
    case None => println("Non trovato")
}

val y = res2.getOrElse("Non trovato")
println(y)

val z = res2.getOrElse(-1)
println(z)