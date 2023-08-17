package algorithm1

import java.io.{BufferedReader, InputStreamReader}

object Q10866 {
  def main(args: Array[String]): Unit = {
    val result = new StringBuilder()
    val reader = new BufferedReader(new InputStreamReader(System.in))

    val deque = scala.collection.mutable.ArrayDeque[Int]()

    val commandCount = reader.readLine().toInt
    var count = 0
    while (count < commandCount) {
      val command = reader.readLine().split(" ")

      command(0) match {
        case "push_front" => deque.prepend(command(1).toInt)
        case "push_back" => deque.append(command(1).toInt)
        case "pop_front" => {
          if (deque.nonEmpty) {
            result.append(s"${deque.removeHead()}\n")
          } else {
            result.append("-1\n")
          }
        }
        case "pop_back" => {
          if (deque.nonEmpty) {
            result.append(s"${deque.removeLast()}\n")
          } else {
            result.append("-1\n")
          }
        }
        case "size" => result.append(s"${deque.size}\n")
        case "empty" => if (deque.isEmpty) result.append("1\n") else result.append("0\n")
        case "front" => {
          if (deque.nonEmpty) {
            result.append(s"${deque.head}\n")
          } else {
            result.append("-1\n")
          }
        }
        case "back" => {
          if (deque.nonEmpty) {
            result.append(s"${deque.last}\n")
          } else {
            result.append("-1\n")
          }
        }
        case _ => throw new IllegalArgumentException()
      }

      count = count + 1
    }

    println(result.toString())
  }
}
