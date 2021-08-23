package lectures.part2op

import playground.Cousin

import java.util.Date

object PackagingAndImports extends App {

  // package memebers are accessible by their name
  val writer = new Writer("Peter", "Kot", 12)
  // import the package

  val cousin = new Cousin("Kot", "Gol")

  val date = new Date

}
