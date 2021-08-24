package playground

object ScalaPlayground extends App{ // inserts main function
  println("Hello Scala")

  val subtract = (x: Int) => (y: Int) => x - y
}

class Cousin(name: String, surname: String){
  val nameAndSurname = name + " " + surname

  def giveName: Any = println(s"$name")
}
