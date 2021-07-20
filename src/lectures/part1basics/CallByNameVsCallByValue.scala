package lectures.part1basics

object CallByNameVsCallByValue extends App {
  def calledByValue(number: Long): Unit = {
    println("by value: " + number)
    println("by value: " + number)
  }

  def calledByName(number: => Long): Unit = { // tells the compiler that the paramether will be called by name
    println("by name: " + number)
    println("by name: " + number)
  }

  calledByValue(System.nanoTime()) // computes nanoTime first and passes to the function
  calledByName(System.nanoTime()) // computes nanoTime as it is needed

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //printFirst(infinite(), 32)
  printFirst(34, infinite()) // infinite is never evaluated

}
