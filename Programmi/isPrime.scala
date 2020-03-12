object isPrime extends App {
    def isPrime(n:Int) = {
        def divisibile(m: Int): Boolean =
            if (m==1) true
            else if (n%m == 0) false
            else divisibile(m-1)
        divisibile(Math.sqrt(n).toInt)
    }


    println("13 " + isPrime(13))
    println("19 " + isPrime(19))
    println("20 " + isPrime(20))
    println("720 " + isPrime(720))
    println("123 " + isPrime(123))
}