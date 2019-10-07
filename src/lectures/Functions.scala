package lectures

import scala.math.sqrt

object Functions extends App {

  def aFucntion(param1: String, params2: Int): String = {
    param1 + " " + params2
  }

  //calling a function is also an expression
  println(aFucntion("hello", 3))

  def parameterLessFunction() = "hey"

  //paramterless function can be called without parantheses
  println(parameterLessFunction)
  println(parameterLessFunction())
  //above both valid

  //greeting function
  def greeting(name: String, age: Int) = s"Hi, my name is $name and I am $age years old"
  println(greeting("Dave", 12))

  //factorial function
  def factorial(n: Int): Int = if (n <= 1) 1 else n * factorial(n - 1)
  println(factorial(5))

  //fibonacci series
  //f(1) = 1, f(2) = 1; 1, 1, 2, 3, 5, 8,......
  def fibonacci(n: Int): Int = if (n <= 2) 1 else fibonacci(n - 1) + fibonacci(n - 2)
  println(fibonacci(4))
  println(fibonacci(8))

  //test if a number is prime
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = if(t <= 1) true else n%t!=0 && isPrimeUntil(t-1)
    isPrimeUntil(sqrt(n).toInt)
  }

  println(isPrime(100))
  println(isPrime(37*17))
  println(isPrime(23))

}
