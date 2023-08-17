package algorithm1

import java.io.{BufferedReader, InputStreamReader}

object Q1406 {
  def main(args: Array[String]): Unit = {
    val reader = new BufferedReader(new InputStreamReader(System.in))

    val leftStack = scala.collection.mutable.Stack[Char]()
    val rightStack = scala.collection.mutable.Stack[Char]()

    leftStack.pushAll(reader.readLine().toCharArray)
    val commandCount = reader.readLine().toInt

    var count = 0
    while (count < commandCount) {
      val command = reader.readLine().split(" ")
      command(0) match {
        case "L" => if (leftStack.nonEmpty) rightStack.push(leftStack.pop())
        case "D" => if (rightStack.nonEmpty) leftStack.push(rightStack.pop())
        case "B" => if (leftStack.nonEmpty) leftStack.pop()
        case "P" => leftStack.push(command(1).charAt(0))
        case _ => throw new IllegalArgumentException
      }
      count = count + 1
    }

    while (leftStack.nonEmpty) {
      rightStack.push(leftStack.pop())
    }

    val result = new StringBuilder()
    while (rightStack.nonEmpty) {
      result.append(rightStack.pop())
    }
    println(result.toString())
  }
}
