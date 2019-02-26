package gameday;

import java.util.*;

public class TopKFrequentWords {
    /**
     * 2/21/22019
     * GameDay
     * https://www.lintcode.com/problem/top-k-frequent-words/description
     *
     * @param words: an array of string
     * @param k: An integer
     * @return: an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        Map<String, Integer> frequency = new HashMap<>();
        for (String word : words) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        Queue<String> heap = new PriorityQueue<>((a, b) -> {
            if (frequency.get(a) != frequency.get(b)) {
                return frequency.get(a) - frequency.get(b);
            } else {
                return b.compareTo(a);
            }
        });

        for (String word : frequency.keySet()) {
            heap.add(word);
            while (heap.size() > k) {
                heap.remove();
            }
        }

        String[] topK = new String[k];
        for (int i = k - 1; i >= 0; i--) {
            topK[i] = heap.remove();
        }

        return topK;
    }
}
