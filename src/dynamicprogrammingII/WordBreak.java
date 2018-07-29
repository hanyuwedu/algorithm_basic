package dynamicprogrammingII;

import java.util.Set;

public class WordBreak {
    /*
     * 6/9/2018

     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return true;
        }

        if (dict == null || dict.size() == 0) {
            return false;
        }

        int n = s.length();
        boolean[] cut = new boolean[n + 1];

        cut[0] = true;
        int maxLength = dict.stream().mapToInt(String::length).max().getAsInt();

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= Math.max(i - maxLength, 0); j--) {
                String next = s.substring(j, i);
                if (cut[j] && dict.contains(next)) {
                    cut[i] = true;
                    break;
                }
            }
        }

        return cut[n];
    }
}
