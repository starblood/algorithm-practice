package algorithm1

import java.io.{BufferedReader, InputStreamReader}

object Q10845 {
  def main(args: Array[String]): Unit = {
    val result = new StringBuilder()
    val reader = new BufferedReader(new InputStreamReader(System.in))

    val queue = scala.collection.mutable.Queue[Int]()

    val commandCount = reader.readLine().toInt
    var count = 0
    while (count < commandCount) {
      val command = reader.readLine().split(" ")
      command(0) match {
        case "push" => queue.addOne(command(1).toInt)
        case "pop" => if (queue.nonEmpty) {
          result.append(s"${queue.dequeue()}\n")
        } else {
          result.append("-1\n")
        }
        case "size" => result.append(s"${queue.size}\n")
        case "empty" => if (queue.isEmpty) {
          result.append("1\n")
        } else {
          result.append("0\n")
        }
        case "front" => if (queue.nonEmpty) result.append(s"${queue.head}\n") else result.append("-1\n")
        case "back" => if (queue.nonEmpty) result.append(s"${queue.last}\n") else result.append("-1\n")
        case _ => throw new IllegalArgumentException
      }
      count = count + 1
    }

    println(result.toString())
  }
}
