package gameday;

import java.util.*;

public class WordLadderII {
    /**
     * 2/25/2019
     * GameDay
     * https://www.lintcode.com/problem/word-ladder-ii/description
     *
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<>();
        dict.add(end);

        Map<Integer, Set<String>> stepMap = bfs(start, end, dict);
        if (stepMap == null) {
            return result;
        }

        Stack<String> stack = new Stack<>();
        stack.push(start);

        dfs(result, stepMap, stack, 1, end);
        return result;
    }

    private Map<Integer, Set<String>> bfs(String start, String end, Set<String> dict) {
        int step = 1;
        Queue<String> queue = new LinkedList<>();
        Map<Integer, Set<String>> stepMap = new HashMap<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int len = queue.size();
            stepMap.put(step, new HashSet<>());

            for (int i = 1; i <= len; i++) {
                String current = queue.remove();
                if (current.equals(end)) {
                    return stepMap;
                }

                List<String> list = getNext(current, dict);
                for (String next : list) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                        stepMap.get(step).add(next);
                    }
                }
            }

            step++;
        }

        return null;
    }

    private void dfs(List<List<String>> result, Map<Integer, Set<String>> stepMap, Stack<String> stack, int distance, String end) {
        if (stack.peek().equals(end)) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for (String next : stepMap.get(distance)) {
            if (isChangeable(next, stack.peek())) {
                stack.push(next);
                dfs(result, stepMap, stack, distance + 1, end);
                stack.pop();
            }
        }
    }

    private boolean isChangeable(String a, String b) {
        int diff = 0;
        for (int i = 0; i <= a.length() - 1; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }

        return diff == 1;
    }

    private List<String>getNext(String current, Set<String> dict) {
        List<String> list = new ArrayList<>();

        for (String next : dict) {
            if (isChangeable(next, current)) {
                list.add(next);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        WordLadderII wl = new WordLadderII();
        String[] input = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        Set<String> dict = new HashSet<>(Arrays.asList(input));

        System.out.println(wl.findLadders("qa", "sq", dict));
    }
}
