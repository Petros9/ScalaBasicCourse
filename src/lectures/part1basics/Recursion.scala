package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def normalFactorial(number: Int):Int = { // factorial function 1 * 2 * 3 ...
    if(number <= 0) 1
    else {
      println(number + " processing")
      val result = normalFactorial(number - 1) * number
      println(result + " result")
      result
    }
  }

  println(normalFactorial(10)) // case of 5000 -> stack overflow error -> tailrec

  def tailrecFactorial(number: Int):Int = { // factorial function 1 * 2 * 3 ...
    @tailrec // TELLS THE COMPILER THAT'S THIS IS TAIL RECURSIVE
    def factHelper(x: Int, acc: Int):Int = {
      if (x <= 1) acc
      else factHelper(x - 1, x * acc) // TAIL RECURSIVE -> use recursive call as the last expression
    }
    factHelper(number, 1)
  }

  println(tailrecFactorial(5000))

  // IN CASE OF LOOPS USE TAIL RECURSION !!!
    @tailrec
    def exerciseOne(number: Int, name: String, acc:String):String = {
      if(number < 1) acc
      else exerciseOne(number - 1, name, acc + name)
  }
  println(exerciseOne(10, "test", ""))


  def exerciseTwo(number: Int):Boolean = { // whether prime
    @tailrec
    def isPrimeTail(i: Int, isStillPrime:Boolean):Boolean = {
      if(!isStillPrime) return false
      if(i <= 1) true
      else isPrimeTail(i - 1, number % i != 0 && isStillPrime)
    }
    isPrimeTail(number/2, true)
  }

  def exerciseThree(number: Int): Int = { // fibonacci n-element function
    @tailrec
    def fibTailRec(i: Int, acc_1: Int, acc_2: Int): Int = {
      if(i >= number) acc_1
      else fibTailRec(i + 1, acc_1 + acc_2, acc_1)

    }
    if(number <= 2 ) 1
    else fibTailRec(2, 1, 1)
  }
}
