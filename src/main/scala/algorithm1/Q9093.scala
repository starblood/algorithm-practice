package algorithm1

import java.io.{BufferedReader, InputStreamReader}

object Q9093 {
  def main(args: Array[String]): Unit = {
    val result = new StringBuilder()
    val reader = new BufferedReader(new InputStreamReader(System.in))

    val commandCount = reader.readLine().toInt
    var count = 0
    while (count < commandCount) {
      val words = reader.readLine().split(" ")

      result.append(s"${words.map(word => word.reverse).mkString(" ")}\n")
      count = count + 1
    }
    println(result.toString())
  }
}
