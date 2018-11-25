package gameday;

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

    public static void main(String[] args) {
        WordLadderII wl = new WordLadderII();
        String[] input = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        Set<String> dict = new HashSet<>(Arrays.asList(input));

        System.out.println(wl.findLadders("qa", "sq", dict));
    }
}
