package lectures.part2oop

object AnonymousClasses extends App {
  abstract class Animal {
    def eat: String
  }

  // anonymous class
  //behind the scenes compiler writes:

  class AnonymousClasses$$anon extends Animal {
    override def eat: String = "chop chop chop"
  }

  val animalClass = new Animal {
    override def eat: String = "popopopopchow"
  }

  println(animalClass)

  class Person(name: String) {
    def printMyName = s"My name is the best $name, how can i help?"
  }

  val meHere = new Person("dips") {
    override def printMyName: String = s"this is awesome isnt it? is it absolutely"
  }

  println(meHere.printMyName)
}
