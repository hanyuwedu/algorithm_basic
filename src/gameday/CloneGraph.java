package gameday;

import Search.graph.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
    /**
     * 2/21/2019
     * Gameday
     * https://www.lintcode.com/problem/clone-graph/description
     *
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        Map<UndirectedGraphNode, UndirectedGraphNode> image = new HashMap<>();

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 1; i <= len; i++) {
                UndirectedGraphNode current = queue.remove();
                image.put(current, new UndirectedGraphNode(current.label));

                for (UndirectedGraphNode neighbor : current.neighbors) {
                    if (!image.containsKey(neighbor)) {
                        queue.add(neighbor);
                    }
                }
            }
        }

        for (UndirectedGraphNode preimage : image.keySet()) {
            for (UndirectedGraphNode neighbor : preimage.neighbors) {
                image.get(preimage).neighbors.add(image.get(neighbor));
            }
        }

        return image.get(node);
    }
}
