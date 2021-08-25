package lectures.part4pm

import scala.util.Random

object PatternMatching extends App {

  // switch on steroids

  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "the One"
    case 2 => "double or nothing"
    case _ => "the default answer"
  }

  println(description)

  // 1. Decompose values
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)

  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hi my name is $n and I cannot drink in the US"
    case Person(n, a) => s"Hi my name is $n and I am $a years old"
    case _ => "I don't know who I am"
  }

  println(greeting)

  // Cases are matched in order
  // PM works really well with case classes

  // PM on sealed hierarchies

  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra Nova")

  animal match {
    case Dog(someBreed) => println(s"Matched a dog of the $someBreed breed")
  }

  // match everything
  val isEven = x % 2 == 0 // WHY using a pattern matching?

  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def exerciseFunction(expr: Expr): String = {
    expr match {
      case Number(n) => s"$n"
      case Sum(e1, e2) => exerciseFunction(e1) + " + " + exerciseFunction(e2)
      case Prod(e1, e2) => {
        def maybeShowParentheses(expr: Expr) = expr match {
          case Prod(_, _) => exerciseFunction(expr)
          case Number(_) => exerciseFunction(expr)
          case _ => "(" + exerciseFunction(expr) + ")"
        }
        maybeShowParentheses(e1) + " * " + maybeShowParentheses(e2)
      }
    }
  }
}
