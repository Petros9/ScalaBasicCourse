package lectures.part3fp

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App {
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("Super Failure"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("No")

  // try objects via the apply method
  val potentialFailure = Try{unsafeMethod()}

  // syntax sugar
  val anotherPotentialFailure = Try {
    // code that migh throw
  }

  // utilities
  println(potentialFailure.isSuccess)

  // orElse

  def backupMethod(): String = "A valid result"
  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod))
  println(fallbackTry)

  // IF you design the API
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)
  def betterBackupMethod(): Try[String] = Success("A valid result")
  val betterFailure = betterUnsafeMethod() orElse betterBackupMethod()

  // map, filter, flatMap

  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(_ > 10))
  // => for-comprehensions


  // EXERCISE -> GIVEN
  val hostname = "localhost"
  val port ="8080"

  def renderHTML(page: String) = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if(random.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException("Connection interrupted")
    }

    def getSafe(url: String): Try[String] = Try(get(url))
  }

  object HttpService {

    def getConnection(host: String, port: String): Connection = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone else took the port")
    }
    def getSafeConnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port))
  }
  // MADE
  val possibleConnection = HttpService.getSafeConnection(hostname, port)
  val possibleHTML = possibleConnection.flatMap(connection => connection.getSafe("/home"))
  possibleHTML.foreach(renderHTML)

  // shorter
  HttpService.getSafeConnection(hostname, port)
    .flatMap(connection => connection.getSafe("/home"))
    .foreach(renderHTML)

  // for-comprehension

  for{
    connection <- HttpService.getSafeConnection(hostname, port)
    html <- connection.getSafe("/home")
  } yield renderHTML(html)

}
