// Scrivi la soluzione qui...
object E4 {
	def piuGiovane(s:Vector[Studente], e:Vector[Eta]):Option[String] = {
		if (s.isEmpty) None
		else {
			val m:Map[Int,Vector[Eta]] = e.groupBy(_.id)
			val x = s.reduce((x,y) => if (m(x.id)(0).eta < m(y.id)(0).eta) x else y)
			Some(x.nome)
		}
	}
}
