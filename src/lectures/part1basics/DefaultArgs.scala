package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  @tailrec
  def factHelper(x: Int, acc: Int = 1):Int = { // acc implied as 1 by default
    if (x <= 1) acc
    else factHelper(x - 1, x * acc) // TAIL RECURSIVE -> use recursive call as the last expression
  }
  // leading parameter should not be called with default parameter
  // solutions -> pass in every leading argument, or name the argument
  // e.g. savePicture(width = 800)


}
