package datastructure.stack;

import java.util.Stack;

public class ImplementQueuebyTwoStacks {
    /**
     * 8/8/2018
     */
    public class MyQueue {
        Stack<Integer> left;
        Stack<Integer> right;

        public MyQueue() {
            this.left = new Stack<Integer>();
            this.right = new Stack<Integer>();
        }

        /*
         * @param element: An integer
         * @return: nothing
         */
        public void push(int element) {
            this.left.push(element);
        }

        /*
         * @return: An integer
         */
        public int pop() {
            if (this.right.isEmpty() && this.left.isEmpty()) {
                return -1;
            } else if (this.right.isEmpty()) {
                dump();
            }

            return right.pop();
        }

        /*
         * @return: An integer
         */
        public int top() {
            if (this.left.isEmpty() && this.right.isEmpty()) {
                return -1;
            } else if (this.right.isEmpty()) {
                dump();
            }

            return right.peek();
        }

        private void dump() {
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
        }
    }
}
