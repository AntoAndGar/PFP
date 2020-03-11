object X1Main extends App {
    val t1:Int = X1.numEqual(x=>2*x, x=>2*x)(1, 10)
    printf("test1: %d [corretto=10]\n", t1)

    val pf1:(Int,Int)=>Int = X1.numEqual(x=>x*x, x=>2*x)

    val t2:Int = pf1(0, 3)
    printf("test2: %d  [corretto=2]\n", t2)

    val t3:Int = pf1(3, 10)
    printf("test2: %d  [corretto=0]\n", t3)
}
