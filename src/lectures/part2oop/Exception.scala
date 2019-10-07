package lectures.part2oop

object Exception extends App {

  //  val array = Array.ofDim(Int.MaxValue)

  def factorial(n: Int): Int = {
    if (n <= 1) 1 else n * factorial(n - 1)
  }

  //  factorial(20000)

  case class Person(name: String, age: Int)

  class OverflowException extends Exception

  class UnderflowException extends Exception

  class MathCalculationException extends Exception

  object PockerCalculator {
    def add(x: Int, y: Int) = {
      val z = x + y
      if (x > 0 && y > 0 && z < 0) throw new OverflowException
      else if (x < 0 && y < 0 && z > 0) throw new UnderflowException
      else z
    }

    def subtract(x: Int, y: Int) = {
      val z = x - y
      if (x > 0 && y < 0 && z < 0) throw new OverflowException
      else if (x < 0 && y > 0 && z > 0) throw new UnderflowException
      else z
    }

    def multiply(x: Int, y: Int) = {
      val z = x * y
      if (((x > 0 && y > 0) || (x < 0 && y < 0)) && z <= 0) throw new OverflowException
      else if (((x < 0 && y > 0) || (x > 0 && y < 0)) && z >= 0) throw new UnderflowException
      else z
    }

    def divide(x: Int, y: Int) = {
      if (y == 0) throw new MathCalculationException
      else x/y
    }
  }

//  PockerCalculator.divide(2,0)
  println(PockerCalculator.multiply(Int.MinValue, 10))
}
