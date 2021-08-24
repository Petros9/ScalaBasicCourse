package lectures.part3fp

import scala.util.Random

object Sequences extends App {
  val aSequence = Seq(1, 4, 3, 2)
  println(aSequence) // prints a list
  println(aSequence.reverse)
  println(aSequence(2)) // third value -> index
  println(aSequence ++ Seq(7, 6, 5))
  println(aSequence.sorted)

  // ranges

  val aRange: Seq[Int] = 1 to 10 // until
  aRange.foreach(println)

  (1 to 10).foreach(_ => println("Hello"))

  // list

  val aList = List(1, 2, 3)
  val prepended = 42 :: aList // appends to the beginning
  println(prepended)

  val appended = 42 +: aList :+ 89 // 42, 1, 2, 3, 89
  val apples5 = List.fill(5)("apple")
  println(apples5)
  println(aList.mkString("-|-"))

  // arrays
  val numbers = Array(1, 2, 3, 4)
  val threeElements = Array.ofDim[Int](3) // allocates a place for three elements
  threeElements.foreach(println) // are initialized with 0/null

  // mutation
  numbers(2) = 0 // syntax sugar for numbers.update(2, 0)
  println(numbers.mkString(" "))


  // arrays and seq
  val numbersSeq: Seq[Int] = numbers
  println(numbersSeq) // WrappedArray -> implicit conversion

  // vectors -> effective read/write operations
  val vector: Vector[Int] = Vector(1, 2, 3)
  println(vector)

  // vectors vs lists
  val maxRuns = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random

    val times = for {
      _ <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // keeps reference to tail
  // updating an element in the middle takes long
  println(getWriteTime(numbersList))

  // depth of the tree is small
  // needs to replace an entire 32-element chunk
  println(getWriteTime(numbersVector))
}
