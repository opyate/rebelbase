package prioritise.lib

import org.jgrapht.experimental.dag.DirectedAcyclicGraph
import net.stixar.graph.gen.BasicDGFactory
import net.stixar.graph.check.AcyclicChecker
import net.stixar.graph.attr.NodeMap
import net.stixar.graph.{Node, Digraph}
import net.stixar.graph.conn.Transitivity


/**
 *
 * TODO
 *
 * * load graph from DB to objects graph for the current user
 * * persist graph from object graph to DB for the current user
 *
 * @author juanuys
 * (Created on 13/02/2011 at 16:46)
 */

object TaskManager {

  def load() = {
    // TODO for now just mock a digraph and return it
    val digraph: DirectedAcyclicGraph[String, TaskDependency] = new DirectedAcyclicGraph(classOf[TaskDependency])
    val t1 = "t1"
    val t2 = "t2"
    val t3 = "t3"
    digraph.addVertex(t1)
    digraph.addVertex(t2)
    digraph.addVertex(t3)
    digraph.addEdge(t1, t2)
    digraph.addEdge(t1, t3)
    println(digraph)
  }

  def persist() = {

    //val digraph: Digraph = new BasicDigraph
    val nodeSize: Int = 100
    val factory: BasicDGFactory = new BasicDGFactory();

    val nodes = for {i <- 0 until nodeSize} yield factory.node

    // the next two statements creates a loop
    for (i <- 0 until nodeSize - 1) {
      factory.edge(nodes(i), nodes(i + 1))
    }
    //factory.edge(nodes(nodeSize - 1), nodes(0))


    val digraph: Digraph = factory.digraph()
    val ck: AcyclicChecker = new AcyclicChecker()
    println("should be false " + ck.check(digraph))
  }

  def test1() = {
    val factory: BasicDGFactory = new BasicDGFactory();
    val n0 = factory.node
    val n1 = factory.node
    val n2 = factory.node
    factory.edge(n0, n1)
    factory.edge(n0, n2)
    factory.edge(n1, n2)


    val digraph: Digraph = factory.digraph()

    var nm: NodeMap[Node] = digraph.createNodeMap[Node]
    val reduced = Transitivity.reduce(digraph, nm)

    //val ck: AcyclicChecker = new AcyclicChecker()
    //println("Acyclic check: " + ck.check(digraph))
    println("Before: " + digraph)
    println("After: " + reduced)
  }
}
