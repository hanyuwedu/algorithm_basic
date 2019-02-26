package gameday;

import java.util.Stack;

public class DecodeString {
    /**
     * 2/23/2019
     * GameDay
     * https://www.lintcode.com/problem/decode-string/description
     *
     * @param s: an expression includes numbers, letters and brackets
     * @return: a string
     */
    public String expressionExpand(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        String str = "";
        int num = 0;

        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                str += c;
            } else if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                strStack.push(str);
                numStack.push(num);

                str = "";
                num = 0;
            } else if (c == ']') {
                int count = numStack.pop();
                String temp = str;
                str = strStack.pop();

                for (int i = 1; i <= count; i++) {
                    str += temp;
                }
            } else {
                continue;
            }
        }

        return str;
    }
}
