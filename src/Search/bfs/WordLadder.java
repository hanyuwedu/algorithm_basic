package Search.bfs;

import java.util.*;

public class WordLadder {
    /**
     * 8/13/2018
     *
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start.equals(end)) {
            return 1;
        }

        if (dict == null) {
            return 0;
        }

        Set<String> visited = new HashSet();
        Queue<String> queue = new LinkedList();
        queue.add(start);
        visited.add(start);
        int level = 1;

        while (!queue.isEmpty()) {
            int width = queue.size();
            for (int i = 1; i <= width; i++) {
                String current = queue.remove();
                if (current.equals(end)) {
                    return level;
                }

                Set<String> neighbors = getNeighbors(current, dict, visited, end);
                visited.addAll(neighbors);
                queue.addAll(neighbors);
            }

            level++;
        }

        return 0;
    }

    private Set<String> getNeighbors(String current, Set<String> dict, Set<String> visited, String end) {
        Set<String> neighbors = new HashSet();
        char[] chars = current.toCharArray();
        for (int i = 0; i <= chars.length - 1; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                char temp = chars[i];
                chars[i] = c;
                String next = new String(chars);
                if ((!visited.contains(next) && dict.contains(next)) || next.equals(end)) {
                    neighbors.add(next);
                }
                chars[i] = temp;
            }
        }

        return neighbors;
    }
}
