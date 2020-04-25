import Par._

object RaceConditionMain extends App {
	var sum = 0
	var i = 0
	while (i<100000000) {
		i += 1
		sum += 1
	}
	i = 0
	while (i<100000000) {
		i += 1
		sum -= 1
	}
	println("Sequential: "+sum)

	sum = 0
	par {
		var i = 0
		while (i<100000000) {
			i += 1
			sum += 1
		}
	}
	{
		var i = 0
		while (i<100000000) {
			i += 1
			sum -= 1
		}
	}
	println("Parallel: "+sum)
}
