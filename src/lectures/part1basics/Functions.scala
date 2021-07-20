package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " +b
  }

  println(aFunction("hello", 3)) // CALLING A FUNCTION

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction()) // WORKS

  def aRepeatedFunction(aString: String, n: Int): String = {
    if(n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  } // LOOP ARE JUST RECURSIVE FUNCTIONS

  def aFunctionWithSideEffect(aString: String):Unit = println(aString)

  def aBigFunction(n: Int):Int = {
    def aSmallerFunction(a: Int, b:Int):Int = a + b

    aSmallerFunction(n, n - 1)
  } // YOU CAN WRITE FUNCTIONS INSIDE CODEBLOCKS


  def exerciseOne(name: String, age: Int):Unit = {
    println(s"Hi, my name is $name and I am $age years old.")
  }

  def exerciseTwo(number: Int):Int = { // factorial function 1 * 2 * 3 ...
    if(number <= 0) 1
    else exerciseTwo(number - 1) * number
  }

  def exerciseThree(number: Int): Int = { // fibonacci n-element function
    if(number.equals(1) || number.equals(2)) 1
    else exerciseThree(number - 1) + exerciseThree(number - 2)
  }

  def exerciseFour(number: Int):Boolean = { // whether prime
    def isPrimeUntil(i: Int):Boolean = {
      if(i <= 1) true
      else number % i != 0 && isPrimeUntil(i - 1)
    }

    isPrimeUntil(number/2)
  }
  println(exerciseFour(6))
}
