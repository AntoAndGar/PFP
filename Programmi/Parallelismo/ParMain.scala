
object ParMain extends App {
    val (a,b) =  Par.par {
        "ciao"
    }
    {
        3.14
    }
    println(a)
    println(b)
}