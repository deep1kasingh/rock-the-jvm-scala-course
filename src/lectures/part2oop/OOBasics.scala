package lectures.part2oop

object OOBasics extends App{
  val person = new Person("john", 26)
  println(person.age)
  person.greet()
}

class Person(val name: String, val age: Int) {
  //body

  def greet(name: String = "diana", age: Int = 10) =  println("here i come")
  def greet() = println("there you go")

  def this(name: String) = this(name, 0)
}

class Writer(firstName: String, surname: String, val yearOfBirth: Int) {
  def fullname = s"$firstName $surname"
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  //age of the author at the year of release
  def authorAge: Int = yearOfRelease - author.yearOfBirth

  def isWrittenBy(author: Writer) = author == this.author

  def copy(newYearOfRelease: Int) = new Novel(name, newYearOfRelease, author)
}

class Counter(value: Int) {
  def currCount = value
  def incrementCounter = new Counter(value+1) //immutability -> instances cannot be modified inside the class creation
  def decrementCounter = new Counter(value-1)
  def incrementCounter(incrementVal: Int) = new Counter(value + incrementVal)
  def decrementCounter(decrementVal: Int) = new Counter(value - decrementVal)
}