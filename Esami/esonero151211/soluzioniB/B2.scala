import scala.language.implicitConversions

object B2 {
    implicit def toMyString(s:String) = MyString(s)
    case class MyString(s:String) {
        def -->(i:Int):String = s match {
            case "" => ""
            case s => (0 until i map(x=>s.head.toString) reduce(_+_)) + (s.tail --> i)
        }
    }
}
