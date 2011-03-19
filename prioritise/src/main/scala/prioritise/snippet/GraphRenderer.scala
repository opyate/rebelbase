package prioritise.snippet

import xml.NodeSeq
import prioritise.lib.TaskManager

/**
 * TODO Javadoc here...
 *
 * @author Juan Uys
 */

class GraphRenderer {
  def render(ns: NodeSeq): NodeSeq = {
    //TaskManager.load
    //TaskManager.persist
    TaskManager.test1
    <p>Check console</p>
  }
}