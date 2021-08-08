package exercises

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favouriteMovie: String, age: Int = 18) {
    def likes(movie: String): Boolean = movie.equals(favouriteMovie)
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, some string!"
    def isAlive : Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"
    def +(role: String) : Person = new Person(s"$name ($role)", favouriteMovie)
    def unary_+ : Person = new Person(name, favouriteMovie, age + 1)
    def learns(thing: String): String = s"$name learns $thing"
    def learnsScala: String = this learns "Scala"
    def apply(number: Int): String = s"$name watched $favouriteMovie $number times"
  }



  val mary = new Person("Mary", "Inception")

  println(mary.likes("Inception"))

  println(mary likes "Inception") // equivalent
  // infix notations = operator notations -> works with one parameter methods (syntactic sugar)
  val tom = new Person("Tom", "LotR")
  println(mary hangOutWith tom)

  // ALL OPERATORS ARE METHODS -> like +, - , *, /
  // Akka actors have ! ?


  // prefix notation

  val x = -1 // unary operator
  val y = 1.unary_- // equivalent with upper
  // only works with few operators - + ~ !

  println(!mary) // equivalent with mary.unary_!

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive) // postfix notation -> for methods without parameters

  // apply
  println(mary.apply())
  println(mary(10)) // equivalent -> apply makes available calling object as a function
}
