package lectures.part2op

object Objects{

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  object Person { // type + its only instance
    // static/class-level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // FACTORY METHOD
    def from(mother: Person, father: Person): Person = new Person("Boobie)")
  }

  class Person(val name: String = "John"){
    // instance-level functionality
  }
  // COMPANIONS

  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    // objects do not receive parameters
    println(Person.canFly)

    // Scala object = SINGLETON INSTANCE

    val mary = new Person("Mary") // instance of the Person type
    val tom = Person
    val john = new Person
    println(mary == tom) // true

    val bobbie = Person.from(mary, john)
  }
  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit
}

