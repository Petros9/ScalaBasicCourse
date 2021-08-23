package lectures.part2op

object Exceptions extends App {
  val x: String = null
  // println(x.length)
  // NullPointerException

  // 1. throwing exceptions

  // val aWeirdValue = throw new NullPointerException // Nothing -> can be assigned to strings


  // throwable classes extend the Throwable class.
  // Exception and Error are the major Throwable subtypes

  // 2. catching exception

  def getInt(withExceptions: Boolean): Int = {
    if(withExceptions) throw new RuntimeException("No int for you")
    else 42
  }

  val potentialFail = try {
    getInt(false)
  } catch {
    case e: RuntimeException => 43
    case e:NullPointerException => println("crash")
  } finally {
    // code that will be executed no matter what
    println("finally")
  }

  println(potentialFail)

  // 3. defining own exceptions

  class MyException extends Exception

  val exception = new MyException

  // throw exception

  // OutOfMemmoryError
  // val array = Array.ofDim(Int.MaxValue)

  // SOError
  //def infitine: Int = 1 + infinite
  //val noLimit = infitine
  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator{
    def add(x: Int, y: Int):Int = {
      val result = x + y
      if(x > 0 && y > 0 && result < 0 ) throw new OverflowException
      else if(x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int): Unit = {
      val result = x - y
      if(x > 0 && y < 0 && result < 0) throw new OverflowException
      else if(x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int):Int = {
      val result = x * y
      if(x > 0 && y > 0 && result < 0 ) throw new OverflowException
      else if(x < 0 && y < 0 && result > 0) throw new UnderflowException
      if(x > 0 && y < 0 && result > 0 ) throw new UnderflowException
      else if(x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y:Int) :Int = {
      if(y == 0) throw new MathCalculationException
      else x / y
    }

  }
}
