import scala.language.implicitConversions

object X2 {
    implicit def toMyString(s:String) = MyString(s)
    case class MyString(s:String) {
        def |||(t:String) =
            0 until (s.length max t.length) map {
                i => (if (i<s.length) s.charAt(i).toString else "") + 
                     (if (i<t.length) t.charAt(i).toString else "")
            } reduce ((a,b)=>a+b)
    }
}
