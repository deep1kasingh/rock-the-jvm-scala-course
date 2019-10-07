package lectures.part2oop

object Inheritance extends App {

  class Animal {
    protected def eat() = println("nonmnom")
  }

  class Dog extends Animal {
    override def eat() = println("crunch crunch")
  }


  class Cat extends Animal

  val cat = new Cat
//  cat.eat()
  val dog = new Dog
  dog.eat()
}
