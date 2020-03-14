def varType(x:Any)= x match {
    case i:Int => "$i è un intero"
    case f:Float => "$f è un float"
    case d:Double => "$d è un double"
    case s:String => "$s è una stringa"
    case nonso => "$nonso è di un tipo ignoto" 
}