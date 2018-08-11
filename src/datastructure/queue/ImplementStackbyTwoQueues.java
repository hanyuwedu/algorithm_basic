package datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackbyTwoQueues {
    /**
     * 8/10/2018
     */
    public class Stack {
        Queue<Integer> left = new LinkedList<>();
        Queue<Integer> right = new LinkedList<>();

        /*
         * @param x: An integer
         * @return: nothing
         */
        public void push(int x) {
            left.add(x);
        }

        /*
         * @return: nothing
         */
        public void pop() {
            if (left.isEmpty()) {
                return;
            }

            while (left.size() > 1) {
                right.add(left.remove());
            }
            left.remove();
            Queue<Integer> temp = new LinkedList<>();
            temp = left;
            left = right;
            right = temp;
        }

        /*
         * @return: An integer
         */
        public int top() {
            if (left.isEmpty()) {
                return -1;
            }

            while (left.size() > 1) {
                right.add(left.remove());
            }

            int peek = left.peek();
            right.add(left.remove());
            Queue<Integer> temp = new LinkedList<>();
            temp = left;
            left = right;
            right = temp;

            return peek;
        }

        /*
         * @return: True if the stack is empty
         */
        public boolean isEmpty() {
            return this.left.isEmpty() && this.right.isEmpty();
        }
    }
}
