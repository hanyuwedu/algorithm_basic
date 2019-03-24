package Search.graph;

import java.util.*;

public class TopologicalSorting {
    /*
     * 8/13/2018
     *
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        if (graph == null) {
            return new ArrayList<>();
        }

        ArrayList<DirectedGraphNode> topology = new ArrayList<>();
        Map<DirectedGraphNode, Integer> indegree = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            indegree.put(node, 0);
        }

        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) + 1);
            }
        }

        Queue<DirectedGraphNode> zero = new LinkedList<>();
        for (DirectedGraphNode node : indegree.keySet()) {
            if (indegree.get(node) == 0) {
                zero.add(node);
            }
        }

        while (!zero.isEmpty()) {
            DirectedGraphNode next = zero.remove();
            topology.add(next);
            for (DirectedGraphNode neighbor : next.neighbors) {
                int update = indegree.get(neighbor) - 1;
                if (update == 0) {
                    zero.add(neighbor);
                }
                indegree.put(neighbor, update);
            }
        }

        return topology;
    }
}
