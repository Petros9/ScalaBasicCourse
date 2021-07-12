package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 // EXPRESSION
  println(x)

  // MATHEMATICAL
  // + - * / & | ^ << >> >>> (right shift with zero extension)

  // RELATIONS
  // == != > >= < <=

  //LOGICAL
  // ! && ||

  var aVariable = 2
  aVariable += 3 // -= *= /= ... SIDE EFFECTS
  println(aVariable)

  /** INSTRUCTIONS (DO) vs EXPRESSIONS (VALUE) */
  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  println(aConditionedValue)

  // WHILE loop -> DISCOURAGED
  var i = 0
  val aWhile = while(i < 10){
    println(i)
    i += 1
  }

  // EVERYTHING SHOULD BE AN EXPRESSION

  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue)

  // side effects: println(), whiles, reassigning

  // Code blocks

  val aCodeBlock = { // THIS IS A CodeBlock
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  } // VALUE OF WHOLE EXPRESSION IS A VALUE OF THE LAST EXPRESSION
  // LOCAL VARIABLES IN CodeBlock ARE NOT VISIBLE OUTSIDE

}