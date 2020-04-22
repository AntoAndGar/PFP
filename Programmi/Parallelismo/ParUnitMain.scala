import ParUnit._
import Prof._

object Task {
    def doTask(n:Long) = {
        var i = 0
        while (i<n) {
            if (i%100000000==0)
                println(i)
            i += 1
        }
    }
}

object ParUnitMain extends App {
    val n = 2100000000L
    val tseq = profila {
        Task.doTask(n)
        Task.doTask(n)
    }._2
    println("tempo sequenziale: " + tseq)

    val tpar = profila {
        par {
            Task.doTask(n)
        }
        {
            Task.doTask(n)
        }
    }._2
    println("tempo parallelo: " + tpar)
    println("Speedup: " + (tseq/tpar))
}