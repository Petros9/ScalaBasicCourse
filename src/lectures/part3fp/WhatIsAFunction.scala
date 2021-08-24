package lectures.part3fp

object WhatIsAFunction extends App {
  // DREAM: use functions as first class elements
  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  // function types = Function[A, B]

  val stringToIntConverter = new Function[String, Int] {
    override def apply(string: String): Int = string.toInt
  }


  val adder: (Int, Int) => Int = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  // Function types Function2[A, B, R] === (A, B) => R
  // ALL SCALA FUNCTIONS ARE OBJECTS


  val concatenate: (String, String) => String = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }

  val funcInt: Function1[Int, Function1[Int, Int]] = (x: Int) => (y: Int) => x + y

  println(funcInt(3)(4)) // curried function -> gets parameter and returns function which takes another parameters
}
// object scala
class Action {
  def execute(element :Int) :String = {
    if (element > 1) "kot"
    else "pies"
  }
}

trait MyFunction[A, B] {
  def apply(element: A): B
}
