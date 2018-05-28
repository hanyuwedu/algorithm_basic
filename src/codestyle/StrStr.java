package codestyle;

public class StrStr {
    /**
     * Break at the first unequal character
     * O(MN), slightly better than V1
     *
     * @param source: source string to be scanned.
     * @param target: target string containing the sequence of characters to match
     * @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
     */
    public int strStr(String source, String target) {
        if (source == null || target == null || source.length() < target.length()) {
            return -1;
        }

        for (int left = 0; left <= source.length() - target.length(); left++) {
            for (int right = 0; right <= target.length() ; right++) {
                if (right == target.length()) {
                    return left;
                }
                if (source.charAt(left + right) != target.charAt(right)) {
                    break;
                }
            }
        }

        return -1;
    }



    /**
     * Constantly compare two intervals
     * O(MN), friendly to understand
     *
     * @param source: source string to be scanned.
     * @param target: target string containing the sequence of characters to match
     * @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
     */
    public int strStrV1(String source, String target) {
        if (source == null || target == null || source.length() < target.length()) {
            return -1;
        }

        int start = 0;
        int size = target.length();
        while (start <= source.length() - target.length()) {
            if (source.substring(start, start + size).equals(target)) {
                return start;
            }
            start++;
        }

        return -1;
    }
}
