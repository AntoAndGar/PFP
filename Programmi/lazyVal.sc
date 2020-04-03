def p(x: Int) = {println("eval: " + x); x}

println(p(10))

lazy val v = p(10)
println(v)