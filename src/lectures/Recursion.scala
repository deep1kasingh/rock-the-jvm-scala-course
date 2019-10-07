package lectures

import scala.math.sqrt
object Recursion extends App {
  def factorial(n: Int): Int = {
    if (n <= 1) 1 else {
      n * factorial(n - 1)
    }
  }
//  println(factorial(10))

  def anotherFactorial(n:Int): BigInt = {
    def auxilliaryFactorailFunction(n: Int, acc: BigInt): BigInt = {
      if (n <= 1) acc else {
        auxilliaryFactorailFunction(n-1, n * acc)
      }
    }

    auxilliaryFactorailFunction(n, 1)
  }

  println(anotherFactorial(20000))

  def  concatenateNTimes(aName: String, n: Int): String = {
    def auxilliaryConcatenateNTimes(aNameAcc:String, n: Int): String = {
      if(n <= 1) aNameAcc else auxilliaryConcatenateNTimes(aNameAcc + " " + aName, n-1)
    }

    auxilliaryConcatenateNTimes(aName, n)
  }

  println(concatenateNTimes("angel", 2000))

  def isPrime(n: Int): Boolean = {
    def isPrimeAuxilliary(t: Int, isTrue: Boolean): Boolean =
      if (!isTrue) false
      else if(t <=1) true
      else isPrimeAuxilliary(t-1, n%t != 0)

    isPrimeAuxilliary(sqrt(n).toInt, true)
  }

  println(isPrime(10))
  println(isPrime(37*23))
  println(isPrime(23))

  def fibonacci(n: Int): Int = {
    def auxilliaryFibonacci(t: Int, acc1: Int, acc2: Int): Int = if(t <= 2) acc2 else  auxilliaryFibonacci(t-1, acc2, acc1 + acc2)

    auxilliaryFibonacci(n, 1, 1)
  }

  println(fibonacci(8))
}
