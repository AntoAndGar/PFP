object A2Main extends App {
    val s1:String = A2.makeStr(i=>if (i%2==0) '/' else '\\')(10)
    println(s1+""" [corretto="/\/\/\/\/\"]""")

    val makeLineStr:Int=>String = A2.makeStr(i=>'-')
    
    val s2 = makeLineStr(5)
    println(s2+""" [corretto="-----"]""")

    val s3 = A2.makeStr(i=>"tes".charAt(i%3))(13)
    println(s3+""" [corretto="testestestest"]""") 
}
