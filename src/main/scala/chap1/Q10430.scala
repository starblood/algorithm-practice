package chap1

object Q10430 {
  def main(args: Array[String]): Unit = {
    val inputs = scala.io.StdIn.readLine().split("""\s""").take(3).map(_.toInt)
    val a = inputs(0)
    val b = inputs(1)
    val c = inputs(2)

    println((a + b) % c)
    println(((a % c) + (b % c)) % c)
    println((a * b) % c)
    println((( a % c) * (b % c)) % c)
  }
}
