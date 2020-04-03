def stream:LazyList[Int] = 1 #:: 2 #:: 3 #:: LazyList.empty
stream
stream.take(2).toList
stream.take(4).toList

def pari(n:Int):LazyList[Int] = n #:: pari(n+2)
pari(0).take(10).toList
pari(0).take(1000).toList

def fib(a:Int,b:Int):LazyList[Int] = a #:: fib(b, a+b)
fib(1,1).take(10).toList
fib(1,1).zipWithIndex.map(t=>"F%d=%d".format(t._2+1,t._1)).take(10).toList