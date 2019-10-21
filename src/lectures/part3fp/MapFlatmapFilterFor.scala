package lectures.part3fp

object MapFlatmapFilterFor extends App {
  val numbers = List(1,2,3,4)
  val chars = List('a','b','c', 'd')

  val output = chars.flatMap(x => numbers.map(y => "" + x+y))
  println(output)

}
