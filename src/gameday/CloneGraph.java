package gameday;

import Search.graph.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
    /*
     * 8/13/2018
     *
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        Map<UndirectedGraphNode, UndirectedGraphNode> copy = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();

        copy.put(node, new UndirectedGraphNode(node.label));
        queue.add(node);

        /// Copy nodes:
        while (!queue.isEmpty()) {
            UndirectedGraphNode next = queue.remove();
            for (UndirectedGraphNode neighbor : next.neighbors) {
                if (!copy.containsKey(neighbor)) {
                    copy.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
            }
        }

        /// copy edge:
        for (UndirectedGraphNode origin : copy.keySet()) {
            UndirectedGraphNode image = copy.get(origin);
            for (UndirectedGraphNode neighbor : origin.neighbors) {
                image.neighbors.add(copy.get(neighbor));
            }
        }

        return copy.get(node);
    }
}
