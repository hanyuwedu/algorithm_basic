package datastructure.priorityQueue;

import java.util.*;

public class TopKFrequentWords {
    /**
     * 11/24
     * Comparable class
     *
     * @param words: an array of string
     * @param k: An integer
     * @return: an array of string
     */
    public String[] topKFrequentWords2(String[] words, int k) {
        if (words == null || words.length == 0) {
            return new String[0];
        }

        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            if (count.containsKey(word)) {
                count.put(word, count.get(word) + 1);
            } else {
                count.put(word, 1);
            }
        }

        Queue<Frequency> heap = new PriorityQueue<>();
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            heap.add(new Frequency(entry.getKey(), entry.getValue()));
        }

        String[] result = new String[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.remove().word;
        }

        return result;
    }

    private class Frequency implements Comparable<Frequency> {
        private String word;
        private int frequency;

        private Frequency(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Frequency another) {
            if (this.frequency != another.frequency) {
                return another.frequency - this.frequency;
            } else {
                return this.word.compareTo(another.word);
            }
        }
    }



    /**
     * 11/24
     * Apply collection sort by lambda function
     *
     * @param words: an array of string
     * @param k: An integer
     * @return: an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        if (words == null || words.length == 0) {
            return new String[0];
        }

        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            if (count.containsKey(word)) {
                count.put(word, count.get(word) + 1);
            } else {
                count.put(word, 1);
            }
        }

        List<String> list = new ArrayList<>();
        list.addAll(count.keySet());
        Collections.sort(list, (a, b) -> {
            if (count.get(a) != count.get(b)) {
                return count.get(b) - count.get(a);
            } else {
                return a.compareTo(b);
            }
        });

        String[] result = new String[k];
        for (int i = 0; i < k ; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
