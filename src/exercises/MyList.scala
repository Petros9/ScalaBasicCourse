package exercises

abstract class MyList[+A] {

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B):MyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A, B]):MyList[B]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]):MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]

  //concatanation
  def ++[B >: A](list: MyList[B]):MyList[B]
}

case object  Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElements: String = ""

  def map[B](transformer: MyTransformer[Nothing, B]):MyList[B] = Empty
  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]):MyList[B] = Empty
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElements: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
  }

  def map[B](transformer: MyTransformer[A, B]):MyList[B] = {
    new Cons(transformer.transform(head), tail.map(transformer))
  }
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]):MyList[B] = {
    transformer.transform(head) ++ tail.flatMap(transformer)
  }

  def filter(predicate: MyPredicate[A]): MyList[A] = {
    if(predicate.test(head)) new Cons(head, tail.filter(predicate))
    else t.filter(predicate)
  }

  def ++[B >: A](list: MyList[B]):MyList[B] = new Cons(head, tail ++ list)
}


trait MyPredicate[-T]{
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
}
object ListTest extends App {
  val list = new Cons(1, Empty)
  println(list.head)
  println(list.add(4).head)
  println(list.add(5).toString)
}