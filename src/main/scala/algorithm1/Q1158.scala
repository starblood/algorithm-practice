package algorithm1

import java.io.{BufferedReader, InputStreamReader}

object Q1158 {
  def method_1(args: Array[String]): Unit = {
    val reader = new BufferedReader(new InputStreamReader(System.in))

    val series = reader.readLine().split(" ")
    val n = series(0).toInt
    val k = series(1).toInt

    val buffer = scala.collection.mutable.ArrayBuffer[Int]()
    val seq = 1 to n
    val visited = scala.collection.mutable.Map[Int, Boolean]()

    var index = 0
    while (buffer.size < n) {
      var count = 0
      var search = true
      while (search) {
        if (!visited.contains(index)) {
          count = count + 1
        }
        if (count < k) {
          index = (index + 1) % n
        } else {
          search = false
        }
      }
      buffer.append(seq(index))
      visited.addOne(index, true)
    }
    println(s"<${buffer.mkString(", ")}>")
  }

  def method_2(args: Array[String]): Unit = {
    val result = new StringBuilder()

    val reader = new BufferedReader(new InputStreamReader(System.in))

    val series = reader.readLine().split(" ")
    val n = series(0).toInt
    val k = series(1).toInt

    val queue = scala.collection.mutable.Queue[Int]()
    queue.addAll(1 to n)

    val buffer = scala.collection.mutable.ArrayBuffer[Int]()
    while (queue.size > 0) {
      var count = 1
      while (count < k) {
        queue.addOne(queue.dequeue())
        count = count + 1
      }
      buffer.append(queue.dequeue())
    }
    println(s"<${buffer.mkString(", ")}>")
  }

  def main(args: Array[String]): Unit = {
    method_2(args)
  }
}
