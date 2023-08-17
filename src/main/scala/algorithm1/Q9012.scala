package algorithm1

import java.io.{BufferedReader, InputStreamReader}

object Q9012 {
  def main(args: Array[String]): Unit = {
    val stack = scala.collection.mutable.Stack[Char]()
    val result = new StringBuilder()
    val reader = new BufferedReader(new InputStreamReader(System.in))

    val commandCount = reader.readLine().toInt
    var count = 0
    while (count < commandCount) {
      val parentheses = reader.readLine().toCharArray
      parentheses.foreach(ch => {
        if (ch == '(') stack.push(ch)
        else if (ch == ')' && stack.nonEmpty && stack.top == '(') stack.pop()
        else stack.push(ch)
      })
      if (stack.isEmpty) result.append("YES\n")
      else result.append("NO\n")
      count = count + 1
      stack.clear()
    }
    println(result.toString())
  }
}
