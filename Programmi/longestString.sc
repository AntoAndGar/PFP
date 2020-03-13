def longestString(l:List[String]): String = {
    l.reduce((a,b) => if (a.length>b.length) a else b)
}