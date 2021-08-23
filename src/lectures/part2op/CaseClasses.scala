package lectures.part2op

object CaseClasses extends App {


  case class Person(name: String, age: Int)

  // 1. class parameters are fields

  val jim = new Person("Jim", 33)
  println(jim.name) // valid

  // 2. sensible toString

  println(jim.toString) // prints Person(Jim, 33)


  // 3. equals and hashCode are implemented OOTB

  val jim2 = new Person("Jim", 33)

  println(jim == jim2) // TRUE

  // 4. case classes have handy copy methods

  val jim3 = jim.copy(age = 45) // Person("Jim", 45)

  // 5. case classes have companion objects

  val thePerson = Person
  val mary = Person("Mary", 12)

  // 6. case classes are serializable

  // Akka -> case classes

  // 7. case classes have extractor patterns -> can be used in pattern matching

  case object Peter {
    val name: String = "Peter"
    val age: Int = 12
  }
}
