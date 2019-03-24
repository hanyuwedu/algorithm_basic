package Search.graph;

import java.util.*;

public class SixDegrees {
    /*
     * 8/13/2018
     *
     * @param graph: a list of Undirected graph node
     * @param s: Undirected graph node
     * @param t: Undirected graph nodes
     * @return: an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
        if (s == null || t == null) {
            return -1;
        }

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> visited = new HashSet<>();
        queue.add(s);
        int degree = 0;

        while (!queue.isEmpty()) {
            int width = queue.size();
            for (int i = 1; i <= width; i++) {
                UndirectedGraphNode next = queue.remove();
                if (next == t) {
                    return degree;
                }

                for (UndirectedGraphNode neighbor : next.neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }

            degree++;
        }

        return -1;
    }
}
