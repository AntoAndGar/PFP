class Point3D(x:Double,y:Double,z:Double) extends Point(x,y) {
    def getZ = z
    override val getDist = Math.sqrt(x*x+y*y+z*z)
    override def toString = super.toString + "|" + z
    override def +(other: Point): Point = other match {
        case q:Point3D => new Point3D(x+q.getX, y+q.getY, z+q.getZ)
    }
    println("Creato oggetto Point3D "+ this)
}