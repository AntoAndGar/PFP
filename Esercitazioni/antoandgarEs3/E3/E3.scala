/*  query su database
    Aggiungi alla classe DB un metodo registiConFilm(p:Film=>Boolean):List[Regista] che estrae 
    tutti i registi che hanno diretto almeno un film con la proprietà p.

    case class Film(id:Int, titolo:String, anno:Int)
    case class Regista(id:Int, nome:String)
    case class DirettoDa(idFilm:Int, idRegista:Int)

    case class DB(film:List[Film], registi:List[Regista], regie:List[DirettoDa]) {
        def registiConFilm(p:Film=>Boolean):List[Regista] = Nil // da completare...
    }
    Nota: Se ritenunto utile, è possibile aggiungere alla classe DB variabili di istanza e metodi privati a piacere.

    Scrivere la soluzione nel file E3.scala e usare il programma di prova E3Main.scala.
*/

case class Film(id:Int, titolo:String, anno:Int)
case class Regista(id:Int, nome:String)
case class DirettoDa(idFilm:Int, idRegista:Int)

case class DB(film:List[Film], registi:List[Regista], regie:List[DirettoDa]) {
    def registiConFilm(p:Film=>Boolean):List[Regista] = { // da completare...
        val filmConP = film.filter(p(_)).map(_.id)
        //val regieConP = regie.map(_.idFilm).intersect(filmConP)
        val idRegisti = regie.filter(dd => filmConP.contains(dd.idFilm)).map(_.idRegista)
        //val registiConP = 
        registi.filter(r => idRegisti.contains(r.id))
    }
}
