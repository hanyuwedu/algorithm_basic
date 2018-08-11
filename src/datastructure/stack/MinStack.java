package datastructure.stack;

import java.util.Stack;

/**
 * 8/8/2018
 */
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {
        this.stack = new Stack<Integer>();
        this.min = new Stack<Integer>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        if (this.min.isEmpty() || this.min.peek() > number) {
            this.min.push(number);
            this.stack.push(number);
        } else {
            this.min.push(this.min.peek());
            this.stack.push(number);
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        int peek = stack.pop();
        min.pop();
        return peek;
    }

    /*
     * @return: An integer
     */
    public int min() {
        if (min.isEmpty()) {
            return -1;
        }
        return min.peek();
    }
}
