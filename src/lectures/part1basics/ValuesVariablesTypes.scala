package lectures.part1basics

object ValuesVariablesTypes extends App {
  /** VALUES */

  val x: Int = 42
  // TYPES ARE OPTIONAL val x = 42 WORKS AS WELL

  println(x)
  // x = 2 VALUES ARE IMMUTABLE (LIKE IN ERLANG)

  val aString: String = "hello"
  val bString: String = "goodbye"
  // val aString: String = "hello"; val bString: String = "goodbye" [';' IS HERE MANDATORY]

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val aInt: Int = x + 2
  val aShort: Short = 4613
  val aLong: Long = 43143211111L // L IS MANDATORY
  val aFloat: Float = 2.0f // f IS MANDATORY
  val aDouble: Double = 3.14


  /** VARIABLES */
  var aVariable: Int = 4
  aVariable = 5
  // VARIABLES ARE MUTABLE
}
