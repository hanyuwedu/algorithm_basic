package Search.bfs;

import java.util.*;

public class WordLadderII {
    /**
     * 8/13/2018
     *
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public List<List<String>> findLadders2(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList();
        if (start.equals(end)) {
            List<String> temp = new ArrayList();
            temp.add(start);
            temp.add(end);
            result.add(temp);
            return result;
        }

        Map<String, Set<String>> roadmap = new HashMap();
        Map<String, Integer> distance = new HashMap();

        bfs(start, end, dict, roadmap, distance);

        System.out.println(roadmap.toString());

        if (roadmap == null) {
            return result;
        }
        Stack<String> stack = new Stack();
        stack.add(start);

        dfs(start, end, stack, result, roadmap, distance, 0);

        return result;
    }

    private void bfs(String start, String end, Set<String> dict, Map<String, Set<String>> roadmap, Map<String, Integer> distance) {
        Queue<String> queue = new LinkedList();

        queue.add(start);
        int level = 0;

        while (!queue.isEmpty()) {
            int width = queue.size();
            for (int i = 1; i <= width; i++) {
                String current = queue.remove();

                if (!distance.containsKey(current)) {
                    distance.put(current, level);
                }


                if (current.equals(end)) {
                    return;
                }

                Set<String> alts = getAlts(current, end, dict);
                roadmap.put(current, alts);
                queue.addAll(alts);
            }
            level++;
        }

        roadmap = null;
        distance = null;
    }

    private void dfs(String current, String end, Stack<String> stack, List<List<String>> result, Map<String, Set<String>> roadmap, Map<String, Integer> distance, int level) {
        if (current.equals(end)) {
            result.add(new ArrayList(stack));
            return;
        }

        for (String next : roadmap.get(current)) {
            if (distance.containsKey(next) && distance.get(next) == level + 1) {
                stack.add(next);
                dfs(next, end, stack, result, roadmap, distance, level + 1);
                stack.pop();
            }
        }
    }

    private Set<String> getAlts(String current, String end, Set<String> dict) {
        Set<String> alts = new HashSet();
        char[] chars = current.toCharArray();

        for (int i = 0; i <= chars.length - 1; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                char temp = chars[i] ;
                chars[i] = c;
                String next = new String(chars);
                if (next.equals(end) || dict.contains(next)) {
                    alts.add(next);
                }
                chars[i] = temp;
            }
        }

        return alts;
    }



    /**
     * 8/13/2018
     *
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList();
        if (start.equals(end)) {
            List<String> temp = new ArrayList();
            temp.add(start);
            temp.add(end);
            result.add(temp);
            return result;
        }

        dict.add(end);
        Map<Integer, Set<String>> stepMap = bfs(start, end, dict);
        if (stepMap == null) {
            return result;
        }
        Stack<String> stack = new Stack();
        stack.add(start);

        dfs(start, end, stepMap, stack, result, 1);

        return result;
    }

    private Map<Integer, Set<String>> bfs(String start, String end, Set<String> dict) {
        Queue<String> queue = new LinkedList();
        Set<String> visited = new HashSet();
        Map<Integer, Set<String>> stepMap = new HashMap();

        queue.add(start);
        visited.add(start);

        int level = 1;
        while (!queue.isEmpty()) {
            int width = queue.size();
            stepMap.put(level, new HashSet());

            for (int i = 1; i <= width; i++) {
                String current = queue.remove();
                Set<String> alts = getAlterations(current, visited, dict);

                if (alts.contains(end)) {
                    stepMap.put(level, new HashSet());
                    stepMap.get(level).add(end);
                    return stepMap;
                }
                visited.addAll(alts);
                stepMap.get(level).addAll(alts);
                queue.addAll(alts);
            }
            level++;
        }

        return null;
    }



    private void dfs(String current, String end, Map<Integer, Set<String>> stepMap, Stack<String> stack, List<List<String>> result, int level) {
        if (current.equals(end)) {
            result.add(new ArrayList(stack));
            return;
        }

        Set<String> alts = getAlterations(current, new HashSet(), stepMap.get(level));
        for (String next : alts) {
            stack.add(next);
            dfs(next, end, stepMap, stack, result, level + 1);
            stack.pop();
        }
    }

    private Set<String> getAlterations(String start, Set<String> visited, Set<String> dict) {
        Set<String> alts = new HashSet();
        char[] chars = start.toCharArray();
        for (int i = 0; i <= chars.length - 1; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                char temp = chars[i];
                chars[i] = c;
                String next = new String(chars);
                if (!visited.contains(next) && dict.contains(next)) {
                    alts.add(next);
                }
                chars[i] = temp;
            }
        }

        return alts;
    }


}
