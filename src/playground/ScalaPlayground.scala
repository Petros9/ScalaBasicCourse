package playground

object ScalaPlayground extends App{ // inserts main function
  println("Hello Scala")
}

class Cousin(name: String, surname: String){
  val nameAndSurname = name + " " + surname

  def giveName: Any = println(s"$name")
}
