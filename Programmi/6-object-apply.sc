class Point(val x:Double,val y:Double) 

object Point {  // companion object
    def apply(x:Double, y:Double) = new Point(x,y)
}
