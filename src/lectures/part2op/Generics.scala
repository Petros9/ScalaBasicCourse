package lectures.part2op

object Generics extends App {

  class MyList[A] {
     // you can use the type A
    def add[B >: A](element: B): MyList[B] = ???

    /*
      A = Cat
      B = Dog = Animal
     */
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // reusable for each type we provide



  // generics methods

  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]


  // variance problem

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // does List of Cats extends list of Animals

  // 1. YES
  class CovariantList[+A] // if so then yes

  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog)??? <- is it possible?

  // 2. NO
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. NO NO NO CONTRAVARIANT

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal] // can use the trainer of animal to be a trainer of cat

  // bounded types
  class Cage[A <: Animal](animal: A) // class Cage only accept parameter A as a subclass of an Animal
  val cage = new Cage(new Dog)
  // <: subtype >: supertype
  class Car
  // val newCage = new Cage(new Car) // compiler error


}
