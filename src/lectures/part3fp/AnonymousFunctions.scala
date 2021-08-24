package lectures.part3fp

object AnonymousFunctions extends App {

  // anonymous functions (LAMBDA)
  val doubler: Int => Int = x => x * 2
  // val doubler = (x: Int) => x * 2 // EQUIVALENT

  // multiple params
  val adder: (Int, Int) => Int =
    (a, b) => a + b

  // no params
  val justDoSomething = () => 3
  // val justDoSomething: () => Int = () => 3

  // BE CAREFUL
  println(justDoSomething) // instance
  println(justDoSomething()) // value

  // curly braces with lambdas
  val stringToInt = {(string: String) =>
    string.toInt
  }

  // MORE syntactic sugar
  val niceIncrementer: Int => Int = (x: Int) => x + 1
  val niceIncrementer2: Int => Int = _ + 1
  val niceAdder: (Int, Int) => Int = _ + _

  /*
  1. funcInt as a lambda
   */
  val funcInt = (x: Int) => (y: Int) => x + y
}
