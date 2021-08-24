package lectures.part3fp

object MapFlatMapFilterFor extends App {
  val list = List(1, 2, 3)

  println(list)
  println(list.head)
  println(list.tail)

  // map
  val listWithDoubledValues = list.map(element => element * 2)
  println(listWithDoubledValues)

  // filter
  val filteredList = list.filter(element => element % 2 == 0)
  println(filteredList)

  // flatMap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  val numbers = List(1, 2, 3, 4)
  val characters = List('a', 'b', 'c', 'd')

  // two loops -> flatMap, map
  // three loops flatMap, flatMap, map
  // iterations
  val combinations = numbers.flatMap(n => characters.map(c => "" + c + n))

  // foreach
  list.foreach(println)

  // for-comprehensions
  val forCombinations = for {
    n <- numbers if n % 2 == 0 // a guard
    c <- characters
  } yield (c + n)
  // it is rewritten to chain of flatMaps and maps

  for {
    n <- numbers
  } println(n) // like foreach

  // this syntax may be used as well
  list.map { x =>
    x * 2
  }


}
