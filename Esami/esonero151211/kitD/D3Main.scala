object D3Main extends App {

    val t1:Tree = D3.makeTree(2)
    println(t1+" [corretto: [[-,2,-],1,[-,3,-]]]")

    val t2 = D3.makeTree(1)
    println(t2+" [corretto: [-,1,-]]")

    val t3 = D3.makeTree(3)
    println(t3+" [corretto: [[[-,4,-],2,[-,5,-]],1,[[-,6,-],3,[-,7,-]]]]")

    val t4 = D3.makeTree(0)
    println(t4+" [corretto: -]")
}
