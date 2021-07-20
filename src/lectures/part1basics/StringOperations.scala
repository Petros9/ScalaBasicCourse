package lectures.part1basics

object StringOperations extends App {
  val str: String = "Litwo, Ojczyzno moja, Ty jestes jak zdrowie"


  // JAVA FEATURES

  println(str.charAt(3))

  println(str.substring(5, 9))
  println(str.split(",").toList)
  println(str.startsWith("Litwo"))
  println(str.replace("Litwo", "Polsko"))
  println(str.toLowerCase())
  println(str.length)

  // SCALA FEATURES

  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z') // prepending and appending

  println(str.reverse)

  println(str.take(2))

  // Scala-specific: String interpolators

  // S-interpolators
  val name = "Piotr"
  val age = 23
  val greeting = s"Hello, name name is $name and I am $age years old" // s"" is necessary
  // s"Hello $(age + 1)" -> Hello 24
  println(greeting)


  // F-interpolators
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f" // two characters total and 2 decimal precision
  println(myth)

  // raw-interpolators

  println(raw"This is a \n newline") // \n are not escaped
  val escaped = "This is a \n new line"
  println(raw"$escaped") // \n is escaped
}
