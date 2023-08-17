package chap1

object Q2588 {
  def main(args: Array[String]): Unit = {
    val a = scala.io.StdIn.readLine().toInt
    val b = scala.io.StdIn.readLine().toInt

    val first = b % 10
    val second = (b % 100) / 10
    val third = b / 100

    val number3 = a * first
    val number4 = a * second
    val number5 = a * third

    val number6 = number5 * 100 + number4 * 10 + number3
    println(number3)
    println(number4)
    println(number5)
    println(number6)
  }
}
