package Search.graph;

import java.util.*;

public class ConnectedComponentinUndirectedGraph {
    /*
     * 8/13/2018
     *
     * @param nodes: a array of Undirected graph node
     * @return: a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        if (nodes == null || nodes.size() == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Set<UndirectedGraphNode> visited = new HashSet<>();
        for (UndirectedGraphNode node : nodes) {
            if (visited.contains(node)) {
                continue;
            }

            List<Integer> current = new ArrayList<>();
            Queue<UndirectedGraphNode> queue = new LinkedList<>();
            queue.add(node);
            visited.add(node);

            while (!queue.isEmpty()) {
                UndirectedGraphNode next = queue.remove();
                current.add(next.label);
                for (UndirectedGraphNode neighbor : next.neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }

            Collections.sort(current);
            result.add(current);
        }

        return result;
    }
}
