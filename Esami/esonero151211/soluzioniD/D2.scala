object D2 {
    def combineLists(l1:List[String], l2:List[String]):List[String] = (l1,l2) match {
        case (Nil,Nil) => Nil
        case (l1,Nil)  => l1
        case (Nil,l2)  => l2
        case (h1::t1,h2::t2) => h1+h2 :: combineLists(t1,t2)
    }
}
