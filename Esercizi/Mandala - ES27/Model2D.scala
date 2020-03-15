import java.awt.Color

object Model2D {

  def getToroidalMandala(numPetals:Int) = {

    // completare costruzione di un modello 2D di un Mandala toroidale
    val raggio = 0.25
    val angolo = 2*Math.PI/numPetals

    BigDecimal(0.0).to(BigDecimal(2.0*Math.PI)).by(BigDecimal(angolo))
    .toList
    .map(x=>Circle(0.5+Math.cos(x.toDouble)*raggio,0.5+Math.sin(x.toDouble)*raggio,raggio))
    // List(Circle(0.5, 0.5, 0.5),
    //     Circle(0.25,0.5,0.25),
    //     Circle(0.75,0.5,0.25),
    //     Circle(0.5,0.75,0.25),
    //     Circle(0.5,0.25,0.25),
    //     Circle(0.5+Math.cos(angolo)*raggio,0.5+Math.sin(angolo)*raggio,raggio))
  }

  def main(args:Array[String]) = {
    println("Displaying Toroidal Mandala...")
    Frame2D.display(Model2D.getToroidalMandala(24), 500, 500)
  }
}