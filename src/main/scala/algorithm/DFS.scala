package algorithm

object DFS {
  /**
   *  pseudo code for DFS
   *    visited_nodes = {}
   *    DFS(node):
   *      if visited_nodes not contain node:
   *        process node
   *        add node to visited_nodes
   *        foreach neighbour in node.neighbours
   *          DFS(neighbour)
   *
   * @param graph
   * @param start
   * @param visited
   * @tparam N
   */
  def dfs[N](graph: Graph[N], start: N, visited: scala.collection.mutable.Map[N, Boolean]): Unit = {
    if (!visited(start)) {
      println(start)
      visited.addOne((start, true))
      graph.neighbors(start).foreach(node => {
        dfs(graph, node, visited)
      })
    }
  }

  def main(args: Array[String]): Unit = {
    val graph: Graph[Int] = Graph.getSample()
    val visited = scala.collection.mutable.Map(
      (1, false), (2, false), (3, false), (4, false), (5, false), (6, false), (7, false), (8, false)
    )

    dfs(graph, 1, visited)
  }
}
