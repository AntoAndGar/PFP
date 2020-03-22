class Point(x:Double, y:Double) {
    def apply(i:Int) = i match {   //p.apply(i) <-> p(i)
        case 0 => x
        case 1 => y
    } 
}