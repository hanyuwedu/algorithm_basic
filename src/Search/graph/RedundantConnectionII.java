package Search.graph;

import java.util.*;

public class RedundantConnectionII {
    /**
     * 2/21/2019
     * DFS on directed graph node
     *
     * @param edges: List[List[int]]
     * @return: return List[int]
     */
    public int[] findRedundantDirectedConnection(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return new int[2];
        }

        /// neighbors map
        Map<Integer, List<Integer>> neighbors = new HashMap<>();
        for (int[] edge : edges) {
            if (!neighbors.containsKey(edge[0])) {
                neighbors.put(edge[0], new ArrayList<>());
            }

            neighbors.get(edge[0]).add(edge[1]);
        }

        /// indegree map
        Map<Integer, Integer> indegree = new HashMap<>();
        for (int[] edge : edges) {
            if (!indegree.containsKey(edge[1])) {
                indegree.put(edge[1], 0);
            }

            indegree.put(edge[1], indegree.get(edge[1]) + 1);
        }


        Set<Integer> cycle = new HashSet<>(getCycle(neighbors));

        if (cycle.isEmpty()) {
            /// No cycle exist, find last edge that points to a vertex with indegree 2
            for (int i = edges.length - 1; i >= 0; i--) {
                if (indegree.get(edges[i][1]) == 2) {
                    return edges[i];
                }
            }
        } else {
            if (indegree.values().stream().mapToInt(i -> i).max().getAsInt() > 1) {
                /// Cycle with one element indegree = 2, remove edge that from inside the loop
                for (int i = edges.length - 1; i >= 0; i--) {
                    if (indegree.get(edges[i][1]) == 2 && cycle.contains(edges[i][0])) {
                        return edges[i];
                    }
                }
            } else {
                /// Cycle with no element indegree > 1, remove first edge in the cycle
                for (int i = edges.length - 1; i >= 0; i--) {
                    if (cycle.contains(edges[i][0]) && cycle.contains(edges[i][1])) {
                        return edges[i];
                    }
                }
            }
        }

        return new int[0];
    }

    private List<Integer> getCycle(Map<Integer, List<Integer>> neighbors) {
        // Set<Integer> visited = new HashSet<>();

        // Integer root = -1;
        // for (int node : neighbors.keySet()) {
        //     root = getRoot(node, neighbors, visited);
        //     if (root != -1) {
        //         break;
        //     }
        // }

        // if (root == -1) {
        //     return new ArrayList<>();
        // } else {
        //     return generateCycle(root, neighbors);
        // }

        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        for (int node : neighbors.keySet()) {
            List<Integer> cycle = getCycle(node, neighbors, stack, visited);
            if (!cycle.isEmpty()) {
                return cycle;
            }
        }

        return new ArrayList<>();
    }

    private List<Integer> getCycle(int next, Map<Integer, List<Integer>> neighbors, Stack<Integer> stack, Set<Integer> visited) {
        if (visited.contains(next)) {
            List<Integer> list = new ArrayList<>();
            list.add(next);

            while (stack.peek() != next) {
                list.add(stack.pop());
            }

            return list;
        }

        if (!neighbors.containsKey(next)) {
            return new ArrayList<>();
        }

        visited.add(next);
        stack.add(next);

        for (int neighbor : neighbors.get(next)) {
            List<Integer> list = getCycle(neighbor, neighbors, stack, visited);
            if (!list.isEmpty()) {
                return list;
            }
        }

        return new ArrayList<>();
    }

    private Integer getRoot(int node, Map<Integer, List<Integer>> neighbors, Set<Integer> visited) {
        if (visited.contains(node)) {
            return node;
        }

        if (!neighbors.containsKey(node)) {
            return -1;
        }

        visited.add(node);

        for (int neighbor : neighbors.get(node)) {
            int root = getRoot(neighbor, neighbors, visited);
            if (root != -1) {
                return root;
            }
        }

        visited.remove(node);
        return -1;
    }

    /// 同并查集相同，元素不连通的情况下不可使用BFS
    private int getRoot(int node, Map<Integer, List<Integer>> neighbors) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(node);
        queue.add(node);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 1; i <= len; i++) {
                int current = queue.remove();

                if (!neighbors.containsKey(current)) {
                    continue;
                }

                for (int neighbor : neighbors.get(current)) {
                    if (visited.contains(neighbor)) {
                        return neighbor;
                    } else {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }

        return -1;
    }

    private List<Integer> generateCycle(Integer root, Map<Integer, List<Integer>> neighbors) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        return generateCycle(root, neighbors, stack, visited);
    }

    private List<Integer> generateCycle(Integer root, Map<Integer, List<Integer>> neighbors, Stack<Integer> stack, Set<Integer> visited) {
        if (visited.contains(root)) {
            return new ArrayList<>(stack);
        }

        stack.push(root);
        visited.add(root);

        for (int neighbor : neighbors.get(root)) {
            List<Integer> cycle = generateCycle(neighbor, neighbors, stack, visited);
            if (!cycle.isEmpty()) {
                return cycle;
            }
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {
//        int[][] input = {{1,2}, {2,3}, {3,4}, {4,1}, {1,5}};
        int[][] input = {{1,2}, {1,3}, {2,3}};

        System.out.println(new RedundantConnectionII().findRedundantDirectedConnection(input));
    }
}
