package chap1

object Q10869 {
  def main(args: Array[String]): Unit = {
    val inputs = scala.io.StdIn.readLine().split("""\s""").take(2).map(_.toInt)
    val a = inputs(0)
    val b = inputs(1)

    println(a + b)
    println(a - b)
    println(a * b)
    println(a / b)
    println(a % b)
  }
}
