package algorithm

object BFS {
  def bfs[N](graph: Graph[N], start: N, visited: scala.collection.mutable.Map[N, Boolean]): Unit = {
    val queue = scala.collection.mutable.Queue[N]()
    queue.addOne(start)
    visited.addOne((start, true))

    while (queue.nonEmpty) {
      val node = queue.dequeue()
      println(node)
      graph.neighbors(node).foreach(n => {
        if (!visited(n)) {
          queue.addOne(n)
          visited.addOne((n, true))
        }
      })
    }
  }

  def main(args: Array[String]): Unit = {
    val graph: Graph[Int] = Graph.getSample()

    val visited = scala.collection.mutable.Map(
      (1, false), (2, false), (3, false), (4, false), (5, false), (6, false), (7, false), (8, false)
    )

    bfs(graph, 1, visited)
  }
}
