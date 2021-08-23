package lectures.part2op

object AnonymousClass extends App {
  abstract class Animal {
    def eat: Unit
  }

  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahah")
  }

  /*
  class AnonymousClass$$anon$1 extends Animal{
    override def eat: Unit = println("ahahahah")
  }

  val funnyAnimal: Animal = new AnonymousClass$$anon$1

   */

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim")
  }
  println(funnyAnimal.getClass)

  /*
    1. Generic trait MyPredicate[-T]
    2. Generic trait MyTransformer[A, B]
   */
}
