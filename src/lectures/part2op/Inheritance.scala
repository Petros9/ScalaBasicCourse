package lectures.part2op

object Inheritance extends App {

  // single class inheritance
  sealed class Animal { // superclass of Cat
    val creatureType = "wild"
    protected def eat: Unit = println("nomnomnom") // accessible inside but not outside
  }

  // subclass of Animal
  class Cat extends Animal {
    def crunch = {
      super.eat // eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch


  // constructors

  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  //overriding
  class Dog(override val creatureType: String) extends Animal {
  //  override val creatureType: String = "domestic"
    override def eat = println("crunch, crunch")
  }

  val dog = new Dog("domestic")
  dog.eat


  // type substitution

  // polymorphism
  val unknownAnimal: Animal = new Dog("K9") // animal with dog instead
  // unknownAnimal.eat -> crunch crunch

  // overRIDING vs overLOADING

  // super
  // method or field from upper class

  // preventing overrides
  // 1 - use final e.g. final def eats: String = "nom nom" || on class/methods/fields
  // 2 - seal the class = extend classes in THIS FILE, prevent extension in other files || sealed

}
