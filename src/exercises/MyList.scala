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

  //concatenation
  def ++[B >: A](list: MyList[B]):MyList[B]

  // HOF
  def foreach(f: A => Unit): Unit
  def sort(compare: (A, A) => Int): MyList[A]
  def zipWith[B, C](list: MyList[B], zip:(A, B) => C): MyList[C]
  def fold[B](start: B)(operator: (B, A) => B): B
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

  def foreach(f: Nothing => Unit): Unit = ()
  def sort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = Empty
  def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] = {
    if(list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else Empty
  }
  def fold[B](start: B)(operator: (B, Nothing) => B):B = start
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

  def foreach(f: A => Unit): Unit = {
    f(head)
    tail.foreach(f)
  }
  def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if(sortedList.isEmpty) new Cons(x, Empty)
      else if(compare(x, sortedList.head) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))
    }
    val sortedTail = tail.sort(compare)
    insert(head, sortedTail)
  }

  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] = {
    if(list.isEmpty) throw new RuntimeException("List do not have the same length")
    else new Cons(zip(head, list.head), tail.zipWith(list.tail, zip))
  }
  def fold[B](start: B)(operator: (B, A) => B): B = {
    val newStart = operator(start, head)
    tail.fold(newStart)(operator)
  }
}


object ListTest extends App {
  val list = Cons(1, Empty)
  println(list.head)
  println(list.add(4).head)
  println(list.add(5).toString)
}