package exercises

abstract class MyList[+A] {

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B):MyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"


  // higher order functions -> receive functions as parameters or return functions
  def map[B](transformer: A => B):MyList[B]
  def flatMap[B](transformer: A => MyList[B]):MyList[B]
  def filter(predicate: A => Boolean): MyList[A]

  //concatanation
  def ++[B >: A](list: MyList[B]):MyList[B]
}

case object  Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElements: String = ""

  def map[B](transformer: Nothing => B):MyList[B] = Empty
  def flatMap[B](transformer: Nothing => MyList[B]):MyList[B] = Empty
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty
  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = Cons(element, this)
  def printElements: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
  }

  def map[B](transformer: A => B):MyList[B] = {
     Cons(transformer(head), tail.map(transformer))
  }
  def flatMap[B](transformer: A => MyList[B]):MyList[B] = {
    transformer(head) ++ tail.flatMap(transformer)
  }

  def filter(predicate: A => Boolean): MyList[A] = {
    if(predicate(head))  Cons(head, tail.filter(predicate))
    else t.filter(predicate)
  }

  def ++[B >: A](list: MyList[B]):MyList[B] = new Cons(head, tail ++ list)
}


object ListTest extends App {
  val list = Cons(1, Empty)
  println(list.head)
  println(list.add(4).head)
  println(list.add(5).toString)
}