package lectures.part2op

object AbstractDataTypes extends App {

  // abstract

  abstract class Animal {
    val creatureType: String // abstract value
    def eat: Unit // abstract method
  }

  class Dog extends Animal {
    override val creatureType: String = "domestic"

    def eat: Unit = println("nom nom nom")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore { // injecting traits
    override val creatureType: String = "wild"
    def eat: Unit = println("crock crock crock")
    def eat(animal: Animal): Unit = println(s"I'am croc and I'am eating ${animal.creatureType}")
  }

  val dog = new Dog
  val crock = new Crocodile

  crock.eat(dog)

  // traits vs abstract classes
  // abstract classes and traits CAN have both abstract and non-abstract members
  // 1 - traits do not have constructor parameters, abstract classes do have
  // 2 - multiple traits can be inherited by the same class vs one abstract class can be inherited
  // 3 - traits = behaviour, abstract class = "thing"
}
