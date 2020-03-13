def myZip(a:List[Int], b:List[Int]): List[(Int, Int)] = {
    if (a.isEmpty || b.isEmpty) Nil
    else (a.head, b.head) :: myZip(a.tail,b.tail) 
}

def myZipGen[A,B](a:List[A], b:List[B]): List[(A, B)] = {
    if (a.isEmpty || b.isEmpty) Nil
    else (a.head, b.head) :: myZipGen(a.tail,b.tail) 
}