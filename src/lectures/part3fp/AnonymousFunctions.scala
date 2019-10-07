package lectures.part3fp

object AnonymousFunctions extends App {


  val doublerF = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 * 2
  }

  //syntactic sugar for the above method
  val doubler: Int => Int = x => x * 2

  val stringToInt: String => Int = { _.toInt}

  val niceAddr: (Int, Int) => Int = _ + _
  println(niceAddr(3,4))

  println(stringToInt("32"))

  //curried functions
  val superAdder = (x:Int) => (y:Int) => x + y
  println(superAdder(3)(4))

}
