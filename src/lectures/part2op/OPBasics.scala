package lectures.part2op

object OPBasics extends App {
  val person = new Person("Peter", 21)
  println(person.age)
  person.greet("John")
  person.greet()
}

// constructor
class Person(name: String, val age: Int) {
  // body

  val x = 2 // val are FIELDS


  println(1 + 3) // this side effect will be executed as new instance is created
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name") // this.name as a parameter is still available

  // overloading -> same name, different signatures
  def greet(): Unit = println(s"Hi, I am $name") // this.name or name is irrelevant here


  // multiple constructor
  def this(name: String) = this(name, 0) // an auxiliary constructor
  def this() = this("Jhon Doe") // default parameter (val age: Int = 0) works as well
}


// class parameters are NOT FIELDS -> adding `val` to parameter makes a field

class Writer(firstName: String, surname: String, age: Int){

  def fullName(): String = firstName + " " + surname

  def authorAge(): Int = age
}

class Novel(name: String, yearOfRelease: Int, author: Writer){

  def authorAge(): Int = author.authorAge()

  def isWrittenBy(author: Writer): Boolean = author.equals(this.author)

  def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, author)
}


class Counter(val number: Int = 0){
  def currentCount() = this.number

  def increment(): Counter = new Counter(this.number + 1) // immutability
  def decrement(): Counter = new Counter(this.number - 1)


  // def increment(number: Int) = new Counter(this.number + number)
  def increment(number: Int): Counter = {
    if(number <= 0) this
    else increment.increment(number - 1)
  }

  def decrement(number: Int) = new Counter(this.number - number)
}