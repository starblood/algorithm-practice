package algorithm1

import java.io.{BufferedReader, InputStreamReader}

object Q10828 {
  // 해결방법은 맞지만 시간초과가 발생한다.
  def main(args: Array[String]): Unit = {
    val stack = scala.collection.mutable.Stack[Int]()
    val result = new StringBuilder()
    val reader = new BufferedReader(new InputStreamReader(System.in))

    val commandCount = reader.readLine().toInt
    var count = 0
    while (count < commandCount) {
      val command = reader.readLine().split(" ")

      command(0) match {
        case "push" => stack.push(command(1).toInt)
        case "pop" => {
          if (stack.isEmpty) result.append(s"-1\n")
          else result.append(s"${stack.pop()}\n")
        }
        case "size" => result.append(s"${stack.size}\n")
        case "empty" => result.append(s"${if (stack.isEmpty)  1 else 0}\n")
        case "top" => {
          if (stack.isEmpty) result.append(s"-1\n")
          else result.append(s"${stack.top}\n")
        }
        case _ => throw new IllegalArgumentException()
      }
      count = count + 1
    }
    println(result.toString())
  }
}
