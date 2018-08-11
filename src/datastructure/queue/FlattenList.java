package datastructure.queue;

import java.util.ArrayList;
import java.util.List;

public class FlattenList {
    // 8/10/2018
    // Non recursive
    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return new ArrayList<>();
        }

        boolean isAllInteger = false;

        while (!isAllInteger) {
            isAllInteger = true;
            int size = nestedList.size();

            for (int i = 1; i <= size; i++)
                if (nestedList.get(0).isInteger()) {
                    NestedInteger first = nestedList.get(0);
                    nestedList.remove(0);
                    nestedList.add(first);
                } else {
                    nestedList.addAll(nestedList.get(0).getList());
                    nestedList.remove(0);
                    isAllInteger = false;
                }
        }

        List<Integer> result = new ArrayList<>();
        for (NestedInteger next : nestedList) {
            result.add(next.getInteger());
        }

        return result;
    }


    // 9/10/2018
    // recursive 1
    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten1(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        for (NestedInteger next: nestedList) {
            result.addAll(getIntegerList(next));
        }

        return result;
    }

    private List<Integer> getIntegerList(NestedInteger next) {
        /// Base case
        List<Integer> current = new ArrayList<>();
        if (next.isInteger()) {
            current.add(next.getInteger());
            return current;
        }

        List<NestedInteger> list = next.getList();
        for (NestedInteger ni : list) {
            current.addAll(getIntegerList(ni));
        }

        return current;
    }


    // 8/10/2018
    // Recursive 2
    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten2(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        for (NestedInteger next: nestedList) {
            if (next.isInteger()) {
                result.add(next.getInteger());
            } else {
                result.addAll(flatten(next.getList()));
            }
        }

        return result;
    }


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer,
        // rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds,
        // if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds,
        // if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

}
