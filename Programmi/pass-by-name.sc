def p(x:Int) = { println(x); x}
def f(a:Int, b:Int, c:Boolean) = if (c) a else b

f(p(10), p(20), true) // passaggio per valore

def f2(a: =>Int, b: =>Int, c:Boolean) = if (c) a else b // valutazione di tipo lazy

// =>T non è un valore di tipo T, ma un'espressione che calcola un valore di tipo T

f2(p(10), p(20), true) // passaggio per nome