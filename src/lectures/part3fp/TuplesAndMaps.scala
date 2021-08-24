package lectures.part3fp

object TuplesAndMaps extends App {
   val aTuple = new Tuple2(2, " Helllo, Scala") // Tuple2[Int, String] = (Int, String)
   val bTuple = (2, "hello Scala")
  // at most 22 elements may be in a tuple

  println(aTuple._1) // ._2 is the second element
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap) // ("hello Scala", 2)

  // Maps - keys -> values

  val aMap: Map[String, Int] = Map() // string -> key, Int -> value
  val phonebook = Map(("Jim", 555), ("Peter", 123), "Mike" -> 234).withDefaultValue(-1) // specifying tuples or pairings
  // default value prevents a crush when key does not exists
  // a -> b is sugar for (a, b)
  println(phonebook)

  println(phonebook.contains("Jim"))
  println(phonebook("Jim")) // 555
  // println(phonebook("mary") // crash

  val newPairing = "Mary" -> 456
  val newPhonebook = phonebook + newPairing

  // functionals on maps
  // map, flatMap, filter

  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys
  println(phonebook.filterKeys(key => key.startsWith("J"))) // Jim passes

  // mapValues
  println(phonebook.mapValues(number => number * 10))

  // conversions to other collections
  println(phonebook.toList)
  println(List(("Daniel", 555)).toMap)
  val names = List("Bob", "James", "Mary", "Daniel", "Jim")

  println(names.groupBy(name => name.charAt(0))) // returns a map


  val socialMap: Map[String, List[String]] = Map()

  def add(network: Map[String, List[String]], person: String): Map[String, List[String]] =
    network + (person -> List())

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] = {
      if(friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))
    }
    val unfriended = removeAux(network(person), network)
    unfriended - person
  }


  def mostFriends(network: Map[String, Set[String]]): String = {
    network.maxBy(pair => pair._2.size)._1
  }

  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int = {
    network.filterKeys(key => network(key).isEmpty).size
  }

  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
   def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
   if(discoveredPeople.isEmpty) false
   else {
     val person = discoveredPeople.head
     if(person == target) true
     else if(consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
     else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
   }
   }
    bfs(b, Set(), network(a) + a)
  }
}
