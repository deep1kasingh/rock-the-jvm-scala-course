package exercises

import java.util.NoSuchElementException

//this exercise was wow.

abstract class MyList[+A] {
  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](el: B): MyList[B]

  def printElements: String

  override def toString = "[" + printElements + "]"

  def map[B](transformer: A => B): MyList[B]

  def filter(myPredicate: A => Boolean): MyList[A]

  def flatMap[B](transformer: A => MyList[B]): MyList[B]

  def ++[B >: A](myList1: MyList[B]): MyList[B]
}

//singleton  class
case object Empty extends MyList[Nothing] {

  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](el: B): MyList[B] = new Cons[B](el, Empty)

  override def printElements: String = ""

  override def map[B](transformer: Nothing => B): MyList[B] = Empty

  override def filter(myPredicate: Nothing => Boolean): MyList[Nothing] = Empty

  override def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  override def ++[B >: Nothing](myList1: MyList[B]): MyList[B] = myList1
}

//woww
case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {

  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](el: B): MyList[B] = new Cons(el, this)

  override def printElements: String = {
    if (t.isEmpty) h.toString
    else h + " " + t.printElements
  }

  override def map[B](transformer: A => B): MyList[B] = {
    if (t.isEmpty) new Cons(transformer(h), Empty)
    else new Cons(transformer(h), tail.map(transformer))
  }

  override def filter(myPredicate: A => Boolean): MyList[A] = {
    if (myPredicate(h)) new Cons(h, t.filter(myPredicate))
    else t.filter(myPredicate)
  }

  override def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
    if (t.isEmpty) transformer(h)
    else transformer(h) ++ (tail.flatMap(transformer))
  }

  override def ++[B >: A](myList1: MyList[B]): MyList[B] = {
    new Cons(h, t ++ myList1)
  }
}


object MyListTest extends App {
  val listOfIntegers = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(listOfIntegers.head)

  //polymorphic call
  println(listOfIntegers.toString)

  val listOfStrings = new Cons[String]("1", new Cons[String]("2", new Cons[String]("3", Empty)))
  println(listOfStrings.head)
  println(listOfStrings.toString)

  val newListOfIntegers = listOfIntegers.map(_*2)

  println(newListOfIntegers)

  val newnewListOfIntegers = listOfIntegers.flatMap(i =>  new Cons(i, new Cons(i + 1, Empty)))

  println(newnewListOfIntegers)
}



