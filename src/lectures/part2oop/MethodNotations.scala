package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, val age: Int) {
    def +(talent: String): Person = new Person(s"$name + ($talent)", age)

    def unary_+ : Person = new Person(name, age + 1)

    def learns(sub: String) = s"$name learns $sub"

    def learns: String = learns("Scala")

    def apply() = s"$name"

    def apply(noOfTimes: Int) = s"Mary watched Inception $noOfTimes times"
  }

  val mary = new Person("Mary", 21)
  mary()

  val anotherPerson: Person = mary.+("rockstar")
  anotherPerson()

  println((+mary).age)

  println(mary learns)

  println(mary(2))

}

