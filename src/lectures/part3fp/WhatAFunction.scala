package lectures.part3fp

object WhatAFunction extends App {

  def concatenateTwoStrings: ((String, String) => String) = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  println(concatenateTwoStrings("deepika", "singh"))

  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Int => Int = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder = superAdder(3)
  println(adder(5))
}

