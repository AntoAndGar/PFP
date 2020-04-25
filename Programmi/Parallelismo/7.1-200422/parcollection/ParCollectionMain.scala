import Prof._

object ParCollectionMain extends App {
    val n = 50000
    def isPrime(n:Int) =
        n>1 && (2 to n/2 /*Math.sqrt(n).toInt*/)
                .forall(n % _ != 0)

    def isEven(n:Int) = n % 2 == 0

    val f = isPrime _

    println("Versione sequenziale...")
    val tseq = profila {
        val r = (1 to n).map(f).count(identity)
        println("Res: "+r)
    }._2

    println("Versione parallela...")
    val tpar = profila {
        val r = (1 to n).par.map(f).count(identity)
        println("Res: "+r)
    }._2

    println("Tempo sequenziale: " + tseq)
    println("Tempo parallelo: "   + tpar)
    println("Speedup: " + tseq/tpar)
}
