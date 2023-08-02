package algorithm1

import java.io.{BufferedReader, InputStreamReader}

object Q1874 {
  def main(args: Array[String]): Unit = {
    val stack = scala.collection.mutable.Stack[Int]()
    val result = new StringBuilder()
    val reader = new BufferedReader(new InputStreamReader(System.in))

    val commandCount = reader.readLine().toInt
    var count = 0
    var startNumber = 1
    while (count < commandCount) {
      val inputNumber = reader.readLine().toInt
      val number = startNumber

      (number to inputNumber).foreach(n => {
        stack.push(n)
        result.append("+\n")
        startNumber = startNumber + 1
      })

      if (stack.nonEmpty && stack.top == inputNumber) {
        stack.pop()
        result.append("-\n")
      } else {
        println("NO")
        System.exit(0)
      }
      count = count + 1
    }

    println(result.toString())
  }
}
