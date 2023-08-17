package algorithm

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class Graph[N](adjList: mutable.Map[N, ArrayBuffer[N]] = mutable.Map.empty[N, ArrayBuffer[N]]) {
  def nodes: List[N] = adjList.keys.toList

  def edges: List[(N, N)] = {
    adjList.map {
      case (node, neighbors) => neighbors.map(neighbor => (node, neighbor)).toList
    }.flatten.toList
  }

  def addEdge(from: N, to: N): Graph[N] = {
    if (adjList.contains(from)) {
      adjList(from).append(to)
    } else {
      adjList.addOne(from, ArrayBuffer[N](to))
    }
    this
  }

  def neighbors(node: N): List[N] = {
    if (adjList.contains(node)) adjList(node).toList
    else List.empty[N]
  }
}

object Graph {
  def apply[N](): Graph[N] = {
    new Graph[N]()
  }

  def getSample(): Graph[Int] = {
    Graph[Int]()
      .addEdge(1, 2).addEdge(1, 3).addEdge(1, 8)
      .addEdge(2, 1).addEdge(2, 7)
      .addEdge(3, 1).addEdge(3, 4).addEdge(3, 5)
      .addEdge(4, 3).addEdge(4, 5)
      .addEdge(5, 3).addEdge(5, 4)
      .addEdge(6, 7)
      .addEdge(7, 2).addEdge(7, 6).addEdge(7, 8)
      .addEdge(8, 1).addEdge(8, 7)
  }
}
