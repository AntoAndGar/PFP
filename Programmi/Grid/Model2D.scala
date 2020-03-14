import java.awt.Color

object Model2D extends App {

    def getGrid(n:Int) = {

        val RED = new Color(0xFF00FF) // in formato RGB (Red-Blue-Green) o anche Color.RED

		val m = n-1

        // completare costruzione di un modello 2D di una griglia con n 
        // linee verticali ed n linee orizzontali
        (0 to m).toList.map(x=>Line(0, x/m.toDouble, 1, x/m.toDouble, RED)) :::
        (0 to m).toList.map(x=>Line(x/m.toDouble, 0, x/m.toDouble, 1, RED))
    }

//    def main(args:Array[String]) = {
        println("Displaying 20x20 grid...")
        Frame2D.display(getGrid(20), 500, 500)
//    }
}
