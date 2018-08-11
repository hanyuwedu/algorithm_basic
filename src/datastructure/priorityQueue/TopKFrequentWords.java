package datastructure.priorityQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentWords {
    private class Count implements Comparable<Count> {
        String word;
        int count;

        private Count(String word, int count) {
            this.word = word;
            this.count = count;
        }

        public int compareTo(Count another) {
            if (this.count != another.count) {
                return this.count - another.count;
            } else {
                return another.word.compareTo(this.word);
            }
        }
    }

    /**
     * 8/10/2018
     *
     * @param words: an array of string
     * @param k: An integer
     * @return: an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        if (words == null || words.length == 0) {
            return new String[0];
        }

        Queue<Count> heap = new PriorityQueue<>();
        Map<String, Integer> wordcount = new HashMap<>();

        for (String word: words) {
            if (wordcount.containsKey(word)) {
                wordcount.put(word, wordcount.get(word) + 1);
            } else {
                wordcount.put(word, 1);
            }
        }

        for (String word: wordcount.keySet()) {
            heap.add(new Count(word, wordcount.get(word)));
            if (heap.size() > k) {
                heap.remove();
            }
        }

        String[] topK = new String[k];
        for (int i = 0; i <= k - 1; i++) {
            topK[k - 1 - i] = heap.remove().word;
        }

        return topK;
    }
}
