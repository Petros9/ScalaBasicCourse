package lectures.part4pm

import exercises.{Cons, MyList, Empty}

object AllThePatterns extends App {
 /*
  // 1 - constants

  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a number"
    case "Scala" => "The Scala"
    case true => "the truth"
    case AllThePatterns => "A singleton object"
  }

  // 2 - match anything
  // 2.1 wildcard

  val matchAnything = x match {
    case _ =>
  }

  // 2.2 variable

  val matchAVariable = x match {
    case something => s"I've found $something"
  }

  // 3 - tuples

  val aTuple = (1, 2)

  val matchATuple = aTuple match {
    case (1, 1) =>
    case (something, 2) => s"I've found $something"
  }

  val nestedTuple = (1, (2, 3))

  val matchANestedTuple = nestedTuple match {
    case (_, (2, v)) => println(s"$v")
  }

  // PMs can be NESTED !

  // 4- case classes - constructor pattern

  val aList: MyList[Int] = Cons(1, Cons(2, Empty))

  // PMs can be nested with case classes as well
  val matchAList = aList match {
    case Empty =>
    case Cons(head, Cons(subhead, subtail)) =>
  }

  // 5- list patterns
  val aStandardList = List(1, 2, 3, 12)
  val standardListMatching = aStandardList match {
    case List(1, _, _, _) => // extractor for lists
    case List(1, _*) => // list of arbitrary length
    case 1 :: List(_) => // infix pattern
    case List(1,2,3) :+ 42 => // also infix pattern
  }

  // 6 - type specifiers

  val unknown: Any = 2

  val unknownMatch = unknown match {
    case list: List[Int] => // if matches type
    case _ =>
  }

  // 7 - name binding
  val nameBidingMatch = aList match {
    case notEmptyList @ Cons(_, _) => // @ names a pattern => use the name later
    case Cons(1, rest @ Cons(2, _)) => // name binding inside nested patterns
  }


  // 8 - multi-patterns
  val multiPattern = aList match {
    case Empty | Cons(0, _) => // compound pattern/multi-pattern
  }

  // 9 - if guards

  val secondElementSpecial = aList match {
    case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 => // a guard
  }
*/
  // ALL
}
