package gameday;

import Search.graph.DirectedGraphNode;

import java.util.*;

public class TopologicalSorting {
    /**
     * 2/21/2019
     * GameDay
     * https://www.lintcode.com/problem/topological-sorting/description
     *
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort2(ArrayList<DirectedGraphNode> graph) {
        Map<DirectedGraphNode, Integer> indegree = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            indegree.put(node, 0);
        }

        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) + 1);
            }
        }

        ArrayList<DirectedGraphNode> list = new ArrayList<>();

        Queue<DirectedGraphNode> queue = new LinkedList<>();

        for (DirectedGraphNode node : indegree.keySet()) {
            if (indegree.get(node) == 0) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            DirectedGraphNode current = queue.remove();
            list.add(current);

            for (DirectedGraphNode neighbor : current.neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return list;
    }


    /**
     * 2/21/2019
     * GameDay
     * https://www.lintcode.com/problem/topological-sorting/description
     *
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        Map<DirectedGraphNode, Integer> indegree = new HashMap<>();

        for (DirectedGraphNode node : graph) {
            if (!indegree.containsKey(node)) {
                indegree.put(node, 0);
            }

            for (DirectedGraphNode neighbor : node.neighbors) {
                indegree.put(neighbor, indegree.getOrDefault(neighbor, 0) + 1);
            }
        }

        TreeSet<DirectedGraphNode> set = new TreeSet<>((a, b) -> {
            if (indegree.get(a) != indegree.get(b)) {
                return indegree.get(a) - indegree.get(b);
            } else {
                return a.label - b.label;
            }
        });

        set.addAll(indegree.keySet());

        ArrayList<DirectedGraphNode> list = new ArrayList<>();

        while (!set.isEmpty()) {
            DirectedGraphNode first = set.first();
            list.add(first);
            set.remove(first);

            for (DirectedGraphNode neighbor : first.neighbors) {
                set.remove(neighbor);
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                set.add(neighbor);
            }
        }

        return list;
    }


    public static void main(String[] args) {
        DirectedGraphNode node0 = new DirectedGraphNode(0);
        DirectedGraphNode node1 = new DirectedGraphNode(1);
        DirectedGraphNode node2 = new DirectedGraphNode(2);
        DirectedGraphNode node3 = new DirectedGraphNode(3);
        DirectedGraphNode node4 = new DirectedGraphNode(4);
        DirectedGraphNode node5 = new DirectedGraphNode(5);

        node0.neighbors.addAll(Arrays.asList(node1, node2, node3));
        node1.neighbors.add(node4);
        node2.neighbors.addAll(Arrays.asList(node4, node5));
        node3.neighbors.addAll(Arrays.asList(node4, node5));

        ArrayList<DirectedGraphNode> graph = new ArrayList<>();
        graph.addAll(Arrays.asList(node0, node1, node2, node3, node4, node5));

        System.out.println(new TopologicalSorting().topSort(graph));
    }
}
